package ro.cineseuita.data.shared.entityComponents;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "participantQuality",
        "directAcquisition",
        "requestForQuotation",
        "openBids",
        "restrictedBids",
        "eBids",
        "simplifiedProcedureBids",
        "total"
})
public class SupplierProceduresInfo {

    @JsonProperty("participantQuality")
    private String participantQuality;
    @JsonProperty("directAcquisition")
    private Integer directAcquisition;
    @JsonProperty("requestForQuotation")
    private Integer requestForQuotation;
    @JsonProperty("openBids")
    private Integer openBids;
    @JsonProperty("restrictedBids")
    private Integer restrictedBids;
    @JsonProperty("eBids")
    private Integer eBids;
    @JsonProperty("simplifiedProcedureBids")
    private Integer simplifiedProcedureBids;
    @JsonProperty("total")
    private Integer total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("participantQuality")
    public String getParticipantQuality() {
        return participantQuality;
    }

    @JsonProperty("participantQuality")
    public void setParticipantQuality(String participantQuality) {
        this.participantQuality = participantQuality;
    }

    @JsonProperty("directAcquisition")
    public Integer getDirectAcquisition() {
        return directAcquisition;
    }

    @JsonProperty("directAcquisition")
    public void setDirectAcquisition(Integer directAcquisition) {
        this.directAcquisition = directAcquisition;
    }

    @JsonProperty("requestForQuotation")
    public Integer getRequestForQuotation() {
        return requestForQuotation;
    }

    @JsonProperty("requestForQuotation")
    public void setRequestForQuotation(Integer requestForQuotation) {
        this.requestForQuotation = requestForQuotation;
    }

    @JsonProperty("openBids")
    public Integer getOpenBids() {
        return openBids;
    }

    @JsonProperty("openBids")
    public void setOpenBids(Integer openBids) {
        this.openBids = openBids;
    }

    @JsonProperty("restrictedBids")
    public Integer getRestrictedBids() {
        return restrictedBids;
    }

    @JsonProperty("restrictedBids")
    public void setRestrictedBids(Integer restrictedBids) {
        this.restrictedBids = restrictedBids;
    }

    @JsonProperty("eBids")
    public Integer getEBids() {
        return eBids;
    }

    @JsonProperty("eBids")
    public void setEBids(Integer eBids) {
        this.eBids = eBids;
    }

    @JsonProperty("simplifiedProcedureBids")
    public Integer getSimplifiedProcedureBids() {
        return simplifiedProcedureBids;
    }

    @JsonProperty("simplifiedProcedureBids")
    public void setSimplifiedProcedureBids(Integer simplifiedProcedureBids) {
        this.simplifiedProcedureBids = simplifiedProcedureBids;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
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
