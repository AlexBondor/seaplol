package ro.cineseuita.data.essentials.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;

@Service
public class ContractingAuthorityEssentialsMapperService {

    @Autowired
    public ContractingAuthorityEssentialsMapperService() {
    }

    public ContractingAuthorityEssentials mapToContractingAuthorityWithContractsEssentials(ContractingAuthorityDetails contractingAuthorityDetails) {
        ContractingAuthorityEssentials contractingAuthorityEssentials = new ContractingAuthorityEssentials();

        contractingAuthorityEssentials.set_id(contractingAuthorityDetails.getId());
        contractingAuthorityEssentials.setName(contractingAuthorityDetails.getName());
        contractingAuthorityEssentials.setCui(contractingAuthorityDetails.getCui());
        contractingAuthorityEssentials.setLegalRepresentative(contractingAuthorityDetails.getRegistration().getLegalRepresentative());
        contractingAuthorityEssentials.setAddress(contractingAuthorityDetails.getAddress());

        contractingAuthorityEssentials.setProblems(contractingAuthorityDetails.getProblems().getProblems());
        contractingAuthorityEssentials.setProblemsCount(contractingAuthorityDetails.getProblems().getProblemsCount());
        contractingAuthorityEssentials.setDedicatedSuppliers(contractingAuthorityDetails.getDedicatedSupplierList());

        return contractingAuthorityEssentials;
    }

}
