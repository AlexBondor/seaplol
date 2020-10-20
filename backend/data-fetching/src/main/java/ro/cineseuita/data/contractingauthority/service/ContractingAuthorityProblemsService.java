package ro.cineseuita.data.contractingauthority.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.contractingauthority.entity.components.ContractingAuthorityProblem;
import ro.cineseuita.data.contractingauthority.entity.components.DedicatedSupplier;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDetailsRepository;
import ro.cineseuita.data.shared.entityComponents.ParticipantDetails;
import ro.cineseuita.data.supplier.entity.SupplierDetails;
import ro.cineseuita.data.supplier.entity.components.SupplierProblem;
import ro.cineseuita.data.supplier.repository.SupplierDetailsRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionState.OFERTA_ACCEPTATA;

@Service
public class ContractingAuthorityProblemsService {

    private static final double SUPPLIER_CONTRACTS_DEDICATION_PERCENTAGE = 90.0;
    private final ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository;
    private final SupplierDetailsRepository supplierDetailsRepository;
    private final DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository;

    @Autowired
    public ContractingAuthorityProblemsService(ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository, SupplierDetailsRepository supplierDetailsRepository, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository) {
        this.contractingAuthorityDetailsRepository = contractingAuthorityDetailsRepository;
        this.supplierDetailsRepository = supplierDetailsRepository;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
    }

    public void computeProblems() {
        computeDedicatedSupplierProblem();
    }

    // actually shared between suppliers and CA
    private void computeDedicatedSupplierProblem() {
        long count = contractingAuthorityDetailsRepository.count();
        AtomicInteger i = new AtomicInteger(1);
        AtomicInteger dedicatedSuppliersFound = new AtomicInteger(0);


        int soFar = 0;
        contractingAuthorityDetailsRepository.findAll().stream().skip(soFar).parallel().forEach(contractingAuthority -> {

            System.out.printf("Computing CA with id %d - %d/%d\n", contractingAuthority.getId(), i.getAndIncrement(), count);

            List<DirectAcquisitionContractDetails> contracts = directAcquisitionContractDetailsRepository.findAllBySysDirectAcquisitionStateIDAndContractingAuthorityID(
                    OFERTA_ACCEPTATA.getNumVal(), contractingAuthority.getId()
            );
            Map<Long, List<DirectAcquisitionContractDetails>> contractsGroupedBySuppliers = contracts.stream().collect(Collectors.groupingBy(DirectAcquisitionContractDetails::getSupplierId));

            contractsGroupedBySuppliers.forEach((supplierId, contractsOfSupplierForCurrentCA) -> {
                long supplierContractsForContractingAuthorityCount = contractsOfSupplierForCurrentCA.size();
                List<DirectAcquisitionContractDetails> allContractsForSupplier = directAcquisitionContractDetailsRepository.findAllBySysDirectAcquisitionStateIDAndSupplierId(OFERTA_ACCEPTATA.getNumVal(), supplierId);
                long totalNumberOfContractsOfSupplier = allContractsForSupplier.size();

                double percentageDedicatedToCA = supplierContractsForContractingAuthorityCount * 100.0 / totalNumberOfContractsOfSupplier;

                if (percentageDedicatedToCA > SUPPLIER_CONTRACTS_DEDICATION_PERCENTAGE) {
                    dedicatedSuppliersFound.incrementAndGet();

                    System.out.printf("CA %s with id %d has dedicated suppliers!\n", contractingAuthority.getName(), contractingAuthority.getId());
                    DedicatedSupplier dedicatedSupplier = formDedicatedSupplier(supplierId, contractingAuthority.getId(), contractsOfSupplierForCurrentCA, allContractsForSupplier);

                    contractingAuthority.addDedicatedSupplier(dedicatedSupplier);
                    contractingAuthority.getProblems().addProblem(ContractingAuthorityProblem.DEDICATED_SUPPLIERS);
                    contractingAuthorityDetailsRepository.save(contractingAuthority);

                    SupplierDetails supplier = supplierDetailsRepository.findById(supplierId).get();
                    supplier.getProblems().addProblem(SupplierProblem.DEDICATED_TO_ONE_CONTRACTING_AUTHORITY);
                    supplier.addDedicatedSupplier(dedicatedSupplier);
                    supplierDetailsRepository.save(supplier);
                }

            });

        });
        System.out.printf("There were a total of %d dedicated suppliers found.\n", dedicatedSuppliersFound.get());
    }

    private DedicatedSupplier formDedicatedSupplier(Long supplierId, Long contractingAuthorityId, List<DirectAcquisitionContractDetails> contractsOfSupplierForCurrentCA, List<DirectAcquisitionContractDetails> allContractsForSupplier) {
        double contractsValueForCA = contractsOfSupplierForCurrentCA.stream().mapToDouble(DirectAcquisitionContractDetails::getClosingValue).sum();
        double contractsValueSecondCurrencyForCA = contractsOfSupplierForCurrentCA.stream().mapToDouble(DirectAcquisitionContractDetails::getSecondCurrencyClosingValue).sum();
        double allContractsValue = allContractsForSupplier.stream().mapToDouble(DirectAcquisitionContractDetails::getClosingValue).sum();

        long contractsCountForCA = contractsOfSupplierForCurrentCA.size();
        long allContractsCount = allContractsForSupplier.size();

        double valuePercentage = contractsValueForCA * 100.0 / allContractsValue;
        double countPercentage = contractsCountForCA * 100.0 / allContractsCount;


        DedicatedSupplier dedicatedSupplier = new DedicatedSupplier();
        dedicatedSupplier.setSupplierId(supplierId);
        dedicatedSupplier.setContractingAuthorityId(contractingAuthorityId);
        dedicatedSupplier.setTotalContractsValueSecondCurrencyDedicatedToCA(contractsValueSecondCurrencyForCA);
        dedicatedSupplier.setTotalContractsValueDedicatedToCA(contractsValueForCA);
        dedicatedSupplier.setPercentageOfContractsValueDedicatedToCA(valuePercentage);

        dedicatedSupplier.setTotalContractsCountDedicatedToCA(contractsCountForCA);
        dedicatedSupplier.setPercentageOfContractsCountDedicatedToCA(countPercentage);


        return dedicatedSupplier;
    }
}
