package ro.cineseuita.contract.entity.auction;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "total",
        "items",
        "searchTooLong"
})
public class AuctionAcquisitionContracts {

    @JsonProperty("total")
    private Long total;
    @JsonProperty("items")
    private List<AuctionAcquisitionContract> auctionAcquisitionContracts = null;
    @JsonProperty("searchTooLong")
    private Boolean searchTooLong;
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

    @JsonProperty("items")
    public List<AuctionAcquisitionContract> getAuctionAcquisitionContracts() {
        return auctionAcquisitionContracts;
    }

    @JsonProperty("items")
    public void setAuctionAcquisitionContracts(List<AuctionAcquisitionContract> auctionAcquisitionContracts) {
        this.auctionAcquisitionContracts = auctionAcquisitionContracts;
    }

    @JsonProperty("searchTooLong")
    public Boolean getSearchTooLong() {
        return searchTooLong;
    }

    @JsonProperty("searchTooLong")
    public void setSearchTooLong(Boolean searchTooLong) {
        this.searchTooLong = searchTooLong;
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
