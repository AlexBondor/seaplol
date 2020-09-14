package ro.cineseuita.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "noOfferForOpenProcedure",
        "noOfferForRestrictedProcedure",
        "bargainPurchase",
        "noticeID",
        "areProductsResearchAndStudy",
        "isForceMajeure",
        "isSupplementaryServiceCompliantOrdered",
        "isNewServiceARepetition",
        "isAssignedToAProjectContestWinner",
        "areProductsStockExchangeListed",
        "isSupplierCeasingOperations",
        "isSuppliedFromBankruptcy",
        "sysReasonForUniqueOfferer",
        "isAcquisitionDirectiveCompliant",
        "explanation",
        "canEdit",
        "unawardedSysNoticeType",
        "unawardedSysNoticeTypeId",
        "unawardedNoticeNo",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class AnnexDNew {

    @JsonProperty("noOfferForOpenProcedure")
    private Object noOfferForOpenProcedure;
    @JsonProperty("noOfferForRestrictedProcedure")
    private Object noOfferForRestrictedProcedure;
    @JsonProperty("bargainPurchase")
    private Object bargainPurchase;
    @JsonProperty("noticeID")
    private Object noticeID;
    @JsonProperty("areProductsResearchAndStudy")
    private Boolean areProductsResearchAndStudy;
    @JsonProperty("isForceMajeure")
    private Boolean isForceMajeure;
    @JsonProperty("isSupplementaryServiceCompliantOrdered")
    private Boolean isSupplementaryServiceCompliantOrdered;
    @JsonProperty("isNewServiceARepetition")
    private Boolean isNewServiceARepetition;
    @JsonProperty("isAssignedToAProjectContestWinner")
    private Boolean isAssignedToAProjectContestWinner;
    @JsonProperty("areProductsStockExchangeListed")
    private Boolean areProductsStockExchangeListed;
    @JsonProperty("isSupplierCeasingOperations")
    private Boolean isSupplierCeasingOperations;
    @JsonProperty("isSuppliedFromBankruptcy")
    private Boolean isSuppliedFromBankruptcy;
    @JsonProperty("sysReasonForUniqueOfferer")
    private Object sysReasonForUniqueOfferer;
    @JsonProperty("isAcquisitionDirectiveCompliant")
    private Boolean isAcquisitionDirectiveCompliant;
    @JsonProperty("explanation")
    private Object explanation;
    @JsonProperty("canEdit")
    private Boolean canEdit;
    @JsonProperty("unawardedSysNoticeType")
    private Object unawardedSysNoticeType;
    @JsonProperty("unawardedSysNoticeTypeId")
    private Object unawardedSysNoticeTypeId;
    @JsonProperty("unawardedNoticeNo")
    private Object unawardedNoticeNo;
    @JsonProperty("caNoticeId")
    private Long caNoticeId;
    @JsonProperty("sectionName")
    private Object sectionName;
    @JsonProperty("sectionCode")
    private Object sectionCode;
    @JsonProperty("noticePreviousPublication")
    private Object noticePreviousPublication;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("noOfferForOpenProcedure")
    public Object getNoOfferForOpenProcedure() {
        return noOfferForOpenProcedure;
    }

    @JsonProperty("noOfferForOpenProcedure")
    public void setNoOfferForOpenProcedure(Object noOfferForOpenProcedure) {
        this.noOfferForOpenProcedure = noOfferForOpenProcedure;
    }

    @JsonProperty("noOfferForRestrictedProcedure")
    public Object getNoOfferForRestrictedProcedure() {
        return noOfferForRestrictedProcedure;
    }

    @JsonProperty("noOfferForRestrictedProcedure")
    public void setNoOfferForRestrictedProcedure(Object noOfferForRestrictedProcedure) {
        this.noOfferForRestrictedProcedure = noOfferForRestrictedProcedure;
    }

    @JsonProperty("bargainPurchase")
    public Object getBargainPurchase() {
        return bargainPurchase;
    }

    @JsonProperty("bargainPurchase")
    public void setBargainPurchase(Object bargainPurchase) {
        this.bargainPurchase = bargainPurchase;
    }

    @JsonProperty("noticeID")
    public Object getNoticeID() {
        return noticeID;
    }

    @JsonProperty("noticeID")
    public void setNoticeID(Object noticeID) {
        this.noticeID = noticeID;
    }

    @JsonProperty("areProductsResearchAndStudy")
    public Boolean getAreProductsResearchAndStudy() {
        return areProductsResearchAndStudy;
    }

    @JsonProperty("areProductsResearchAndStudy")
    public void setAreProductsResearchAndStudy(Boolean areProductsResearchAndStudy) {
        this.areProductsResearchAndStudy = areProductsResearchAndStudy;
    }

    @JsonProperty("isForceMajeure")
    public Boolean getIsForceMajeure() {
        return isForceMajeure;
    }

    @JsonProperty("isForceMajeure")
    public void setIsForceMajeure(Boolean isForceMajeure) {
        this.isForceMajeure = isForceMajeure;
    }

    @JsonProperty("isSupplementaryServiceCompliantOrdered")
    public Boolean getIsSupplementaryServiceCompliantOrdered() {
        return isSupplementaryServiceCompliantOrdered;
    }

    @JsonProperty("isSupplementaryServiceCompliantOrdered")
    public void setIsSupplementaryServiceCompliantOrdered(Boolean isSupplementaryServiceCompliantOrdered) {
        this.isSupplementaryServiceCompliantOrdered = isSupplementaryServiceCompliantOrdered;
    }

    @JsonProperty("isNewServiceARepetition")
    public Boolean getIsNewServiceARepetition() {
        return isNewServiceARepetition;
    }

    @JsonProperty("isNewServiceARepetition")
    public void setIsNewServiceARepetition(Boolean isNewServiceARepetition) {
        this.isNewServiceARepetition = isNewServiceARepetition;
    }

    @JsonProperty("isAssignedToAProjectContestWinner")
    public Boolean getIsAssignedToAProjectContestWinner() {
        return isAssignedToAProjectContestWinner;
    }

    @JsonProperty("isAssignedToAProjectContestWinner")
    public void setIsAssignedToAProjectContestWinner(Boolean isAssignedToAProjectContestWinner) {
        this.isAssignedToAProjectContestWinner = isAssignedToAProjectContestWinner;
    }

    @JsonProperty("areProductsStockExchangeListed")
    public Boolean getAreProductsStockExchangeListed() {
        return areProductsStockExchangeListed;
    }

    @JsonProperty("areProductsStockExchangeListed")
    public void setAreProductsStockExchangeListed(Boolean areProductsStockExchangeListed) {
        this.areProductsStockExchangeListed = areProductsStockExchangeListed;
    }

    @JsonProperty("isSupplierCeasingOperations")
    public Boolean getIsSupplierCeasingOperations() {
        return isSupplierCeasingOperations;
    }

    @JsonProperty("isSupplierCeasingOperations")
    public void setIsSupplierCeasingOperations(Boolean isSupplierCeasingOperations) {
        this.isSupplierCeasingOperations = isSupplierCeasingOperations;
    }

    @JsonProperty("isSuppliedFromBankruptcy")
    public Boolean getIsSuppliedFromBankruptcy() {
        return isSuppliedFromBankruptcy;
    }

    @JsonProperty("isSuppliedFromBankruptcy")
    public void setIsSuppliedFromBankruptcy(Boolean isSuppliedFromBankruptcy) {
        this.isSuppliedFromBankruptcy = isSuppliedFromBankruptcy;
    }

    @JsonProperty("sysReasonForUniqueOfferer")
    public Object getSysReasonForUniqueOfferer() {
        return sysReasonForUniqueOfferer;
    }

    @JsonProperty("sysReasonForUniqueOfferer")
    public void setSysReasonForUniqueOfferer(Object sysReasonForUniqueOfferer) {
        this.sysReasonForUniqueOfferer = sysReasonForUniqueOfferer;
    }

    @JsonProperty("isAcquisitionDirectiveCompliant")
    public Boolean getIsAcquisitionDirectiveCompliant() {
        return isAcquisitionDirectiveCompliant;
    }

    @JsonProperty("isAcquisitionDirectiveCompliant")
    public void setIsAcquisitionDirectiveCompliant(Boolean isAcquisitionDirectiveCompliant) {
        this.isAcquisitionDirectiveCompliant = isAcquisitionDirectiveCompliant;
    }

    @JsonProperty("explanation")
    public Object getExplanation() {
        return explanation;
    }

    @JsonProperty("explanation")
    public void setExplanation(Object explanation) {
        this.explanation = explanation;
    }

    @JsonProperty("canEdit")
    public Boolean getCanEdit() {
        return canEdit;
    }

    @JsonProperty("canEdit")
    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    @JsonProperty("unawardedSysNoticeType")
    public Object getUnawardedSysNoticeType() {
        return unawardedSysNoticeType;
    }

    @JsonProperty("unawardedSysNoticeType")
    public void setUnawardedSysNoticeType(Object unawardedSysNoticeType) {
        this.unawardedSysNoticeType = unawardedSysNoticeType;
    }

    @JsonProperty("unawardedSysNoticeTypeId")
    public Object getUnawardedSysNoticeTypeId() {
        return unawardedSysNoticeTypeId;
    }

    @JsonProperty("unawardedSysNoticeTypeId")
    public void setUnawardedSysNoticeTypeId(Object unawardedSysNoticeTypeId) {
        this.unawardedSysNoticeTypeId = unawardedSysNoticeTypeId;
    }

    @JsonProperty("unawardedNoticeNo")
    public Object getUnawardedNoticeNo() {
        return unawardedNoticeNo;
    }

    @JsonProperty("unawardedNoticeNo")
    public void setUnawardedNoticeNo(Object unawardedNoticeNo) {
        this.unawardedNoticeNo = unawardedNoticeNo;
    }

    @JsonProperty("caNoticeId")
    public Long getCaNoticeId() {
        return caNoticeId;
    }

    @JsonProperty("caNoticeId")
    public void setCaNoticeId(Long caNoticeId) {
        this.caNoticeId = caNoticeId;
    }

    @JsonProperty("sectionName")
    public Object getSectionName() {
        return sectionName;
    }

    @JsonProperty("sectionName")
    public void setSectionName(Object sectionName) {
        this.sectionName = sectionName;
    }

    @JsonProperty("sectionCode")
    public Object getSectionCode() {
        return sectionCode;
    }

    @JsonProperty("sectionCode")
    public void setSectionCode(Object sectionCode) {
        this.sectionCode = sectionCode;
    }

    @JsonProperty("noticePreviousPublication")
    public Object getNoticePreviousPublication() {
        return noticePreviousPublication;
    }

    @JsonProperty("noticePreviousPublication")
    public void setNoticePreviousPublication(Object noticePreviousPublication) {
        this.noticePreviousPublication = noticePreviousPublication;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
