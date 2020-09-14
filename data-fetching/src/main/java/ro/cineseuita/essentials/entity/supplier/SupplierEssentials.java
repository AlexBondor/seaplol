package ro.cineseuita.essentials.entity.supplier;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.essentials.entity.DirectAcquisitionContractMinimal;
import ro.cineseuita.essentials.entity.directacquisitions.SupplierForDirectAcquisitionEssentials;

import java.util.List;

@Document(collection = "supplierEssentials")
public class SupplierEssentials extends SupplierForDirectAcquisitionEssentials {

    private List<DirectAcquisitionContractMinimal> contracts = null;
    private Double totalContractsValue;
    private Long totalContractsCount;

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

}
