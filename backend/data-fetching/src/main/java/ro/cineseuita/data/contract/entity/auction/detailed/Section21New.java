package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.data.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "contractTitle",
        "referenceNumber",
        "mainCPVCode",
        "sysAcquisitionContractType",
        "shortDescription",
        "hasLots",
        "shouldShowSection217",
        "totalAcquisitionValue",
        "totalRONAcquisitionValueForPAAP",
        "lowestOffer",
        "highestOffer",
        "currency",
        "canEdit",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class Section21New {

    @JsonProperty("contractTitle")
    private String contractTitle;
    @JsonProperty("referenceNumber")
    private String referenceNumber;
    @JsonProperty("mainCPVCode")
    private GenericSeapData mainCPVCode;
    @JsonProperty("sysAcquisitionContractType")
    private GenericSeapData sysAcquisitionContractType;
    @JsonProperty("shortDescription")
    private String shortDescription;
    @JsonProperty("hasLots")
    private Boolean hasLots;
    @JsonProperty("shouldShowSection217")
    private Boolean shouldShowSection217;
    @JsonProperty("totalAcquisitionValue")
    private Double totalAcquisitionValue;
    @JsonProperty("totalRONAcquisitionValueForPAAP")
    private Double totalRONAcquisitionValueForPAAP;
    @JsonProperty("lowestOffer")
    private Double lowestOffer;
    @JsonProperty("highestOffer")
    private Double highestOffer;
    @JsonProperty("currency")
    private GenericSeapData currency;
    @JsonProperty("canEdit")
    private Boolean canEdit;
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

    @JsonProperty("contractTitle")
    public String getContractTitle() {
        return contractTitle;
    }

    @JsonProperty("contractTitle")
    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    @JsonProperty("referenceNumber")
    public String getReferenceNumber() {
        return referenceNumber;
    }

    @JsonProperty("referenceNumber")
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    @JsonProperty("mainCPVCode")
    public GenericSeapData getMainCPVCode() {
        return mainCPVCode;
    }

    @JsonProperty("mainCPVCode")
    public void setMainCPVCode(GenericSeapData mainCPVCode) {
        this.mainCPVCode = mainCPVCode;
    }

    @JsonProperty("sysAcquisitionContractType")
    public GenericSeapData getSysAcquisitionContractType() {
        return sysAcquisitionContractType;
    }

    @JsonProperty("sysAcquisitionContractType")
    public void setSysAcquisitionContractType(GenericSeapData sysAcquisitionContractType) {
        this.sysAcquisitionContractType = sysAcquisitionContractType;
    }

    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("hasLots")
    public Boolean getHasLots() {
        return hasLots;
    }

    @JsonProperty("hasLots")
    public void setHasLots(Boolean hasLots) {
        this.hasLots = hasLots;
    }

    @JsonProperty("shouldShowSection217")
    public Boolean getShouldShowSection217() {
        return shouldShowSection217;
    }

    @JsonProperty("shouldShowSection217")
    public void setShouldShowSection217(Boolean shouldShowSection217) {
        this.shouldShowSection217 = shouldShowSection217;
    }

    @JsonProperty("totalAcquisitionValue")
    public Double getTotalAcquisitionValue() {
        return totalAcquisitionValue;
    }

    @JsonProperty("totalAcquisitionValue")
    public void setTotalAcquisitionValue(Double totalAcquisitionValue) {
        this.totalAcquisitionValue = totalAcquisitionValue;
    }

    @JsonProperty("totalRONAcquisitionValueForPAAP")
    public Double getTotalRONAcquisitionValueForPAAP() {
        return totalRONAcquisitionValueForPAAP;
    }

    @JsonProperty("totalRONAcquisitionValueForPAAP")
    public void setTotalRONAcquisitionValueForPAAP(Double totalRONAcquisitionValueForPAAP) {
        this.totalRONAcquisitionValueForPAAP = totalRONAcquisitionValueForPAAP;
    }

    @JsonProperty("lowestOffer")
    public Double getLowestOffer() {
        return lowestOffer;
    }

    @JsonProperty("lowestOffer")
    public void setLowestOffer(Double lowestOffer) {
        this.lowestOffer = lowestOffer;
    }

    @JsonProperty("highestOffer")
    public Double getHighestOffer() {
        return highestOffer;
    }

    @JsonProperty("highestOffer")
    public void setHighestOffer(Double highestOffer) {
        this.highestOffer = highestOffer;
    }

    @JsonProperty("currency")
    public GenericSeapData getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(GenericSeapData currency) {
        this.currency = currency;
    }

    @JsonProperty("canEdit")
    public Boolean getCanEdit() {
        return canEdit;
    }

    @JsonProperty("canEdit")
    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
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
