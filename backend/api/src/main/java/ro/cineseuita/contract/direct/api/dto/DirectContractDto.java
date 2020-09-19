package ro.cineseuita.contract.direct.api.dto;

import org.joda.time.DateTime;
import ro.cineseuita.contract.direct.entity.DirectContractItem;
import ro.cineseuita.contractingauthority.entity.ContractingAuthority;
import ro.cineseuita.shared.CpvCode;
import ro.cineseuita.supplier.entity.Supplier;

import java.util.List;

public class DirectContractDto {

    private Integer id;
    private String name;
    private String description;
    private Double estimatedValue;
    private Double closingValue;
    private DateTime publicationDate;
    private DateTime finalizationDate;
    private String deliveryCondition;
    private String paymentCondition;
    private CpvCode cpvCode;
    private ContractingAuthority contractingAuthority; // Todo: lasam aici? prea mult? sau doar id-uri?
    private Supplier supplier; // Todo: lasam aici? prea mult? sau doar id-uri?
    private List<DirectContractItem> directContractItems = null;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public CpvCode getCpvCode() {
        return cpvCode;
    }

    public void setCpvCode(CpvCode cpvCode) {
        this.cpvCode = cpvCode;
    }

    public ContractingAuthority getContractingAuthority() {
        return contractingAuthority;
    }

    public void setContractingAuthority(ContractingAuthority contractingAuthority) {
        this.contractingAuthority = contractingAuthority;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<DirectContractItem> getDirectContractItems() {
        return directContractItems;
    }

    public void setDirectContractItems(List<DirectContractItem> directContractItems) {
        this.directContractItems = directContractItems;
    }
}
