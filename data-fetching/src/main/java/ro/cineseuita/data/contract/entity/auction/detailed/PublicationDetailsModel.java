package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "caPublicationDate",
        "publicationDate",
        "jouePublicationNumber",
        "noticeNo"
})
public class PublicationDetailsModel {

    @JsonProperty("caPublicationDate")
    private String caPublicationDate;
    @JsonProperty("publicationDate")
    private String publicationDate;
    @JsonProperty("jouePublicationNumber")
    private String jouePublicationNumber;
    @JsonProperty("noticeNo")
    private String noticeNo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("caPublicationDate")
    public String getCaPublicationDate() {
        return caPublicationDate;
    }

    @JsonProperty("caPublicationDate")
    public void setCaPublicationDate(String caPublicationDate) {
        this.caPublicationDate = caPublicationDate;
    }

    @JsonProperty("publicationDate")
    public String getPublicationDate() {
        return publicationDate;
    }

    @JsonProperty("publicationDate")
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    @JsonProperty("jouePublicationNumber")
    public String getJouePublicationNumber() {
        return jouePublicationNumber;
    }

    @JsonProperty("jouePublicationNumber")
    public void setJouePublicationNumber(String jouePublicationNumber) {
        this.jouePublicationNumber = jouePublicationNumber;
    }

    @JsonProperty("noticeNo")
    public String getNoticeNo() {
        return noticeNo;
    }

    @JsonProperty("noticeNo")
    public void setNoticeNo(String noticeNo) {
        this.noticeNo = noticeNo;
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
