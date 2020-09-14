package ro.cineseuita.supplier.entity.components;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.supplier.entity.Supplier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total",
        "items"
})
public class Suppliers {

    @JsonProperty("total")
    private Integer total;
    @JsonProperty("items")
    private List<Supplier> suppliers = null;
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
    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    @JsonProperty("items")
    public void setSuppliers(List<Supplier> items) {
        this.suppliers = items;
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
