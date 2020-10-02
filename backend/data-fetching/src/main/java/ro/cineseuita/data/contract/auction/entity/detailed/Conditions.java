package ro.cineseuita.data.contract.auction.entity.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "hasCompetitionResumeSection"
})
public class Conditions {

    @JsonProperty("hasCompetitionResumeSection")
    private Boolean hasCompetitionResumeSection;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hasCompetitionResumeSection")
    public Boolean getHasCompetitionResumeSection() {
        return hasCompetitionResumeSection;
    }

    @JsonProperty("hasCompetitionResumeSection")
    public void setHasCompetitionResumeSection(Boolean hasCompetitionResumeSection) {
        this.hasCompetitionResumeSection = hasCompetitionResumeSection;
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
