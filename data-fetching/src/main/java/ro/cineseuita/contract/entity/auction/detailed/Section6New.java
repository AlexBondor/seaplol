package ro.cineseuita.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "section6_3_New",
        "section6_4_1_New",
        "section6_4_2_New",
        "section6_4_3_New",
        "section6_4_4_New",
        "shouldShowSection6_4_567",
        "section6_4_567_New",
        "section6_5_New"
})
public class Section6New {

    @JsonProperty("section6_3_New")
    private Section63New section63New;
    @JsonProperty("section6_4_1_New")
    private Section641New section641New;
    @JsonProperty("section6_4_2_New")
    private Object section642New;
    @JsonProperty("section6_4_3_New")
    private Section643New section643New;
    @JsonProperty("section6_4_4_New")
    private Section644New section644New;
    @JsonProperty("shouldShowSection6_4_567")
    private Boolean shouldShowSection64567;
    @JsonProperty("section6_4_567_New")
    private Object section64567New;
    @JsonProperty("section6_5_New")
    private Section65New section65New;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("section6_3_New")
    public Section63New getSection63New() {
        return section63New;
    }

    @JsonProperty("section6_3_New")
    public void setSection63New(Section63New section63New) {
        this.section63New = section63New;
    }

    @JsonProperty("section6_4_1_New")
    public Section641New getSection641New() {
        return section641New;
    }

    @JsonProperty("section6_4_1_New")
    public void setSection641New(Section641New section641New) {
        this.section641New = section641New;
    }

    @JsonProperty("section6_4_2_New")
    public Object getSection642New() {
        return section642New;
    }

    @JsonProperty("section6_4_2_New")
    public void setSection642New(Object section642New) {
        this.section642New = section642New;
    }

    @JsonProperty("section6_4_3_New")
    public Section643New getSection643New() {
        return section643New;
    }

    @JsonProperty("section6_4_3_New")
    public void setSection643New(Section643New section643New) {
        this.section643New = section643New;
    }

    @JsonProperty("section6_4_4_New")
    public Section644New getSection644New() {
        return section644New;
    }

    @JsonProperty("section6_4_4_New")
    public void setSection644New(Section644New section644New) {
        this.section644New = section644New;
    }

    @JsonProperty("shouldShowSection6_4_567")
    public Boolean getShouldShowSection64567() {
        return shouldShowSection64567;
    }

    @JsonProperty("shouldShowSection6_4_567")
    public void setShouldShowSection64567(Boolean shouldShowSection64567) {
        this.shouldShowSection64567 = shouldShowSection64567;
    }

    @JsonProperty("section6_4_567_New")
    public Object getSection64567New() {
        return section64567New;
    }

    @JsonProperty("section6_4_567_New")
    public void setSection64567New(Object section64567New) {
        this.section64567New = section64567New;
    }

    @JsonProperty("section6_5_New")
    public Section65New getSection65New() {
        return section65New;
    }

    @JsonProperty("section6_5_New")
    public void setSection65New(Section65New section65New) {
        this.section65New = section65New;
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
