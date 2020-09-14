package ro.cineseuita.shared.entityComponents;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "published",
        "valid",
        "notExpired",
        "awardedDirectAcquisitions"
})
public class Catalog {

    @JsonProperty("published")
    private Integer published;
    @JsonProperty("valid")
    private Integer valid;
    @JsonProperty("notExpired")
    private Integer notExpired;
    @JsonProperty("awardedDirectAcquisitions")
    private Integer awardedDirectAcquisitions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("published")
    public Integer getPublished() {
        return published;
    }

    @JsonProperty("published")
    public void setPublished(Integer published) {
        this.published = published;
    }

    @JsonProperty("valid")
    public Integer getValid() {
        return valid;
    }

    @JsonProperty("valid")
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @JsonProperty("notExpired")
    public Integer getNotExpired() {
        return notExpired;
    }

    @JsonProperty("notExpired")
    public void setNotExpired(Integer notExpired) {
        this.notExpired = notExpired;
    }

    @JsonProperty("awardedDirectAcquisitions")
    public Integer getAwardedDirectAcquisitions() {
        return awardedDirectAcquisitions;
    }

    @JsonProperty("awardedDirectAcquisitions")
    public void setAwardedDirectAcquisitions(Integer awardedDirectAcquisitions) {
        this.awardedDirectAcquisitions = awardedDirectAcquisitions;
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
