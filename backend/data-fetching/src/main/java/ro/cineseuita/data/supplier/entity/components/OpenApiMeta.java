package ro.cineseuita.data.supplier.entity.components;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "updated_at",
        "last_changed_at"
})
public class OpenApiMeta {

    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("last_changed_at")
    private String lastChangedAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("last_changed_at")
    public String getLastChangedAt() {
        return lastChangedAt;
    }

    @JsonProperty("last_changed_at")
    public void setLastChangedAt(String lastChangedAt) {
        this.lastChangedAt = lastChangedAt;
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
