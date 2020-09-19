package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "noticeLotId",
        "noticeContractObjectId",
        "no",
        "title",
        "value",
        "procedureLotId"
})
public class AwardedNoticeLotList {

    @JsonProperty("noticeLotId")
    private Long noticeLotId;
    @JsonProperty("noticeContractObjectId")
    private Long noticeContractObjectId;
    @JsonProperty("no")
    private String no;
    @JsonProperty("title")
    private String title;
    @JsonProperty("value")
    private Double value;
    @JsonProperty("procedureLotId")
    private Object procedureLotId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("noticeLotId")
    public Long getNoticeLotId() {
        return noticeLotId;
    }

    @JsonProperty("noticeLotId")
    public void setNoticeLotId(Long noticeLotId) {
        this.noticeLotId = noticeLotId;
    }

    @JsonProperty("noticeContractObjectId")
    public Long getNoticeContractObjectId() {
        return noticeContractObjectId;
    }

    @JsonProperty("noticeContractObjectId")
    public void setNoticeContractObjectId(Long noticeContractObjectId) {
        this.noticeContractObjectId = noticeContractObjectId;
    }

    @JsonProperty("no")
    public String getNo() {
        return no;
    }

    @JsonProperty("no")
    public void setNo(String no) {
        this.no = no;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("value")
    public Double getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Double value) {
        this.value = value;
    }

    @JsonProperty("procedureLotId")
    public Object getProcedureLotId() {
        return procedureLotId;
    }

    @JsonProperty("procedureLotId")
    public void setProcedureLotId(Object procedureLotId) {
        this.procedureLotId = procedureLotId;
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
