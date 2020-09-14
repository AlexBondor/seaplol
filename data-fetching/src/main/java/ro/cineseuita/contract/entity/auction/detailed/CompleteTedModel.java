package ro.cineseuita.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "caNoticeId",
        "ojeuNoticeNoYear",
        "ojeuNoticeNoSecondPart",
        "ojeuNoticeNoThirdPart",
        "ojeuNoticeDate"
})
public class CompleteTedModel {

    @JsonProperty("caNoticeId")
    private Long caNoticeId;
    @JsonProperty("ojeuNoticeNoYear")
    private String ojeuNoticeNoYear;
    @JsonProperty("ojeuNoticeNoSecondPart")
    private String ojeuNoticeNoSecondPart;
    @JsonProperty("ojeuNoticeNoThirdPart")
    private String ojeuNoticeNoThirdPart;
    @JsonProperty("ojeuNoticeDate")
    private Object ojeuNoticeDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("caNoticeId")
    public Long getCaNoticeId() {
        return caNoticeId;
    }

    @JsonProperty("caNoticeId")
    public void setCaNoticeId(Long caNoticeId) {
        this.caNoticeId = caNoticeId;
    }

    @JsonProperty("ojeuNoticeNoYear")
    public String getOjeuNoticeNoYear() {
        return ojeuNoticeNoYear;
    }

    @JsonProperty("ojeuNoticeNoYear")
    public void setOjeuNoticeNoYear(String ojeuNoticeNoYear) {
        this.ojeuNoticeNoYear = ojeuNoticeNoYear;
    }

    @JsonProperty("ojeuNoticeNoSecondPart")
    public String getOjeuNoticeNoSecondPart() {
        return ojeuNoticeNoSecondPart;
    }

    @JsonProperty("ojeuNoticeNoSecondPart")
    public void setOjeuNoticeNoSecondPart(String ojeuNoticeNoSecondPart) {
        this.ojeuNoticeNoSecondPart = ojeuNoticeNoSecondPart;
    }

    @JsonProperty("ojeuNoticeNoThirdPart")
    public String getOjeuNoticeNoThirdPart() {
        return ojeuNoticeNoThirdPart;
    }

    @JsonProperty("ojeuNoticeNoThirdPart")
    public void setOjeuNoticeNoThirdPart(String ojeuNoticeNoThirdPart) {
        this.ojeuNoticeNoThirdPart = ojeuNoticeNoThirdPart;
    }

    @JsonProperty("ojeuNoticeDate")
    public Object getOjeuNoticeDate() {
        return ojeuNoticeDate;
    }

    @JsonProperty("ojeuNoticeDate")
    public void setOjeuNoticeDate(Object ojeuNoticeDate) {
        this.ojeuNoticeDate = ojeuNoticeDate;
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
