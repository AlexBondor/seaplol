package ro.cineseuita.data.essentials.directcontract.entity;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "directAcquisitionEssentials")
public class DirectAcquisitionContractEssentials {

    private Long _id;
    private String name;
    private String description;
    private Double estimatedValue;
    private Double closingValue;
    private DateTime publicationDate;
    private DateTime finalizationDate;
    private String deliveryCondition;
    private String paymentCondition;
    private CpvCodeEssentials cpvCode;
    private Long contractingAuthorityId;
    private Long supplierId;
    private List<DirectAcquisitionItemEssentials> directAcquisitionItems = null;
    private Integer year;
    private Integer sysDirectAcquisitionStateID;
    private double corruption;

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

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
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

    public Long getContractingAuthorityId() {
        return contractingAuthorityId;
    }

    public void setContractingAuthorityId(Long contractingAuthorityId) {
        this.contractingAuthorityId = contractingAuthorityId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public List<DirectAcquisitionItemEssentials> getDirectAcquisitionItems() {
        return directAcquisitionItems;
    }

    public void setDirectAcquisitionItems(List<DirectAcquisitionItemEssentials> directAcquisitionItems) {
        this.directAcquisitionItems = directAcquisitionItems;
    }

    public Integer getSysDirectAcquisitionStateID() {
        return sysDirectAcquisitionStateID;
    }

    public void setSysDirectAcquisitionStateID(Integer sysDirectAcquisitionStateID) {
        this.sysDirectAcquisitionStateID = sysDirectAcquisitionStateID;
    }

    public double getCorruption() {
        return corruption;
    }

    public void setCorruption(double corruption) {
        this.corruption = corruption;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
