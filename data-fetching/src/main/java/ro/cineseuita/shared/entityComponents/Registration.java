package ro.cineseuita.shared.entityComponents;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "registrationTimestamp",
        "invalidationTimestamp",
        "legalRepresentative"
})
public class Registration {

    @JsonProperty("registrationTimestamp")
    private String registrationTimestamp;
    @JsonProperty("invalidationTimestamp")
    private Object invalidationTimestamp;
    @JsonProperty("legalRepresentative")
    private String legalRepresentative;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("registrationTimestamp")
    public String getRegistrationTimestamp() {
        return registrationTimestamp;
    }

    @JsonProperty("registrationTimestamp")
    public void setRegistrationTimestamp(String registrationTimestamp) {
        this.registrationTimestamp = registrationTimestamp;
    }

    @JsonProperty("invalidationTimestamp")
    public Object getInvalidationTimestamp() {
        return invalidationTimestamp;
    }

    @JsonProperty("invalidationTimestamp")
    public void setInvalidationTimestamp(Object invalidationTimestamp) {
        this.invalidationTimestamp = invalidationTimestamp;
    }

    @JsonProperty("legalRepresentative")
    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    @JsonProperty("legalRepresentative")
    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
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
