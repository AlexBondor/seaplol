package ro.cineseuita.data.contract.auction.entity.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "canEdit",
        "canView",
        "canDelete",
        "canModify",
        "canOpenContract",
        "canCreateContract",
        "canCorrectContract",
        "canModifyCompetitionResume"
})
public class Actions {

    @JsonProperty("canEdit")
    private Boolean canEdit;
    @JsonProperty("canView")
    private Boolean canView;
    @JsonProperty("canDelete")
    private Boolean canDelete;
    @JsonProperty("canModify")
    private Boolean canModify;
    @JsonProperty("canOpenContract")
    private Boolean canOpenContract;
    @JsonProperty("canCreateContract")
    private Boolean canCreateContract;
    @JsonProperty("canCorrectContract")
    private Boolean canCorrectContract;
    @JsonProperty("canModifyCompetitionResume")
    private Boolean canModifyCompetitionResume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("canEdit")
    public Boolean getCanEdit() {
        return canEdit;
    }

    @JsonProperty("canEdit")
    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
    }

    @JsonProperty("canView")
    public Boolean getCanView() {
        return canView;
    }

    @JsonProperty("canView")
    public void setCanView(Boolean canView) {
        this.canView = canView;
    }

    @JsonProperty("canDelete")
    public Boolean getCanDelete() {
        return canDelete;
    }

    @JsonProperty("canDelete")
    public void setCanDelete(Boolean canDelete) {
        this.canDelete = canDelete;
    }

    @JsonProperty("canModify")
    public Boolean getCanModify() {
        return canModify;
    }

    @JsonProperty("canModify")
    public void setCanModify(Boolean canModify) {
        this.canModify = canModify;
    }

    @JsonProperty("canOpenContract")
    public Boolean getCanOpenContract() {
        return canOpenContract;
    }

    @JsonProperty("canOpenContract")
    public void setCanOpenContract(Boolean canOpenContract) {
        this.canOpenContract = canOpenContract;
    }

    @JsonProperty("canCreateContract")
    public Boolean getCanCreateContract() {
        return canCreateContract;
    }

    @JsonProperty("canCreateContract")
    public void setCanCreateContract(Boolean canCreateContract) {
        this.canCreateContract = canCreateContract;
    }

    @JsonProperty("canCorrectContract")
    public Boolean getCanCorrectContract() {
        return canCorrectContract;
    }

    @JsonProperty("canCorrectContract")
    public void setCanCorrectContract(Boolean canCorrectContract) {
        this.canCorrectContract = canCorrectContract;
    }

    @JsonProperty("canModifyCompetitionResume")
    public Boolean getCanModifyCompetitionResume() {
        return canModifyCompetitionResume;
    }

    @JsonProperty("canModifyCompetitionResume")
    public void setCanModifyCompetitionResume(Boolean canModifyCompetitionResume) {
        this.canModifyCompetitionResume = canModifyCompetitionResume;
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
