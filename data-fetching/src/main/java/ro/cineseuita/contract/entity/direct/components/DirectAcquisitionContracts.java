package ro.cineseuita.contract.entity.direct.components;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.contract.entity.direct.DirectAcquisitionContract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total",
        "items"
})
public class DirectAcquisitionContracts {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("items")
    private List<DirectAcquisitionContract> directAcquisitionContracts = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("items")
    public List<DirectAcquisitionContract> getDirectAcquisitionContracts() {
        return directAcquisitionContracts;
    }

    @JsonProperty("directAcquisitionContracts")
    public void setDirectAcquisitionContracts(List<DirectAcquisitionContract> directAcquisitionContracts) {
        this.directAcquisitionContracts = directAcquisitionContracts;
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
