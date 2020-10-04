package ro.cineseuita.data.essentials.directcontract.entity;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.essentials.directcontract.entity.components.CpvCodeEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.components.DirectAcquisitionItemEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.components.ParticipantMinimal;

import java.util.List;

@Document(collection = "directAcquisitionContractEssentials")
@CompoundIndexes({
        @CompoundIndex(name = "contractingAuthorityId", def = "{ '_id': 1, 'contractingAuthority.id': 1 }", unique = true),
        @CompoundIndex(name = "supplierId", def = "{ '_id': 1, 'supplier.id': 1 }", unique = true)
})
public class DirectAcquisitionContractEssentials {

    @Id
    private Long _id;
    private String name;
    private String description;
    private Double estimatedValue;
    private Double closingValue;
    private Double closingValueSecondCurrency;
    private DateTime publicationDate;
    private DateTime finalizationDate;
    private String deliveryCondition;
    private String paymentCondition;
    private CpvCodeEssentials cpvCode;
    private ParticipantMinimal contractingAuthority;
    private ParticipantMinimal supplier;
    private List<DirectAcquisitionItemEssentials> directAcquisitionItems = null;
    private Integer year;
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

    public Double getClosingValueSecondCurrency() {
        return closingValueSecondCurrency;
    }

    public void setClosingValueSecondCurrency(Double closingValueSecondCurrency) {
        this.closingValueSecondCurrency = closingValueSecondCurrency;
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

    public ParticipantMinimal getContractingAuthority() {
        return contractingAuthority;
    }

    public void setContractingAuthority(ParticipantMinimal contractingAuthority) {
        this.contractingAuthority = contractingAuthority;
    }

    public ParticipantMinimal getSupplier() {
        return supplier;
    }

    public void setSupplier(ParticipantMinimal supplier) {
        this.supplier = supplier;
    }

    public List<DirectAcquisitionItemEssentials> getDirectAcquisitionItems() {
        return directAcquisitionItems;
    }

    public void setDirectAcquisitionItems(List<DirectAcquisitionItemEssentials> directAcquisitionItems) {
        this.directAcquisitionItems = directAcquisitionItems;
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
