package ro.cineseuita.cpv.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.cpv.entity.components.CpvDataNode;

@Document(collection = "cpvDataForContractingAuthority")
public class CpvDataForContractingAuthority extends CpvDataNode {

    private Long contractingAuthorityId;

    public Long getContractingAuthorityId() {
        return contractingAuthorityId;
    }

    public void setContractingAuthorityId(Long contractingAuthorityId) {
        this.contractingAuthorityId = contractingAuthorityId;
    }
}
