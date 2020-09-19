package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "numberOfReceivedOffers",
        "numberOfReceivedOffersFromSme",
        "numberOfReceivedOffersUe",
        "numberOfReceivedOffersNonUe",
        "numberOfReceivedElectronicOffers",
        "contractAssignedToGroupOfSuppliers",
        "isPublishingAgreed",
        "caNoticeContractId",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class Section522 {

    @JsonProperty("numberOfReceivedOffers")
    private Long numberOfReceivedOffers;
    @JsonProperty("numberOfReceivedOffersFromSme")
    private Long numberOfReceivedOffersFromSme;
    @JsonProperty("numberOfReceivedOffersUe")
    private Long numberOfReceivedOffersUe;
    @JsonProperty("numberOfReceivedOffersNonUe")
    private Long numberOfReceivedOffersNonUe;
    @JsonProperty("numberOfReceivedElectronicOffers")
    private Long numberOfReceivedElectronicOffers;
    @JsonProperty("contractAssignedToGroupOfSuppliers")
    private Boolean contractAssignedToGroupOfSuppliers;
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

    @JsonProperty("numberOfReceivedOffers")
    public Long getNumberOfReceivedOffers() {
        return numberOfReceivedOffers;
    }

    @JsonProperty("numberOfReceivedOffers")
    public void setNumberOfReceivedOffers(Long numberOfReceivedOffers) {
        this.numberOfReceivedOffers = numberOfReceivedOffers;
    }

    @JsonProperty("numberOfReceivedOffersFromSme")
    public Long getNumberOfReceivedOffersFromSme() {
        return numberOfReceivedOffersFromSme;
    }

    @JsonProperty("numberOfReceivedOffersFromSme")
    public void setNumberOfReceivedOffersFromSme(Long numberOfReceivedOffersFromSme) {
        this.numberOfReceivedOffersFromSme = numberOfReceivedOffersFromSme;
    }

    @JsonProperty("numberOfReceivedOffersUe")
    public Long getNumberOfReceivedOffersUe() {
        return numberOfReceivedOffersUe;
    }

    @JsonProperty("numberOfReceivedOffersUe")
    public void setNumberOfReceivedOffersUe(Long numberOfReceivedOffersUe) {
        this.numberOfReceivedOffersUe = numberOfReceivedOffersUe;
    }

    @JsonProperty("numberOfReceivedOffersNonUe")
    public Long getNumberOfReceivedOffersNonUe() {
        return numberOfReceivedOffersNonUe;
    }

    @JsonProperty("numberOfReceivedOffersNonUe")
    public void setNumberOfReceivedOffersNonUe(Long numberOfReceivedOffersNonUe) {
        this.numberOfReceivedOffersNonUe = numberOfReceivedOffersNonUe;
    }

    @JsonProperty("numberOfReceivedElectronicOffers")
    public Long getNumberOfReceivedElectronicOffers() {
        return numberOfReceivedElectronicOffers;
    }

    @JsonProperty("numberOfReceivedElectronicOffers")
    public void setNumberOfReceivedElectronicOffers(Long numberOfReceivedElectronicOffers) {
        this.numberOfReceivedElectronicOffers = numberOfReceivedElectronicOffers;
    }

    @JsonProperty("contractAssignedToGroupOfSuppliers")
    public Boolean getContractAssignedToGroupOfSuppliers() {
        return contractAssignedToGroupOfSuppliers;
    }

    @JsonProperty("contractAssignedToGroupOfSuppliers")
    public void setContractAssignedToGroupOfSuppliers(Boolean contractAssignedToGroupOfSuppliers) {
        this.contractAssignedToGroupOfSuppliers = contractAssignedToGroupOfSuppliers;
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
