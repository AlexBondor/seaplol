package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "section2_1_New",
        "section2_2_New"
})
public class Section2New {

    @JsonProperty("section2_1_New")
    private Section21New section21New;
    @JsonProperty("section2_2_New")
    private Section22New section22New;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("section2_1_New")
    public Section21New getSection21New() {
        return section21New;
    }

    @JsonProperty("section2_1_New")
    public void setSection21New(Section21New section21New) {
        this.section21New = section21New;
    }

    @JsonProperty("section2_2_New")
    public Section22New getSection22New() {
        return section22New;
    }

    @JsonProperty("section2_2_New")
    public void setSection22New(Section22New section22New) {
        this.section22New = section22New;
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
