package ro.cineseuita.data.contractingauthority.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "contractingAuthorityWith5kMarginContracts")
public class ContractingAuthorityWith5kMarginContracts {
    @Id
    private Long contractingAuthorityId;

    private List<DirectAcquisitionContractDetails> contracts = new ArrayList<>();

    public Long getContractingAuthorityId() {
        return contractingAuthorityId;
    }

    public void setContractingAuthorityId(Long contractingAuthorityId) {
        this.contractingAuthorityId = contractingAuthorityId;
    }

    public List<DirectAcquisitionContractDetails> getContracts() {
        return contracts;
    }

    public void setContracts(List<DirectAcquisitionContractDetails> contracts) {
        this.contracts = contracts;
    }

    public void addToContracts(DirectAcquisitionContractDetails contract) {
        this.contracts.add(contract);
    }

    public void addAllToContracts(List<DirectAcquisitionContractDetails> contracts) {
        this.contracts.addAll(contracts);
    }
}
