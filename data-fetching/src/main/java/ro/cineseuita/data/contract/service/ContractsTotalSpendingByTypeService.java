package ro.cineseuita.data.contract.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.entity.direct.ContractsTotalSpendingByType;
import ro.cineseuita.data.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.entity.direct.components.DirectAcquisitionType;
import ro.cineseuita.data.contract.repository.ContractsTotalSpendingByTypeRepository;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityTotalSpendingByType;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityRepository;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityTotalSpendingByTypeRepository;
import ro.cineseuita.data.supplier.entity.SupplierTotalSpendingByType;
import ro.cineseuita.data.supplier.repository.SupplierRepository;
import ro.cineseuita.data.supplier.repository.SupplierTotalSpendingByTypeRepository;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static ro.cineseuita.data.contract.entity.direct.components.DirectAcquisitionType.fromVal;

@Service
public class ContractsTotalSpendingByTypeService {

    private final ContractsTotalSpendingByTypeRepository contractsTotalSpendingByTypeRepository;
    private final DirectAcquisitionContractService directAcquisitionContractService;
    private final ContractingAuthorityRepository contractingAuthorityRepository;
    private final SupplierRepository supplierRepository;
    private final ContractingAuthorityTotalSpendingByTypeRepository contractingAuthorityTotalSpendingByTypeRepository;
    private final SupplierTotalSpendingByTypeRepository supplierTotalSpendingByTypeRepository;

    @Autowired
    public ContractsTotalSpendingByTypeService(ContractsTotalSpendingByTypeRepository contractsTotalSpendingByTypeRepository, DirectAcquisitionContractService directAcquisitionContractService, ContractingAuthorityRepository contractingAuthorityRepository, SupplierRepository supplierRepository, ContractingAuthorityTotalSpendingByTypeRepository contractingAuthorityTotalSpendingByTypeRepository, SupplierTotalSpendingByTypeRepository supplierTotalSpendingByTypeRepository) {
        this.contractsTotalSpendingByTypeRepository = contractsTotalSpendingByTypeRepository;
        this.directAcquisitionContractService = directAcquisitionContractService;
        this.contractingAuthorityRepository = contractingAuthorityRepository;
        this.supplierRepository = supplierRepository;
        this.contractingAuthorityTotalSpendingByTypeRepository = contractingAuthorityTotalSpendingByTypeRepository;
        this.supplierTotalSpendingByTypeRepository = supplierTotalSpendingByTypeRepository;
    }

    public void computeContractsTotalSpendingByType() {
        Map<DirectAcquisitionType, ContractsTotalSpendingByType> m = stream(DirectAcquisitionType.values())
                .collect(toMap((DirectAcquisitionType directAcquisitionType) -> directAcquisitionType, ContractsTotalSpendingByType::new, (a, b) -> b));
        AtomicInteger i = new AtomicInteger();
        directAcquisitionContractService.getAllAcceptedDirectAcquisitionContractDetailsStreamed()
                .forEach(directAcquisitionContractDetail -> {
                            System.out.printf("Computing contract %d\n", i.getAndIncrement());
                            addContractToProperBucket(m, directAcquisitionContractDetail);
                        }
                );
        contractsTotalSpendingByTypeRepository.saveAll(m.values());
    }

    public void computeContractsTotalSpendingByTypeForContractingAuthorities() {
        final long count = contractingAuthorityRepository.count();
        AtomicInteger i = new AtomicInteger();
        contractingAuthorityRepository.findAllJustIds().stream()
                .parallel()
                .forEach(contractingAuthority -> {
                            System.out.printf("Computing cpv for contracting authority %d/%d\n", i.getAndIncrement(), count);
                            Map<DirectAcquisitionType, ContractingAuthorityTotalSpendingByType> m = stream(DirectAcquisitionType.values())
                                    .collect(toMap(identity(), directAcquisitionType -> new ContractingAuthorityTotalSpendingByType(directAcquisitionType, contractingAuthority.getId())));

                            directAcquisitionContractService.getAllAcceptedDirectAcquisitionContractDetailsForContractingAuthorityStreamed(contractingAuthority.getId())
                                    .forEach(directAcquisitionContractDetails ->
                                            addContractToProperBucket(m, directAcquisitionContractDetails)
                                    );

                            contractingAuthorityTotalSpendingByTypeRepository.saveAll(m.values());
                        }
                );
    }

    public void computeContractsTotalSpendingByTypeForSuppliers() {
        final long count = supplierRepository.count();
        AtomicInteger i = new AtomicInteger();
        supplierRepository.findAllJustIds().stream()
                .parallel()
                .forEach(supplier -> {
                            System.out.printf("Computing cpv for supplier %d/%d\n", i.getAndIncrement(), count);
                            Map<DirectAcquisitionType, SupplierTotalSpendingByType> m = stream(DirectAcquisitionType.values())
                                    .collect(toMap(identity(), directAcquisitionType -> new SupplierTotalSpendingByType(directAcquisitionType, supplier.getId())));

                            directAcquisitionContractService.getAllAcceptedDirectAcquisitionContractDetailsForSupplier(supplier.getId())
                                    .forEach(directAcquisitionContractDetails ->
                                            addContractToProperBucket(m, directAcquisitionContractDetails)
                                    );

                            supplierTotalSpendingByTypeRepository.saveAll(m.values());
                        }
                );
    }

    private <T extends ContractsTotalSpendingByType> void addContractToProperBucket(Map<DirectAcquisitionType, T> m, DirectAcquisitionContractDetails directAcquisitionContractDetail) {
        DirectAcquisitionType type = fromVal(directAcquisitionContractDetail.getSysAcquisitionContractTypeID());
        Double closingValue = directAcquisitionContractDetail.getClosingValue();
        m.get(type).addToTotal(closingValue);
    }
}
