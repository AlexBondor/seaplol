package ro.cineseuita.data.contractingauthority.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.contract.entity.direct.ContractsTotalSpendingByType;
import ro.cineseuita.data.contract.entity.direct.components.DirectAcquisitionType;

@Document(collection = "contractingAuthorityTotalSpendingByType")
public class ContractingAuthorityTotalSpendingByType extends ContractsTotalSpendingByType {

    private Long contractingAuthorityId;

    public ContractingAuthorityTotalSpendingByType(DirectAcquisitionType type, Long contractingAuthorityId) {
        super(type);
        this.contractingAuthorityId = contractingAuthorityId;
        this.id = contractingAuthorityId + " - " + type.toString();
    }

    public Long getContractingAuthorityId() {
        return contractingAuthorityId;
    }

    public void setContractingAuthorityId(Long contractingAuthorityId) {
        this.contractingAuthorityId = contractingAuthorityId;
    }


}
