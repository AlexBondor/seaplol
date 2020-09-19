package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sentToJOUE",
        "tedNoticeNo",
        "completeTedModel",
        "canEdit",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class Section0New {

    @JsonProperty("sentToJOUE")
    private Boolean sentToJOUE;
    @JsonProperty("tedNoticeNo")
    private String tedNoticeNo;
    @JsonProperty("completeTedModel")
    private CompleteTedModel completeTedModel;
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

    @JsonProperty("sentToJOUE")
    public Boolean getSentToJOUE() {
        return sentToJOUE;
    }

    @JsonProperty("sentToJOUE")
    public void setSentToJOUE(Boolean sentToJOUE) {
        this.sentToJOUE = sentToJOUE;
    }

    @JsonProperty("tedNoticeNo")
    public String getTedNoticeNo() {
        return tedNoticeNo;
    }

    @JsonProperty("tedNoticeNo")
    public void setTedNoticeNo(String tedNoticeNo) {
        this.tedNoticeNo = tedNoticeNo;
    }

    @JsonProperty("completeTedModel")
    public CompleteTedModel getCompleteTedModel() {
        return completeTedModel;
    }

    @JsonProperty("completeTedModel")
    public void setCompleteTedModel(CompleteTedModel completeTedModel) {
        this.completeTedModel = completeTedModel;
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
