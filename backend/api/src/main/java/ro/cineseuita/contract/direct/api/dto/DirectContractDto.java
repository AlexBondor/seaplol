package ro.cineseuita.contract.direct.api.dto;

import org.joda.time.DateTime;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.components.CpvCodeEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.components.DirectAcquisitionItemEssentials;
import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;

import java.util.List;

public class DirectContractDto {

    private Long id;
    private String name;
    private String description;
    private Double estimatedValue;
    private Double closingValue;
    private DateTime publicationDate;
    private DateTime finalizationDate;
    private String deliveryCondition;
    private String paymentCondition;
    private CpvCodeEssentials cpvCode;
    private ContractingAuthorityEssentials contractingAuthority; // Todo: lasam aici? prea mult? sau doar id-uri?
    private SupplierEssentials supplier; // Todo: lasam aici? prea mult? sau doar id-uri?
    private List<DirectAcquisitionItemEssentials> directContractItems = null;

    public Double getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(Double estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public Double getClosingValue() {
        return closingValue;
    }

    public void setClosingValue(Double closingValue) {
        this.closingValue = closingValue;
    }

    public DateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(DateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public DateTime getFinalizationDate() {
        return finalizationDate;
    }

    public void setFinalizationDate(DateTime finalizationDate) {
        this.finalizationDate = finalizationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeliveryCondition() {
        return deliveryCondition;
    }

    public void setDeliveryCondition(String deliveryCondition) {
        this.deliveryCondition = deliveryCondition;
    }

    public String getPaymentCondition() {
        return paymentCondition;
    }

    public void setPaymentCondition(String paymentCondition) {
        this.paymentCondition = paymentCondition;
    }

    public CpvCodeEssentials getCpvCode() {
        return cpvCode;
    }

    public void setCpvCode(CpvCodeEssentials cpvCode) {
        this.cpvCode = cpvCode;
    }

    public ContractingAuthorityEssentials getContractingAuthority() {
        return contractingAuthority;
    }

    public void setContractingAuthority(ContractingAuthorityEssentials contractingAuthority) {
        this.contractingAuthority = contractingAuthority;
    }

    public SupplierEssentials getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEssentials supplier) {
        this.supplier = supplier;
    }

    public List<DirectAcquisitionItemEssentials> getDirectContractItems() {
        return directContractItems;
    }

    public void setDirectContractItems(List<DirectAcquisitionItemEssentials> directContractItems) {
        this.directContractItems = directContractItems;
    }
}
