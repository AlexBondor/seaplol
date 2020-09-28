package ro.cineseuita.data.essentials.contractingauthority.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractMinimal;
import ro.cineseuita.data.essentials.directcontract.entity.ContractingAuthorityForDirectAcquisitionEssentials;

import java.util.List;

@Document(collection = "contractingAuthorityEssentials")
public class ContractingAuthorityEssentials extends ContractingAuthorityForDirectAcquisitionEssentials {

    private List<DirectAcquisitionContractMinimal> contracts = null;
    private Double totalContractsValue;
    private Long totalContractsCount;
    private Long cityStatsId;

    public List<DirectAcquisitionContractMinimal> getContracts() {
        return contracts;
    }

    public void setContracts(List<DirectAcquisitionContractMinimal> contracts) {
        this.contracts = contracts;
    }

    public Double getTotalContractsValue() {
        return totalContractsValue;
    }

    public void setTotalContractsValue(Double totalContractsValue) {
        this.totalContractsValue = totalContractsValue;
    }

    public Long getTotalContractsCount() {
        return totalContractsCount;
    }

    public void setTotalContractsCount(Long totalContractsCount) {
        this.totalContractsCount = totalContractsCount;
    }

    public Long getCityStatsId() {
        return cityStatsId;
    }

    public void setCityStatsId(Long cityStatsId) {
        this.cityStatsId = cityStatsId;
    }
}
