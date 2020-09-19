package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "caNoticeId",
        "name",
        "fiscalNumber",
        "noticeEntityAddressId",
        "entityId",
        "isSME",
        "address",
        "source"
})
public class SupplierWinner {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("caNoticeId")
    private Long caNoticeId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("fiscalNumber")
    private String fiscalNumber;
    @JsonProperty("noticeEntityAddressId")
    private Long noticeEntityAddressId;
    @JsonProperty("entityId")
    private Long entityId;
    @JsonProperty("isSME")
    private Object isSME;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("source")
    private Long source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("caNoticeId")
    public Long getCaNoticeId() {
        return caNoticeId;
    }

    @JsonProperty("caNoticeId")
    public void setCaNoticeId(Long caNoticeId) {
        this.caNoticeId = caNoticeId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("fiscalNumber")
    public String getFiscalNumber() {
        return fiscalNumber;
    }

    @JsonProperty("fiscalNumber")
    public void setFiscalNumber(String fiscalNumber) {
        this.fiscalNumber = fiscalNumber;
    }

    @JsonProperty("noticeEntityAddressId")
    public Long getNoticeEntityAddressId() {
        return noticeEntityAddressId;
    }

    @JsonProperty("noticeEntityAddressId")
    public void setNoticeEntityAddressId(Long noticeEntityAddressId) {
        this.noticeEntityAddressId = noticeEntityAddressId;
    }

    @JsonProperty("entityId")
    public Long getEntityId() {
        return entityId;
    }

    @JsonProperty("entityId")
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    @JsonProperty("isSME")
    public Object getIsSME() {
        return isSME;
    }

    @JsonProperty("isSME")
    public void setIsSME(Object isSME) {
        this.isSME = isSME;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("source")
    public Long getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(Long source) {
        this.source = source;
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
