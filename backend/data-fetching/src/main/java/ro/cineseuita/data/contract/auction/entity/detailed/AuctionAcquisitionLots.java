package ro.cineseuita.data.contract.auction.entity.detailed;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.data.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "totalEstimatedValue",
        "totalEstimatedCurrency",
        "total",
        "items"
})
public class AuctionAcquisitionLots {

    @JsonProperty("totalEstimatedValue")
    private Object totalEstimatedValue;
    @JsonProperty("totalEstimatedCurrency")
    private GenericSeapData totalEstimatedCurrency;
    @JsonProperty("total")
    private Long total;
    @JsonProperty("items")
    private List<AuctionAcquisitionLot> lots = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("totalEstimatedValue")
    public Object getTotalEstimatedValue() {
        return totalEstimatedValue;
    }

    @JsonProperty("totalEstimatedValue")
    public void setTotalEstimatedValue(Object totalEstimatedValue) {
        this.totalEstimatedValue = totalEstimatedValue;
    }

    @JsonProperty("totalEstimatedCurrency")
    public GenericSeapData getTotalEstimatedCurrency() {
        return totalEstimatedCurrency;
    }

    @JsonProperty("totalEstimatedCurrency")
    public void setTotalEstimatedCurrency(GenericSeapData totalEstimatedCurrency) {
        this.totalEstimatedCurrency = totalEstimatedCurrency;
    }

    @JsonProperty("total")
    public Long getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Long total) {
        this.total = total;
    }

    @JsonProperty("items")
    public List<AuctionAcquisitionLot> getLots() {
        return lots;
    }

    @JsonProperty("items")
    public void setItems(List<AuctionAcquisitionLot> lots) {
        this.lots = lots;
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
