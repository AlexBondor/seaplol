package ro.cineseuita.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "showPublishingAgreedSection",
        "previousPublication",
        "descriptionList",
        "canEdit",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class Section22New {

    @JsonProperty("showPublishingAgreedSection")
    private Boolean showPublishingAgreedSection;
    @JsonProperty("previousPublication")
    private Boolean previousPublication;
    @JsonProperty("descriptionList")
    private List<DescriptionList> descriptionList = null;
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

    @JsonProperty("showPublishingAgreedSection")
    public Boolean getShowPublishingAgreedSection() {
        return showPublishingAgreedSection;
    }

    @JsonProperty("showPublishingAgreedSection")
    public void setShowPublishingAgreedSection(Boolean showPublishingAgreedSection) {
        this.showPublishingAgreedSection = showPublishingAgreedSection;
    }

    @JsonProperty("previousPublication")
    public Boolean getPreviousPublication() {
        return previousPublication;
    }

    @JsonProperty("previousPublication")
    public void setPreviousPublication(Boolean previousPublication) {
        this.previousPublication = previousPublication;
    }

    @JsonProperty("descriptionList")
    public List<DescriptionList> getDescriptionList() {
        return descriptionList;
    }

    @JsonProperty("descriptionList")
    public void setDescriptionList(List<DescriptionList> descriptionList) {
        this.descriptionList = descriptionList;
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
