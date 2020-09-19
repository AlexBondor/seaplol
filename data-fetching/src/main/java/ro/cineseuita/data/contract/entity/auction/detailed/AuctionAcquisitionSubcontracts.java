package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total",
        "items"
})
public class AuctionAcquisitionSubcontracts {

    @JsonProperty("total")
    private Long total;
    @JsonProperty("items")
    private List<AuctionAcquisitionSubcontract> auctionAcquisitionSubcontracts = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("total")
    public Long getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Long total) {
        this.total = total;
    }

    @JsonProperty("auctionAcquisitionSubcontracts")
    public List<AuctionAcquisitionSubcontract> getAuctionAcquisitionSubcontracts() {
        return auctionAcquisitionSubcontracts;
    }

    @JsonProperty("items")
    public void setAuctionAcquisitionSubcontracts(List<AuctionAcquisitionSubcontract> auctionAcquisitionSubcontracts) {
        this.auctionAcquisitionSubcontracts = auctionAcquisitionSubcontracts;
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
