package ro.cineseuita.contractingauthority.entity.components;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "priorInformation",
        "contract",
        "contractAward",
        "designContest",
        "resultDesignContest",
        "publicWorksConcession",
        "simplifiedContract",
        "rfqInvitation"
})
public class Notices {

    @JsonProperty("priorInformation")
    private Long priorInformation;
    @JsonProperty("contract")
    private Long contract;
    @JsonProperty("contractAward")
    private Long contractAward;
    @JsonProperty("designContest")
    private Long designContest;
    @JsonProperty("resultDesignContest")
    private Long resultDesignContest;
    @JsonProperty("publicWorksConcession")
    private Long publicWorksConcession;
    @JsonProperty("simplifiedContract")
    private Long simplifiedContract;
    @JsonProperty("rfqInvitation")
    private Long rfqInvitation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("priorInformation")
    public Long getPriorInformation() {
        return priorInformation;
    }

    @JsonProperty("priorInformation")
    public void setPriorInformation(Long priorInformation) {
        this.priorInformation = priorInformation;
    }

    @JsonProperty("contract")
    public Long getContract() {
        return contract;
    }

    @JsonProperty("contract")
    public void setContract(Long contract) {
        this.contract = contract;
    }

    @JsonProperty("contractAward")
    public Long getContractAward() {
        return contractAward;
    }

    @JsonProperty("contractAward")
    public void setContractAward(Long contractAward) {
        this.contractAward = contractAward;
    }

    @JsonProperty("designContest")
    public Long getDesignContest() {
        return designContest;
    }

    @JsonProperty("designContest")
    public void setDesignContest(Long designContest) {
        this.designContest = designContest;
    }

    @JsonProperty("resultDesignContest")
    public Long getResultDesignContest() {
        return resultDesignContest;
    }

    @JsonProperty("resultDesignContest")
    public void setResultDesignContest(Long resultDesignContest) {
        this.resultDesignContest = resultDesignContest;
    }

    @JsonProperty("publicWorksConcession")
    public Long getPublicWorksConcession() {
        return publicWorksConcession;
    }

    @JsonProperty("publicWorksConcession")
    public void setPublicWorksConcession(Long publicWorksConcession) {
        this.publicWorksConcession = publicWorksConcession;
    }

    @JsonProperty("simplifiedContract")
    public Long getSimplifiedContract() {
        return simplifiedContract;
    }

    @JsonProperty("simplifiedContract")
    public void setSimplifiedContract(Long simplifiedContract) {
        this.simplifiedContract = simplifiedContract;
    }

    @JsonProperty("rfqInvitation")
    public Long getRfqInvitation() {
        return rfqInvitation;
    }

    @JsonProperty("rfqInvitation")
    public void setRfqInvitation(Long rfqInvitation) {
        this.rfqInvitation = rfqInvitation;
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
