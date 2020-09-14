package ro.cineseuita.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "contractLotList",
        "cancelledLotList",
        "section52A"
})
public class Section5 {

    @JsonProperty("contractLotList")
    private List<ContractLotList> contractLotList = null;
    @JsonProperty("cancelledLotList")
    private List<Object> cancelledLotList = null;
    @JsonProperty("section52A")
    private Section52A section52A;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("contractLotList")
    public List<ContractLotList> getContractLotList() {
        return contractLotList;
    }

    @JsonProperty("contractLotList")
    public void setContractLotList(List<ContractLotList> contractLotList) {
        this.contractLotList = contractLotList;
    }

    @JsonProperty("cancelledLotList")
    public List<Object> getCancelledLotList() {
        return cancelledLotList;
    }

    @JsonProperty("cancelledLotList")
    public void setCancelledLotList(List<Object> cancelledLotList) {
        this.cancelledLotList = cancelledLotList;
    }

    @JsonProperty("section52A")
    public Section52A getSection52A() {
        return section52A;
    }

    @JsonProperty("section52A")
    public void setSection52A(Section52A section52A) {
        this.section52A = section52A;
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
