package ro.cineseuita.data.shared;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContract;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.contract.direct.repository.DirectAcquisitionContractRepository;
import ro.cineseuita.data.contract.direct.service.DirectAcquisitionContractFetchService;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthority;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDataRepository;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDetailsRepository;
import ro.cineseuita.data.contractingauthority.service.ContractingAuthorityMapper;
import ro.cineseuita.data.contractingauthority.service.ContractingAuthorityService;
import ro.cineseuita.data.supplier.entity.Supplier;
import ro.cineseuita.data.supplier.entity.SupplierDetails;
import ro.cineseuita.data.supplier.repository.SupplierDataRepository;
import ro.cineseuita.data.supplier.repository.SupplierDetailsRepository;
import ro.cineseuita.data.supplier.service.SupplierMapper;
import ro.cineseuita.data.supplier.service.SupplierService;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class MissingEntitiesResolutionService {

    private final DirectAcquisitionContractFetchService directAcquisitionContractFetchService;
    private final DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository;
    private final DirectAcquisitionContractRepository directAcquisitionContractRepository;
    private final SupplierDataRepository supplierDataRepository;
    private final SupplierService supplierService;
    private final SupplierDetailsRepository supplierDetailsRepository;
    private final SupplierMapper supplierMapper;
    private final ContractingAuthorityDataRepository contractingAuthorityRepository;
    private final ContractingAuthorityService contractingAuthorityService;
    private final ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository;
    private final ContractingAuthorityMapper contractingAuthorityMapper;

    @Autowired
    public MissingEntitiesResolutionService(DirectAcquisitionContractFetchService directAcquisitionContractFetchService, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository, DirectAcquisitionContractRepository directAcquisitionContractRepository, SupplierDataRepository supplierDataRepository, SupplierService supplierService, SupplierDetailsRepository supplierDetailsRepository, ContractingAuthorityDataRepository contractingAuthorityRepository, ContractingAuthorityService contractingAuthorityService, ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository) {
        this.directAcquisitionContractFetchService = directAcquisitionContractFetchService;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
        this.directAcquisitionContractRepository = directAcquisitionContractRepository;
        this.supplierDataRepository = supplierDataRepository;
        this.supplierService = supplierService;
        this.supplierDetailsRepository = supplierDetailsRepository;
        this.contractingAuthorityRepository = contractingAuthorityRepository;
        this.contractingAuthorityService = contractingAuthorityService;
        this.contractingAuthorityDetailsRepository = contractingAuthorityDetailsRepository;
        this.supplierMapper = Mappers.getMapper(SupplierMapper.class);
        this.contractingAuthorityMapper = Mappers.getMapper(ContractingAuthorityMapper.class);
    }

    public void resolveMissingContractingAuthoritiesAndSuppliers() {
        List<DirectAcquisitionContractDetails> allSuppliersAndContractingAuthorities = directAcquisitionContractDetailsRepository.findAllSuppliersAndContractingAuthorities();

        List<Long> supplierIds = allSuppliersAndContractingAuthorities.stream().mapToLong(DirectAcquisitionContractDetails::getSupplierId).boxed().distinct().collect(Collectors.toList());

        List<Long> contractingAuthoritiesIds = allSuppliersAndContractingAuthorities.stream().mapToLong(DirectAcquisitionContractDetails::getContractingAuthorityID).boxed().distinct().collect(Collectors.toList());

        List<Long> supplierIdsInDatabase = supplierDataRepository.findAllByIdsIn(supplierIds).stream().mapToLong(Supplier::getId).boxed().collect(Collectors.toList());
        supplierIds.removeAll(supplierIdsInDatabase);


        List<Long> contractingAuthorityIdsInList = contractingAuthorityRepository.findAllByIdsIn(contractingAuthoritiesIds).stream().mapToLong(ContractingAuthority::getId).boxed().collect(Collectors.toList());
        contractingAuthoritiesIds.removeAll(contractingAuthorityIdsInList);

        supplierIds.forEach(supplierId -> {
            SupplierDetails supplierDetails = supplierService.fetchSupplierDetails(supplierId);
            supplierDetailsRepository.save(supplierDetails);
            Supplier supplier = supplierMapper.fromDetailsToBasic(supplierDetails);
            supplierDataRepository.save(supplier);
        });

        contractingAuthoritiesIds.forEach(contractingAuthorityId -> {
            ContractingAuthorityDetails contractingAuthorityDetails = contractingAuthorityService.getContractingAuthorityDetails(contractingAuthorityId);
            contractingAuthorityDetailsRepository.save(contractingAuthorityDetails);
            ContractingAuthority contractingAuthority = contractingAuthorityMapper.fromDetailsToBasic(contractingAuthorityDetails);
            contractingAuthorityRepository.save(contractingAuthority);
        });
    }

    public void resolveMissingContractDetails() {
        long numberOfContracts = directAcquisitionContractRepository.count();
        int range = (int) (numberOfContracts / DirectAcquisitionContractFetchService.LIMIT) + 1;
        AtomicInteger c = new AtomicInteger(0);
        directAcquisitionContractFetchService.getAllDirectAcquisitionContractsStreamed()
                .mapToLong(DirectAcquisitionContract::get_id).boxed().forEach(id -> {
            System.out.println("Checking " + c.incrementAndGet() + "/" + numberOfContracts);
            if (!directAcquisitionContractDetailsRepository.existsById(id)) {
                System.out.println("CONTRACT " + id + " NOT FOUND, FETCHING...");
                try {
                    directAcquisitionContractFetchService.executeDetailsFetchingForContracts(Collections.singletonList(id));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("DONE");
    }

}
