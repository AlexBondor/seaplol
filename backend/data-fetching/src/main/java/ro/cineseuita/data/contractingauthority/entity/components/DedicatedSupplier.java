package ro.cineseuita.data.contractingauthority.entity.components;

public class DedicatedSupplier {

    private Long supplierId;
    private String supplierName;
    private Long contractingAuthorityId;

    private Double totalContractsValueDedicatedToCA;
    private Double totalContractsValueSecondCurrencyDedicatedToCA;
    private Double percentageOfContractsValueDedicatedToCA;

    private Long totalContractsCountDedicatedToCA;
    private Double percentageOfContractsCountDedicatedToCA;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Long getContractingAuthorityId() {
        return contractingAuthorityId;
    }

    public void setContractingAuthorityId(Long contractingAuthorityId) {
        this.contractingAuthorityId = contractingAuthorityId;
    }

    public Double getTotalContractsValueDedicatedToCA() {
        return totalContractsValueDedicatedToCA;
    }

    public void setTotalContractsValueDedicatedToCA(Double totalContractsValueDedicatedToCA) {
        this.totalContractsValueDedicatedToCA = totalContractsValueDedicatedToCA;
    }

    public Double getTotalContractsValueSecondCurrencyDedicatedToCA() {
        return totalContractsValueSecondCurrencyDedicatedToCA;
    }

    public void setTotalContractsValueSecondCurrencyDedicatedToCA(Double totalContractsValueSecondCurrencyDedicatedToCA) {
        this.totalContractsValueSecondCurrencyDedicatedToCA = totalContractsValueSecondCurrencyDedicatedToCA;
    }

    public Long getTotalContractsCountDedicatedToCA() {
        return totalContractsCountDedicatedToCA;
    }

    public void setTotalContractsCountDedicatedToCA(Long totalContractsCountDedicatedToCA) {
        this.totalContractsCountDedicatedToCA = totalContractsCountDedicatedToCA;
    }

    public Double getPercentageOfContractsValueDedicatedToCA() {
        return percentageOfContractsValueDedicatedToCA;
    }

    public void setPercentageOfContractsValueDedicatedToCA(Double percentageOfContractsValueDedicatedToCA) {
        this.percentageOfContractsValueDedicatedToCA = percentageOfContractsValueDedicatedToCA;
    }

    public Double getPercentageOfContractsCountDedicatedToCA() {
        return percentageOfContractsCountDedicatedToCA;
    }

    public void setPercentageOfContractsCountDedicatedToCA(Double percentageOfContractsCountDedicatedToCA) {
        this.percentageOfContractsCountDedicatedToCA = percentageOfContractsCountDedicatedToCA;
    }
}
