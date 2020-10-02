package ro.cineseuita.data.contract.auction.entity.detailed;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.data.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "totalContractValue",
        "useTotalContractValue",
        "estimatedContractValue",
        "ronExchangeRate",
        "lowestOffer",
        "highestOffer",
        "ronLowestOffer",
        "ronHighestOffer",
        "currency",
        "ronContractValue",
        "isPublishingAgreed",
        "caNoticeContractId",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class Section524 {

    @JsonProperty("totalContractValue")
    private Double totalContractValue;
    @JsonProperty("useTotalContractValue")
    private Boolean useTotalContractValue;
    @JsonProperty("estimatedContractValue")
    private Double estimatedContractValue;
    @JsonProperty("ronExchangeRate")
    private Double ronExchangeRate;
    @JsonProperty("lowestOffer")
    private Object lowestOffer;
    @JsonProperty("highestOffer")
    private Object highestOffer;
    @JsonProperty("ronLowestOffer")
    private Object ronLowestOffer;
    @JsonProperty("ronHighestOffer")
    private Object ronHighestOffer;
    @JsonProperty("currency")
    private GenericSeapData currency;
    @JsonProperty("ronContractValue")
    private Double ronContractValue;
    @JsonProperty("isPublishingAgreed")
    private Boolean isPublishingAgreed;
    @JsonProperty("caNoticeContractId")
    private Long caNoticeContractId;
    @JsonProperty("caNoticeId")
    private Long caNoticeId;
    @JsonProperty("sectionName")
    private Object sectionName;
    @JsonProperty("sectionCode")
    private Object sectionCode;
    @JsonProperty("noticePreviousPublication")
    private Object noticePreviousPublication;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("totalContractValue")
    public Double getTotalContractValue() {
        return totalContractValue;
    }

    @JsonProperty("totalContractValue")
    public void setTotalContractValue(Double totalContractValue) {
        this.totalContractValue = totalContractValue;
    }

    @JsonProperty("useTotalContractValue")
    public Boolean getUseTotalContractValue() {
        return useTotalContractValue;
    }

    @JsonProperty("useTotalContractValue")
    public void setUseTotalContractValue(Boolean useTotalContractValue) {
        this.useTotalContractValue = useTotalContractValue;
    }

    @JsonProperty("estimatedContractValue")
    public Double getEstimatedContractValue() {
        return estimatedContractValue;
    }

    @JsonProperty("estimatedContractValue")
    public void setEstimatedContractValue(Double estimatedContractValue) {
        this.estimatedContractValue = estimatedContractValue;
    }

    @JsonProperty("ronExchangeRate")
    public Double getRonExchangeRate() {
        return ronExchangeRate;
    }

    @JsonProperty("ronExchangeRate")
    public void setRonExchangeRate(Double ronExchangeRate) {
        this.ronExchangeRate = ronExchangeRate;
    }

    @JsonProperty("lowestOffer")
    public Object getLowestOffer() {
        return lowestOffer;
    }

    @JsonProperty("lowestOffer")
    public void setLowestOffer(Object lowestOffer) {
        this.lowestOffer = lowestOffer;
    }

    @JsonProperty("highestOffer")
    public Object getHighestOffer() {
        return highestOffer;
    }

    @JsonProperty("highestOffer")
    public void setHighestOffer(Object highestOffer) {
        this.highestOffer = highestOffer;
    }

    @JsonProperty("ronLowestOffer")
    public Object getRonLowestOffer() {
        return ronLowestOffer;
    }

    @JsonProperty("ronLowestOffer")
    public void setRonLowestOffer(Object ronLowestOffer) {
        this.ronLowestOffer = ronLowestOffer;
    }

    @JsonProperty("ronHighestOffer")
    public Object getRonHighestOffer() {
        return ronHighestOffer;
    }

    @JsonProperty("ronHighestOffer")
    public void setRonHighestOffer(Object ronHighestOffer) {
        this.ronHighestOffer = ronHighestOffer;
    }

    @JsonProperty("currency")
    public GenericSeapData getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(GenericSeapData currency) {
        this.currency = currency;
    }

    @JsonProperty("ronContractValue")
    public Double getRonContractValue() {
        return ronContractValue;
    }

    @JsonProperty("ronContractValue")
    public void setRonContractValue(Double ronContractValue) {
        this.ronContractValue = ronContractValue;
    }

    @JsonProperty("isPublishingAgreed")
    public Boolean getIsPublishingAgreed() {
        return isPublishingAgreed;
    }

    @JsonProperty("isPublishingAgreed")
    public void setIsPublishingAgreed(Boolean isPublishingAgreed) {
        this.isPublishingAgreed = isPublishingAgreed;
    }

    @JsonProperty("caNoticeContractId")
    public Long getCaNoticeContractId() {
        return caNoticeContractId;
    }

    @JsonProperty("caNoticeContractId")
    public void setCaNoticeContractId(Long caNoticeContractId) {
        this.caNoticeContractId = caNoticeContractId;
    }

    @JsonProperty("caNoticeId")
    public Long getCaNoticeId() {
        return caNoticeId;
    }

    @JsonProperty("caNoticeId")
    public void setCaNoticeId(Long caNoticeId) {
        this.caNoticeId = caNoticeId;
    }

    @JsonProperty("sectionName")
    public Object getSectionName() {
        return sectionName;
    }

    @JsonProperty("sectionName")
    public void setSectionName(Object sectionName) {
        this.sectionName = sectionName;
    }

    @JsonProperty("sectionCode")
    public Object getSectionCode() {
        return sectionCode;
    }

    @JsonProperty("sectionCode")
    public void setSectionCode(Object sectionCode) {
        this.sectionCode = sectionCode;
    }

    @JsonProperty("noticePreviousPublication")
    public Object getNoticePreviousPublication() {
        return noticePreviousPublication;
    }

    @JsonProperty("noticePreviousPublication")
    public void setNoticePreviousPublication(Object noticePreviousPublication) {
        this.noticePreviousPublication = noticePreviousPublication;
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
