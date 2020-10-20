package ro.cineseuita.data.contractingauthority.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.service.DirectAcquisitionContractFetchService;
import ro.cineseuita.data.contractingauthority.entity.components.DedicatedSupplier;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDetailsRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ContractingAuthorityProblemsService {

    private static final double SUPPLIER_CONTRACTS_DEDICATION_PERCENTAGE = 95.0;
    private final ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository;
    private final DirectAcquisitionContractFetchService directAcquisitionContractFetchService;

    @Autowired
    public ContractingAuthorityProblemsService(ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository, DirectAcquisitionContractFetchService directAcquisitionContractFetchService) {
        this.contractingAuthorityDetailsRepository = contractingAuthorityDetailsRepository;
        this.directAcquisitionContractFetchService = directAcquisitionContractFetchService;
    }

    public void computeProblems() {
        computeDedicatedSupplierProblem();
    }

    private void computeDedicatedSupplierProblem() {
        contractingAuthorityDetailsRepository.findAll().stream().parallel().forEach(contractingAuthority -> {

            List<DirectAcquisitionContractDetails> contracts = directAcquisitionContractFetchService.getAllAcceptedDirectAcquisitionContractDetailsForContractingAuthority(contractingAuthority.getId());
            Map<Long, List<DirectAcquisitionContractDetails>> contractsGroupedBySuppliers = contracts.stream().collect(Collectors.groupingBy(DirectAcquisitionContractDetails::getSupplierId));

            contractsGroupedBySuppliers.forEach((supplierId, contractsOfSupplierForCurrentCA) -> {
                long supplierContractsForContractingAuthorityCount = contractsOfSupplierForCurrentCA.size();
                List<DirectAcquisitionContractDetails> allContractsForSupplier = directAcquisitionContractFetchService.getAllAcceptedDirectAcquisitionContractDetailsForSupplier(supplierId).collect(toList());
                long totalNumberOfContractsOfSupplier = allContractsForSupplier.size();

                double percentageDedicatedToCA = supplierContractsForContractingAuthorityCount * 100.0 / totalNumberOfContractsOfSupplier;

                if (percentageDedicatedToCA > SUPPLIER_CONTRACTS_DEDICATION_PERCENTAGE) {
                    contractingAuthority.addDedicatedSupplier(formDedicatedSupplier(supplierId, contractingAuthority.getId(), contractsOfSupplierForCurrentCA, allContractsForSupplier));
                    contractingAuthorityDetailsRepository.save(contractingAuthority);


                }

            });

        });
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
