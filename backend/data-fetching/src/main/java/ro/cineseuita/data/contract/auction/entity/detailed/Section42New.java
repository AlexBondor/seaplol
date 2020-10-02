package ro.cineseuita.data.contract.auction.entity.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "hasPreviousPublicationNotice",
        "tedModel",
        "previousPublicationNoticeNumber",
        "isCeasingDynamicAquisitions",
        "isCACeasingSendingInvitations",
        "canEdit",
        "updateTed",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class Section42New {

    @JsonProperty("hasPreviousPublicationNotice")
    private Boolean hasPreviousPublicationNotice;
    @JsonProperty("tedModel")
    private TedModel tedModel;
    @JsonProperty("previousPublicationNoticeNumber")
    private String previousPublicationNoticeNumber;
    @JsonProperty("isCeasingDynamicAquisitions")
    private Boolean isCeasingDynamicAquisitions;
    @JsonProperty("isCACeasingSendingInvitations")
    private Boolean isCACeasingSendingInvitations;
    @JsonProperty("canEdit")
    private Object canEdit;
    @JsonProperty("updateTed")
    private Boolean updateTed;
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

    @JsonProperty("hasPreviousPublicationNotice")
    public Boolean getHasPreviousPublicationNotice() {
        return hasPreviousPublicationNotice;
    }

    @JsonProperty("hasPreviousPublicationNotice")
    public void setHasPreviousPublicationNotice(Boolean hasPreviousPublicationNotice) {
        this.hasPreviousPublicationNotice = hasPreviousPublicationNotice;
    }

    @JsonProperty("tedModel")
    public TedModel getTedModel() {
        return tedModel;
    }

    @JsonProperty("tedModel")
    public void setTedModel(TedModel tedModel) {
        this.tedModel = tedModel;
    }

    @JsonProperty("previousPublicationNoticeNumber")
    public String getPreviousPublicationNoticeNumber() {
        return previousPublicationNoticeNumber;
    }

    @JsonProperty("previousPublicationNoticeNumber")
    public void setPreviousPublicationNoticeNumber(String previousPublicationNoticeNumber) {
        this.previousPublicationNoticeNumber = previousPublicationNoticeNumber;
    }

    @JsonProperty("isCeasingDynamicAquisitions")
    public Boolean getIsCeasingDynamicAquisitions() {
        return isCeasingDynamicAquisitions;
    }

    @JsonProperty("isCeasingDynamicAquisitions")
    public void setIsCeasingDynamicAquisitions(Boolean isCeasingDynamicAquisitions) {
        this.isCeasingDynamicAquisitions = isCeasingDynamicAquisitions;
    }

    @JsonProperty("isCACeasingSendingInvitations")
    public Boolean getIsCACeasingSendingInvitations() {
        return isCACeasingSendingInvitations;
    }

    @JsonProperty("isCACeasingSendingInvitations")
    public void setIsCACeasingSendingInvitations(Boolean isCACeasingSendingInvitations) {
        this.isCACeasingSendingInvitations = isCACeasingSendingInvitations;
    }

    @JsonProperty("canEdit")
    public Object getCanEdit() {
        return canEdit;
    }

    @JsonProperty("canEdit")
    public void setCanEdit(Object canEdit) {
        this.canEdit = canEdit;
    }

    @JsonProperty("updateTed")
    public Boolean getUpdateTed() {
        return updateTed;
    }

    @JsonProperty("updateTed")
    public void setUpdateTed(Boolean updateTed) {
        this.updateTed = updateTed;
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
