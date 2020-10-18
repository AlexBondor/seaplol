package ro.cineseuita.data.contract.direct.entity;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionItem;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionProblems;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionState;
import ro.cineseuita.data.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "estimatedValue",
        "secondCurrencyEstimatedValue",
        "closingValue",
        "secondCurrencyClosingValue",
        "economyValue",
        "economySecondCurrencyValue",
        "economyPercent",
        "lossValue",
        "lossSecondCurrencyValue",
        "lossPercent",
        "publicationDate",
        "supplierDecisionDate",
        "caDecisionDate",
        "finalizationDate",
        "uniqueIdentificationCode",
        "correctionReason",
        "directAcquisitionID",
        "directAcquisitionName",
        "directAcquisitionDescription",
        "cpvCode",
        "deliveryCondition",
        "paymentCondition",
        "supplierId",
        "supplierDecisionDeadline",
        "caDecisionDeadline",
        "contractingAuthorityID",
        "documents",
        "directAcquisitionItems",
        "supplierRejectionReason",
        "caRejectionReason",
        "isOpenForCorrection",
        "isOpenForContractCorrection",
        "daAwardNoticeID",
        "assignedCAUser",
        "assignedSupplierUser",
        "financingType",
        "sysAcquisitionContractType",
        "sysAcquisitionContractTypeID",
        "sysEuropeanFund",
        "sysEuropeanFundID",
        "sysDirectAcquisitionState",
        "sysDirectAcquisitionStateID",
        "isExpired"
})
@Document(collection = "directAcquisitionContractDetails")
public class DirectAcquisitionContractDetails {

    @Id
    private Long _id;
    @JsonProperty("estimatedValue")
    private Double estimatedValue;
    @JsonProperty("secondCurrencyEstimatedValue")
    private Double secondCurrencyEstimatedValue;
    @JsonProperty("closingValue")
    private Double closingValue;
    @JsonProperty("secondCurrencyClosingValue")
    private Double secondCurrencyClosingValue;
    @JsonProperty("economyValue")
    private Object economyValue;
    @JsonProperty("economySecondCurrencyValue")
    private Object economySecondCurrencyValue;
    @JsonProperty("economyPercent")
    private Object economyPercent;
    @JsonProperty("lossValue")
    private Object lossValue;
    @JsonProperty("lossSecondCurrencyValue")
    private Object lossSecondCurrencyValue;
    @JsonProperty("lossPercent")
    private Object lossPercent;
    @JsonProperty("publicationDate")
    private String publicationDate;
    @JsonProperty("supplierDecisionDate")
    private String supplierDecisionDate;
    @JsonProperty("caDecisionDate")
    private String caDecisionDate;
    @JsonProperty("finalizationDate")
    private String finalizationDate;
    @JsonProperty("uniqueIdentificationCode")
    private String uniqueIdentificationCode;
    @JsonProperty("correctionReason")
    private Object correctionReason;
    @JsonProperty("directAcquisitionID")
    private Long directAcquisitionID;
    @JsonProperty("directAcquisitionName")
    private String directAcquisitionName;
    @JsonProperty("directAcquisitionDescription")
    private String directAcquisitionDescription;
    @JsonProperty("cpvCode")
    private GenericSeapData cpvCode;
    @JsonProperty("deliveryCondition")
    private String deliveryCondition;
    @JsonProperty("paymentCondition")
    private String paymentCondition;
    @JsonProperty("supplierId")
    private Long supplierId;
    @JsonProperty("supplierDecisionDeadline")
    private String supplierDecisionDeadline;
    @JsonProperty("caDecisionDeadline")
    private String caDecisionDeadline;
    @JsonProperty("contractingAuthorityID")
    private Long contractingAuthorityID;
    @JsonProperty("documents")
    private List<Object> documents = null;
    @JsonProperty("directAcquisitionItems")
    private List<DirectAcquisitionItem> directAcquisitionItems = null;
    @JsonProperty("supplierRejectionReason")
    private Object supplierRejectionReason;
    @JsonProperty("caRejectionReason")
    private String caRejectionReason;
    @JsonProperty("isOpenForCorrection")
    private Object isOpenForCorrection;
    @JsonProperty("isOpenForContractCorrection")
    private Boolean isOpenForContractCorrection;
    @JsonProperty("daAwardNoticeID")
    private Object daAwardNoticeID;
    @JsonProperty("assignedCAUser")
    private GenericSeapData assignedCAUser;
    @JsonProperty("assignedSupplierUser")
    private Object assignedSupplierUser;
    @JsonProperty("financingType")
    private Boolean financingType;
    @JsonProperty("sysAcquisitionContractType")
    private GenericSeapData contractType;
    @JsonProperty("sysAcquisitionContractTypeID")
    private Integer sysAcquisitionContractTypeID;
    @JsonProperty("sysEuropeanFund")
    private Object sysEuropeanFund;
    @JsonProperty("sysEuropeanFundID")
    private Object sysEuropeanFundID;
    @JsonProperty("sysDirectAcquisitionState")
    private GenericSeapData sysDirectAcquisitionState;

