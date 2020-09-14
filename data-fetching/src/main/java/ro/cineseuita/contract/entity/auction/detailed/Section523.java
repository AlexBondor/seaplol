package ro.cineseuita.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nameAndAddress",
        "isPublishingAgreed",
        "caNoticeContractId",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class Section523 {

    @JsonProperty("nameAndAddress")
    private List<NameAndAddress> nameAndAddress = null;
    @JsonProperty("isPublishingAgreed")
    private Boolean isPublishingAgreed;
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

    @JsonProperty("nameAndAddress")
    public List<NameAndAddress> getNameAndAddress() {
        return nameAndAddress;
    }

    @JsonProperty("nameAndAddress")
    public void setNameAndAddress(List<NameAndAddress> nameAndAddress) {
        this.nameAndAddress = nameAndAddress;
    }

    @JsonProperty("isPublishingAgreed")
    public Boolean getIsPublishingAgreed() {
        return isPublishingAgreed;
    }

    @JsonProperty("isPublishingAgreed")
    public void setIsPublishingAgreed(Boolean isPublishingAgreed) {
        this.isPublishingAgreed = isPublishingAgreed;
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
