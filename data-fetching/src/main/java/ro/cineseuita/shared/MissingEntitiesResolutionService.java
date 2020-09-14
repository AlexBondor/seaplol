package ro.cineseuita.shared;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.contract.entity.direct.DirectAcquisitionContract;
import ro.cineseuita.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.contract.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.contract.repository.DirectAcquisitionContractRepository;
import ro.cineseuita.contract.service.DirectAcquisitionContractService;
import ro.cineseuita.contractingauthority.entity.ContractingAuthority;
import ro.cineseuita.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.contractingauthority.repository.ContractingAuthorityDetailsRepository;
import ro.cineseuita.contractingauthority.repository.ContractingAuthorityRepository;
import ro.cineseuita.contractingauthority.service.ContractingAuthorityMapper;
import ro.cineseuita.contractingauthority.service.ContractingAuthorityService;
import ro.cineseuita.supplier.entity.Supplier;
import ro.cineseuita.supplier.entity.SupplierDetails;
import ro.cineseuita.supplier.repository.SupplierDetailsRepository;
import ro.cineseuita.supplier.repository.SupplierRepository;
import ro.cineseuita.supplier.service.SupplierMapper;
import ro.cineseuita.supplier.service.SupplierService;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static ro.cineseuita.contract.service.DirectAcquisitionContractService.LIMIT;

@Service
public class MissingEntitiesResolutionService {

    private final DirectAcquisitionContractService directAcquisitionContractService;
    private final DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository;
    private final DirectAcquisitionContractRepository directAcquisitionContractRepository;
    private final SupplierRepository supplierRepository;
    private final SupplierService supplierService;
    private final SupplierDetailsRepository supplierDetailsRepository;
    private final SupplierMapper supplierMapper;
    private final ContractingAuthorityRepository contractingAuthorityRepository;
    private final ContractingAuthorityService contractingAuthorityService;
    private final ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository;
    private final ContractingAuthorityMapper contractingAuthorityMapper;

    @Autowired
    public MissingEntitiesResolutionService(DirectAcquisitionContractService directAcquisitionContractService, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository, DirectAcquisitionContractRepository directAcquisitionContractRepository, SupplierRepository supplierRepository, SupplierService supplierService, SupplierDetailsRepository supplierDetailsRepository, ContractingAuthorityRepository contractingAuthorityRepository, ContractingAuthorityService contractingAuthorityService, ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository) {
        this.directAcquisitionContractService = directAcquisitionContractService;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
        this.directAcquisitionContractRepository = directAcquisitionContractRepository;
        this.supplierRepository = supplierRepository;
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

        List<Long> supplierIdsInDatabase = supplierRepository.findAllByIdsIn(supplierIds).stream().mapToLong(Supplier::getId).boxed().collect(Collectors.toList());
        supplierIds.removeAll(supplierIdsInDatabase);


        List<Long> contractingAuthorityIdsInList = contractingAuthorityRepository.findAllByIdsIn(contractingAuthoritiesIds).stream().mapToLong(ContractingAuthority::getId).boxed().collect(Collectors.toList());
        contractingAuthoritiesIds.removeAll(contractingAuthorityIdsInList);

        supplierIds.forEach(supplierId -> {
            SupplierDetails supplierDetails = supplierService.getSupplierDetails(supplierId);
            supplierDetailsRepository.save(supplierDetails);
            Supplier supplier = supplierMapper.fromDetailsToBasic(supplierDetails);
            supplierRepository.save(supplier);
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
        int range = (int) (numberOfContracts / LIMIT) + 1;
        AtomicInteger c = new AtomicInteger(0);
        directAcquisitionContractService.getAllDirectAcquisitionContractsStreamed()
                .mapToLong(DirectAcquisitionContract::get_id).boxed().forEach(id -> {
            System.out.println("Checking " + c.incrementAndGet() + "/" + numberOfContracts);
            if (!directAcquisitionContractDetailsRepository.existsById(id)) {
                System.out.println("CONTRACT " + id + " NOT FOUND, FETCHING...");
                try {
                    directAcquisitionContractService.executeDetailsFetchingForContracts(Collections.singletonList(id));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("DONE");
    }

}
