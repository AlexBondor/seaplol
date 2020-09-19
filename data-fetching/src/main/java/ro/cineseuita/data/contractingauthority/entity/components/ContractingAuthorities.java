package ro.cineseuita.data.contractingauthority.entity.components;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthority;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total",
        "items"
})
public class ContractingAuthorities {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("items")
    private List<ContractingAuthority> contractingAuthorities = null;
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
    public List<ContractingAuthority> getContractingAuthorities() {
        return contractingAuthorities;
    }

    @JsonProperty("items")
    public void setContractingAuthorities(List<ContractingAuthority> contractingAuthorities) {
        this.contractingAuthorities = contractingAuthorities;
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
