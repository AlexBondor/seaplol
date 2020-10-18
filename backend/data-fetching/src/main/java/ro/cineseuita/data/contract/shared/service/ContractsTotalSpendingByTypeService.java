package ro.cineseuita.data.contract.shared.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionType;
import ro.cineseuita.data.contract.direct.service.DirectAcquisitionContractFetchService;
import ro.cineseuita.data.contract.shared.entity.ContractsTotalSpendingByType;
import ro.cineseuita.data.contract.shared.repository.ContractsTotalSpendingByTypeRepository;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityTotalSpendingByType;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDataRepository;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityTotalSpendingByTypeRepository;
import ro.cineseuita.data.supplier.entity.SupplierTotalSpendingByType;
import ro.cineseuita.data.supplier.repository.SupplierDataRepository;
import ro.cineseuita.data.supplier.repository.SupplierTotalSpendingByTypeRepository;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;
import static ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionType.fromVal;

@Service
public class ContractsTotalSpendingByTypeService {

    private final ContractsTotalSpendingByTypeRepository contractsTotalSpendingByTypeRepository;
    private final DirectAcquisitionContractFetchService directAcquisitionContractFetchService;
    private final ContractingAuthorityDataRepository contractingAuthorityRepository;
    private final SupplierDataRepository supplierDataRepository;
    private final ContractingAuthorityTotalSpendingByTypeRepository contractingAuthorityTotalSpendingByTypeRepository;
    private final SupplierTotalSpendingByTypeRepository supplierTotalSpendingByTypeRepository;

    @Autowired
    public ContractsTotalSpendingByTypeService(ContractsTotalSpendingByTypeRepository contractsTotalSpendingByTypeRepository, DirectAcquisitionContractFetchService directAcquisitionContractFetchService, ContractingAuthorityDataRepository contractingAuthorityRepository, SupplierDataRepository supplierDataRepository, ContractingAuthorityTotalSpendingByTypeRepository contractingAuthorityTotalSpendingByTypeRepository, SupplierTotalSpendingByTypeRepository supplierTotalSpendingByTypeRepository) {
        this.contractsTotalSpendingByTypeRepository = contractsTotalSpendingByTypeRepository;
        this.directAcquisitionContractFetchService = directAcquisitionContractFetchService;
        this.contractingAuthorityRepository = contractingAuthorityRepository;
        this.supplierDataRepository = supplierDataRepository;
        this.contractingAuthorityTotalSpendingByTypeRepository = contractingAuthorityTotalSpendingByTypeRepository;
        this.supplierTotalSpendingByTypeRepository = supplierTotalSpendingByTypeRepository;
    }

    public void computeContractsTotalSpendingByType() {
        Map<DirectAcquisitionType, ContractsTotalSpendingByType> m = stream(DirectAcquisitionType.values())
                .collect(toMap((DirectAcquisitionType directAcquisitionType) -> directAcquisitionType, ContractsTotalSpendingByType::new, (a, b) -> b));
        AtomicInteger i = new AtomicInteger();
        directAcquisitionContractFetchService.getAllAcceptedDirectAcquisitionContractDetailsStreamed()
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

                            directAcquisitionContractFetchService.getAllAcceptedDirectAcquisitionContractDetailsForContractingAuthorityStreamed(contractingAuthority.getId())
                                    .forEach(directAcquisitionContractDetails ->
                                            addContractToProperBucket(m, directAcquisitionContractDetails)
                                    );

                            contractingAuthorityTotalSpendingByTypeRepository.saveAll(m.values());
                        }
                );
    }

    public void computeContractsTotalSpendingByTypeForSuppliers() {
        final long count = supplierDataRepository.count();
        AtomicInteger i = new AtomicInteger();
        supplierDataRepository.findAllJustIds().stream()
                .parallel()
                .forEach(supplier -> {
                            System.out.printf("Computing cpv for supplier %d/%d\n", i.getAndIncrement(), count);
                            Map<DirectAcquisitionType, SupplierTotalSpendingByType> m = stream(DirectAcquisitionType.values())
                                    .collect(toMap(identity(), directAcquisitionType -> new SupplierTotalSpendingByType(directAcquisitionType, supplier.getId())));

                            directAcquisitionContractFetchService.getAllAcceptedDirectAcquisitionContractDetailsForSupplier(supplier.getId())
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