    @JsonProperty("sysDirectAcquisitionStateID")
    private Integer sysDirectAcquisitionStateID;

    // 3 = conditii refuzate
    // 4 = conditii neacceptate la termen
    // 6 = oferta refuzata
    // 7 = oferta acceptata
    // 8 = oferta neacceptata in termen

    @JsonIgnore
    private Integer year;

    private DirectAcquisitionProblems problems = new DirectAcquisitionProblems();

    @JsonProperty("isExpired")
    private Object isExpired;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("estimatedValue")
    public Double getEstimatedValue() {
        return estimatedValue;
    }

    @JsonProperty("estimatedValue")
    public void setEstimatedValue(Double estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    @JsonProperty("secondCurrencyEstimatedValue")
    public Double getSecondCurrencyEstimatedValue() {
        return secondCurrencyEstimatedValue;
    }

    @JsonProperty("secondCurrencyEstimatedValue")
    public void setSecondCurrencyEstimatedValue(Double secondCurrencyEstimatedValue) {
        this.secondCurrencyEstimatedValue = secondCurrencyEstimatedValue;
    }

    @JsonProperty("closingValue")
    public Double getClosingValue() {
        return closingValue;
    }

    @JsonProperty("closingValue")
    public void setClosingValue(Double closingValue) {
        this.closingValue = closingValue;
    }

    @JsonProperty("secondCurrencyClosingValue")
    public Double getSecondCurrencyClosingValue() {
        return secondCurrencyClosingValue;
    }

    @JsonProperty("secondCurrencyClosingValue")
    public void setSecondCurrencyClosingValue(Double secondCurrencyClosingValue) {
        this.secondCurrencyClosingValue = secondCurrencyClosingValue;
    }

    @JsonProperty("economyValue")
    public Object getEconomyValue() {
        return economyValue;
    }

    @JsonProperty("economyValue")
    public void setEconomyValue(Object economyValue) {
        this.economyValue = economyValue;
    }

    @JsonProperty("economySecondCurrencyValue")
    public Object getEconomySecondCurrencyValue() {
        return economySecondCurrencyValue;
    }

    @JsonProperty("economySecondCurrencyValue")
    public void setEconomySecondCurrencyValue(Object economySecondCurrencyValue) {
        this.economySecondCurrencyValue = economySecondCurrencyValue;
    }

    @JsonProperty("economyPercent")
    public Object getEconomyPercent() {
        return economyPercent;
    }

    @JsonProperty("economyPercent")
    public void setEconomyPercent(Object economyPercent) {
        this.economyPercent = economyPercent;
    }

    @JsonProperty("lossValue")
    public Object getLossValue() {
        return lossValue;
    }

    @JsonProperty("lossValue")
    public void setLossValue(Object lossValue) {
        this.lossValue = lossValue;
    }

    @JsonProperty("lossSecondCurrencyValue")
    public Object getLossSecondCurrencyValue() {
        return lossSecondCurrencyValue;
    }

    @JsonProperty("lossSecondCurrencyValue")
    public void setLossSecondCurrencyValue(Object lossSecondCurrencyValue) {
        this.lossSecondCurrencyValue = lossSecondCurrencyValue;
    }

    @JsonProperty("lossPercent")
    public Object getLossPercent() {
        return lossPercent;
    }

    @JsonProperty("lossPercent")
    public void setLossPercent(Object lossPercent) {
        this.lossPercent = lossPercent;
    }

    @JsonProperty("publicationDate")
    public String getPublicationDate() {
        return publicationDate;
    }

    @JsonProperty("publicationDate")
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    @JsonProperty("supplierDecisionDate")
    public String getSupplierDecisionDate() {
        return supplierDecisionDate;
    }

    @JsonProperty("supplierDecisionDate")
    public void setSupplierDecisionDate(String supplierDecisionDate) {
        this.supplierDecisionDate = supplierDecisionDate;
    }

    @JsonProperty("caDecisionDate")
    public String getCaDecisionDate() {
        return caDecisionDate;
    }

    @JsonProperty("caDecisionDate")
    public void setCaDecisionDate(String caDecisionDate) {
        this.caDecisionDate = caDecisionDate;
    }

    @JsonProperty("finalizationDate")
    public String getFinalizationDate() {
        return finalizationDate;
    }

    @JsonProperty("finalizationDate")
    public void setFinalizationDate(String finalizationDate) {
        this.finalizationDate = finalizationDate;
    }

    @JsonProperty("uniqueIdentificationCode")
    public String getUniqueIdentificationCode() {
        return uniqueIdentificationCode;
    }

    @JsonProperty("uniqueIdentificationCode")
    public void setUniqueIdentificationCode(String uniqueIdentificationCode) {
        this.uniqueIdentificationCode = uniqueIdentificationCode;
    }

    @JsonProperty("correctionReason")
    public Object getCorrectionReason() {
        return correctionReason;
    }

    @JsonProperty("correctionReason")
    public void setCorrectionReason(Object correctionReason) {
        this.correctionReason = correctionReason;
    }

    @JsonProperty("directAcquisitionID")
    public Long getDirectAcquisitionID() {
        return directAcquisitionID;
    }

    @JsonProperty("directAcquisitionID")
    public void setDirectAcquisitionID(Long directAcquisitionID) {
        this.directAcquisitionID = directAcquisitionID;
    }

    @JsonProperty("directAcquisitionName")
    public String getDirectAcquisitionName() {
        return directAcquisitionName;
    }

    @JsonProperty("directAcquisitionName")
    public void setDirectAcquisitionName(String directAcquisitionName) {
        this.directAcquisitionName = directAcquisitionName;
    }

    @JsonProperty("directAcquisitionDescription")
    public String getDirectAcquisitionDescription() {
        return directAcquisitionDescription;
    }

    @JsonProperty("directAcquisitionDescription")
    public void setDirectAcquisitionDescription(String directAcquisitionDescription) {
        this.directAcquisitionDescription = directAcquisitionDescription;
    }

    @JsonProperty("cpvCode")
    public GenericSeapData getCpvCode() {
        return cpvCode;
    }

    @JsonProperty("cpvCode")
    public void setCpvCode(GenericSeapData cpvCode) {
        this.cpvCode = cpvCode;
    }

    @JsonProperty("deliveryCondition")
    public String getDeliveryCondition() {
        return deliveryCondition;
    }

    @JsonProperty("deliveryCondition")
    public void setDeliveryCondition(String deliveryCondition) {
        this.deliveryCondition = deliveryCondition;
    }

    @JsonProperty("paymentCondition")
    public String getPaymentCondition() {
        return paymentCondition;
    }

    @JsonProperty("paymentCondition")
    public void setPaymentCondition(String paymentCondition) {
        this.paymentCondition = paymentCondition;
    }

    @JsonProperty("supplierId")
    public Long getSupplierId() {
        return supplierId;
    }

    @JsonProperty("supplierId")
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    @JsonProperty("supplierDecisionDeadline")
    public String getSupplierDecisionDeadline() {
        return supplierDecisionDeadline;
    }

    @JsonProperty("supplierDecisionDeadline")
    public void setSupplierDecisionDeadline(String supplierDecisionDeadline) {
        this.supplierDecisionDeadline = supplierDecisionDeadline;
    }

    @JsonProperty("caDecisionDeadline")
    public String getCaDecisionDeadline() {
        return caDecisionDeadline;
    }

    @JsonProperty("caDecisionDeadline")
    public void setCaDecisionDeadline(String caDecisionDeadline) {
        this.caDecisionDeadline = caDecisionDeadline;
    }

    @JsonProperty("contractingAuthorityID")
    public Long getContractingAuthorityID() {
        return contractingAuthorityID;
    }

    @JsonProperty("contractingAuthorityID")
    public void setContractingAuthorityID(Long contractingAuthorityID) {
        this.contractingAuthorityID = contractingAuthorityID;
    }

    @JsonProperty("documents")
    public List<Object> getDocuments() {
        return documents;
    }

    @JsonProperty("documents")
    public void setDocuments(List<Object> documents) {
        this.documents = documents;
    }

    @JsonProperty("directAcquisitionItems")
    public List<DirectAcquisitionItem> getDirectAcquisitionItems() {
        return directAcquisitionItems;
    }

    @JsonProperty("directAcquisitionItems")
    public void setDirectAcquisitionItems(List<DirectAcquisitionItem> directAcquisitionItems) {
        this.directAcquisitionItems = directAcquisitionItems;
    }

    @JsonProperty("supplierRejectionReason")
    public Object getSupplierRejectionReason() {
        return supplierRejectionReason;
    }

    @JsonProperty("supplierRejectionReason")
    public void setSupplierRejectionReason(Object supplierRejectionReason) {
        this.supplierRejectionReason = supplierRejectionReason;
    }

    @JsonProperty("caRejectionReason")
    public String getCaRejectionReason() {
        return caRejectionReason;
    }

    @JsonProperty("caRejectionReason")
    public void setCaRejectionReason(String caRejectionReason) {
        this.caRejectionReason = caRejectionReason;
    }

    @JsonProperty("isOpenForCorrection")
    public Object getIsOpenForCorrection() {
        return isOpenForCorrection;
    }

    @JsonProperty("isOpenForCorrection")
    public void setIsOpenForCorrection(Object isOpenForCorrection) {
        this.isOpenForCorrection = isOpenForCorrection;
    }

    @JsonProperty("isOpenForContractCorrection")
    public Boolean getIsOpenForContractCorrection() {
        return isOpenForContractCorrection;
    }

    @JsonProperty("isOpenForContractCorrection")
    public void setIsOpenForContractCorrection(Boolean isOpenForContractCorrection) {
        this.isOpenForContractCorrection = isOpenForContractCorrection;
    }

    @JsonProperty("daAwardNoticeID")
    public Object getDaAwardNoticeID() {
        return daAwardNoticeID;
    }

    @JsonProperty("daAwardNoticeID")
    public void setDaAwardNoticeID(Object daAwardNoticeID) {
        this.daAwardNoticeID = daAwardNoticeID;
    }

    @JsonProperty("assignedCAUser")
    public GenericSeapData getAssignedCAUser() {
        return assignedCAUser;
    }

    @JsonProperty("assignedCAUser")
    public void setAssignedCAUser(GenericSeapData assignedCAUser) {
        this.assignedCAUser = assignedCAUser;
    }

    @JsonProperty("assignedSupplierUser")
    public Object getAssignedSupplierUser() {
        return assignedSupplierUser;
    }

    @JsonProperty("assignedSupplierUser")
    public void setAssignedSupplierUser(Object assignedSupplierUser) {
        this.assignedSupplierUser = assignedSupplierUser;
    }

    @JsonProperty("financingType")
    public Boolean getFinancingType() {
        return financingType;
    }

    @JsonProperty("financingType")
    public void setFinancingType(Boolean financingType) {
        this.financingType = financingType;
    }

    @JsonProperty("sysAcquisitionContractType")
    public GenericSeapData getContractType() {
        return contractType;
    }

    @JsonProperty("sysAcquisitionContractType")
    public void setContractType(GenericSeapData contractType) {
        this.contractType = contractType;
    }

    @JsonProperty("sysAcquisitionContractTypeID")
    public Integer getSysAcquisitionContractTypeID() {
        return sysAcquisitionContractTypeID;
    }

    @JsonProperty("sysAcquisitionContractTypeID")
    public void setSysAcquisitionContractTypeID(Integer sysAcquisitionContractTypeID) {
        this.sysAcquisitionContractTypeID = sysAcquisitionContractTypeID;
    }

    @JsonProperty("sysEuropeanFund")
    public Object getSysEuropeanFund() {
        return sysEuropeanFund;
    }

    @JsonProperty("sysEuropeanFund")
    public void setSysEuropeanFund(Object sysEuropeanFund) {
        this.sysEuropeanFund = sysEuropeanFund;
    }

    @JsonProperty("sysEuropeanFundID")
    public Object getSysEuropeanFundID() {
        return sysEuropeanFundID;
    }

    @JsonProperty("sysEuropeanFundID")
    public void setSysEuropeanFundID(Object sysEuropeanFundID) {
        this.sysEuropeanFundID = sysEuropeanFundID;
    }

    @JsonProperty("sysDirectAcquisitionState")
    public GenericSeapData getSysDirectAcquisitionState() {
        return sysDirectAcquisitionState;
    }

    @JsonProperty("sysDirectAcquisitionState")
    public void setSysDirectAcquisitionState(GenericSeapData sysDirectAcquisitionState) {
        this.sysDirectAcquisitionState = sysDirectAcquisitionState;
    }

    @JsonProperty("sysDirectAcquisitionStateID")
    public Integer getSysDirectAcquisitionStateID() {
        return sysDirectAcquisitionStateID;
    }

    @JsonProperty("sysDirectAcquisitionStateID")
    public void setSysDirectAcquisitionStateID(Integer sysDirectAcquisitionStateID) {
        this.sysDirectAcquisitionStateID = sysDirectAcquisitionStateID;
    }

    @JsonProperty("isExpired")
    public Object getIsExpired() {
        return isExpired;
    }

    @JsonProperty("isExpired")
    public void setIsExpired(Object isExpired) {
        this.isExpired = isExpired;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public boolean isAcceptedContract() {
        return this.getSysDirectAcquisitionStateID().equals(7);
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public boolean validForStats() {
        return this.sysDirectAcquisitionStateID == DirectAcquisitionState.OFERTA_ACCEPTATA.getNumVal();
    }

    public DirectAcquisitionProblems getProblems() {
        return problems;
    }
}
