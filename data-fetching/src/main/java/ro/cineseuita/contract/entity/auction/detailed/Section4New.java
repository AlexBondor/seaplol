package ro.cineseuita.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "section4_1_New",
        "section4_2_New"
})
public class Section4New {

    @JsonProperty("section4_1_New")
    private Section41New section41New;
    @JsonProperty("section4_2_New")
    private Section42New section42New;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("section4_1_New")
    public Section41New getSection41New() {
        return section41New;
    }

    @JsonProperty("section4_1_New")
    public void setSection41New(Section41New section41New) {
        this.section41New = section41New;
    }

    @JsonProperty("section4_2_New")
    public Section42New getSection42New() {
        return section42New;
    }

    @JsonProperty("section4_2_New")
    public void setSection42New(Section42New section42New) {
        this.section42New = section42New;
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
