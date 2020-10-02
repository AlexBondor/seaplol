package ro.cineseuita.data.contract.auction.entity.detailed;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.data.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isSubcontractingPossible",
        "subcontractedValueNoVAT",
        "subcontractedPercent",
        "currency",
        "shortDescription",
        "caNoticeContractId",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class Section525 {

    @JsonProperty("isSubcontractingPossible")
    private Boolean isSubcontractingPossible;
    @JsonProperty("subcontractedValueNoVAT")
    private Object subcontractedValueNoVAT;
    @JsonProperty("subcontractedPercent")
    private Object subcontractedPercent;
    @JsonProperty("currency")
    private GenericSeapData currency;
    @JsonProperty("shortDescription")
    private Object shortDescription;
    @JsonProperty("caNoticeContractId")
    private Long caNoticeContractId;
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

    @JsonProperty("isSubcontractingPossible")
    public Boolean getIsSubcontractingPossible() {
        return isSubcontractingPossible;
    }

    @JsonProperty("isSubcontractingPossible")
    public void setIsSubcontractingPossible(Boolean isSubcontractingPossible) {
        this.isSubcontractingPossible = isSubcontractingPossible;
    }

    @JsonProperty("subcontractedValueNoVAT")
    public Object getSubcontractedValueNoVAT() {
        return subcontractedValueNoVAT;
    }

    @JsonProperty("subcontractedValueNoVAT")
    public void setSubcontractedValueNoVAT(Object subcontractedValueNoVAT) {
        this.subcontractedValueNoVAT = subcontractedValueNoVAT;
    }

    @JsonProperty("subcontractedPercent")
    public Object getSubcontractedPercent() {
        return subcontractedPercent;
    }

    @JsonProperty("subcontractedPercent")
    public void setSubcontractedPercent(Object subcontractedPercent) {
        this.subcontractedPercent = subcontractedPercent;
    }

    @JsonProperty("currency")
    public GenericSeapData getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(GenericSeapData currency) {
        this.currency = currency;
    }

    @JsonProperty("shortDescription")
    public Object getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("shortDescription")
    public void setShortDescription(Object shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("caNoticeContractId")
    public Long getCaNoticeContractId() {
        return caNoticeContractId;
    }

    @JsonProperty("caNoticeContractId")
    public void setCaNoticeContractId(Long caNoticeContractId) {
        this.caNoticeContractId = caNoticeContractId;
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
