package ro.cineseuita.data.contractingauthority.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.service.DirectAcquisitionContractFetchService;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDetailsRepository;
import ro.cineseuita.data.supplier.repository.SupplierDetailsRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ContractingAuthorityProblemsService {

    private static final double SUPPLIER_CONTRACTS_DEDICATION_PERCENTAGE = 95.0;
    private final ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository;
    private final DirectAcquisitionContractFetchService directAcquisitionContractFetchService;
    private final SupplierDetailsRepository supplierDetailsRepository;

    @Autowired
    public ContractingAuthorityProblemsService(ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository, DirectAcquisitionContractFetchService directAcquisitionContractFetchService, SupplierDetailsRepository supplierDetailsRepository) {
        this.contractingAuthorityDetailsRepository = contractingAuthorityDetailsRepository;
        this.directAcquisitionContractFetchService = directAcquisitionContractFetchService;
        this.supplierDetailsRepository = supplierDetailsRepository;
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
                long totalNumberOfContractsOfSupplier = directAcquisitionContractFetchService.countAllBySysDirectAcquisitionStateIDAndSupplierId(supplierId);

                double percentageDedicatedToCA = supplierContractsForContractingAuthorityCount * 100.0 / totalNumberOfContractsOfSupplier;

                if (percentageDedicatedToCA > SUPPLIER_CONTRACTS_DEDICATION_PERCENTAGE) {

                }

            });

        });
    }
}
