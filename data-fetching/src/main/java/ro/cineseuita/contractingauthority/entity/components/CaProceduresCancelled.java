package ro.cineseuita.contractingauthority.entity.components;

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
public class CaProceduresCancelled {

    @JsonProperty("participantQuality")
    private Object participantQuality;
    @JsonProperty("directAcquisition")
    private Long directAcquisition;
    @JsonProperty("requestForQuotation")
    private Object requestForQuotation;
    @JsonProperty("openBids")
    private Object openBids;
    @JsonProperty("restrictedBids")
    private Object restrictedBids;
    @JsonProperty("eBids")
    private Long eBids;
    @JsonProperty("simplifiedProcedureBids")
    private Object simplifiedProcedureBids;
    @JsonProperty("total")
    private Long total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("participantQuality")
    public Object getParticipantQuality() {
        return participantQuality;
    }

    @JsonProperty("participantQuality")
    public void setParticipantQuality(Object participantQuality) {
        this.participantQuality = participantQuality;
    }

    @JsonProperty("directAcquisition")
    public Long getDirectAcquisition() {
        return directAcquisition;
    }

    @JsonProperty("directAcquisition")
    public void setDirectAcquisition(Long directAcquisition) {
        this.directAcquisition = directAcquisition;
    }

    @JsonProperty("requestForQuotation")
    public Object getRequestForQuotation() {
        return requestForQuotation;
    }

    @JsonProperty("requestForQuotation")
    public void setRequestForQuotation(Object requestForQuotation) {
        this.requestForQuotation = requestForQuotation;
    }

    @JsonProperty("openBids")
    public Object getOpenBids() {
        return openBids;
    }

    @JsonProperty("openBids")
    public void setOpenBids(Object openBids) {
        this.openBids = openBids;
    }

    @JsonProperty("restrictedBids")
    public Object getRestrictedBids() {
        return restrictedBids;
    }

    @JsonProperty("restrictedBids")
    public void setRestrictedBids(Object restrictedBids) {
        this.restrictedBids = restrictedBids;
    }

    @JsonProperty("eBids")
    public Long getEBids() {
        return eBids;
    }

    @JsonProperty("eBids")
    public void setEBids(Long eBids) {
        this.eBids = eBids;
    }

    @JsonProperty("simplifiedProcedureBids")
    public Object getSimplifiedProcedureBids() {
        return simplifiedProcedureBids;
    }

    @JsonProperty("simplifiedProcedureBids")
    public void setSimplifiedProcedureBids(Object simplifiedProcedureBids) {
        this.simplifiedProcedureBids = simplifiedProcedureBids;
    }

    @JsonProperty("total")
    public Long getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Long total) {
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
