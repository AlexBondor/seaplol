package ro.cineseuita.data.cpv.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.cpv.entity.components.CpvData;
import ro.cineseuita.data.cpv.entity.components.CpvDataNode;

@Document(collection = "contractingAuthorityCpvData")
public class ContractingAuthorityCpvData extends CpvData {

    @Id
    private String id;

    @Indexed
    private Long contractingAuthorityId;

    public static ContractingAuthorityCpvData formContractingAuthorityCpvDataFromCpvDataNode(CpvDataNode dataNode, Long contractingAuthorityId) {
        ContractingAuthorityCpvData contractingAuthorityCpvData = new ContractingAuthorityCpvData();
        contractingAuthorityCpvData.fillFormFromCpvDataNode(dataNode);
        contractingAuthorityCpvData.id = dataNode.getCpvCode() + " (" + contractingAuthorityId + ")";
        contractingAuthorityCpvData.contractingAuthorityId = contractingAuthorityId;
        return contractingAuthorityCpvData;
    }

    public Long getContractingAuthorityId() {
        return contractingAuthorityId;
    }

    public void setContractingAuthorityId(Long contractingAuthorityId) {
        this.contractingAuthorityId = contractingAuthorityId;
    }
}
