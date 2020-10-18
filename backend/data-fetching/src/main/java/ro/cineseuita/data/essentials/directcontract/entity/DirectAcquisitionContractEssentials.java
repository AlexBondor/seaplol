package ro.cineseuita.data.essentials.directcontract.entity;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionProblem;
import ro.cineseuita.data.essentials.directcontract.entity.components.CpvCodeEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.components.DirectAcquisitionItemEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.components.ParticipantMinimal;

import java.util.List;
import java.util.Set;

@Document(collection = "directAcquisitionContractEssentials")
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
    @Indexed
    private Long contractingAuthorityId;
    @Indexed
    private Long supplierId;
    private List<DirectAcquisitionItemEssentials> directAcquisitionItems = null;
    private Integer year;
    private Set<DirectAcquisitionProblem> problems;
    @Indexed
    private Long problemsCount;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setProblems(Set<DirectAcquisitionProblem> problems) {
        this.problems = problems;
    }

    public Set<DirectAcquisitionProblem> getProblems() {
        return problems;
    }

    public void setProblemsCount(Long problemsCount) {
        this.problemsCount = problemsCount;
    }

    public Long getProblemsCount() {
        return problemsCount;
    }
}
