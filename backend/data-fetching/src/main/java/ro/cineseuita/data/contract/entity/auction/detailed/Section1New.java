package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "section1_1",
        "section1_2_New",
        "section1_4_New",
        "section1_5"
})
public class Section1New {

    @JsonProperty("section1_1")
    private Section11 section11;
    @JsonProperty("section1_2_New")
    private Section12New section12New;
    @JsonProperty("section1_4_New")
    private Section14New section14New;
    @JsonProperty("section1_5")
    private Section15 section15;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("section1_1")
    public Section11 getSection11() {
        return section11;
    }

    @JsonProperty("section1_1")
    public void setSection11(Section11 section11) {
        this.section11 = section11;
    }

    @JsonProperty("section1_2_New")
    public Section12New getSection12New() {
        return section12New;
    }

    @JsonProperty("section1_2_New")
    public void setSection12New(Section12New section12New) {
        this.section12New = section12New;
    }

    @JsonProperty("section1_4_New")
    public Section14New getSection14New() {
        return section14New;
    }

    @JsonProperty("section1_4_New")
    public void setSection14New(Section14New section14New) {
        this.section14New = section14New;
    }

    @JsonProperty("section1_5")
    public Section15 getSection15() {
        return section15;
    }

    @JsonProperty("section1_5")
    public void setSection15(Section15 section15) {
        this.section15 = section15;
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
