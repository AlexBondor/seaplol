package ro.cineseuita.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "section5_2_0",
        "section5_2_1",
        "section5_2_2",
        "section5_2_3",
        "section5_2_4",
        "section5_2_5",
        "section5_2_6",
        "section5_2_7",
        "section5_2_8",
        "section5_2_9",
        "section5_2_10",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class Section52 {

    @JsonProperty("section5_2_0")
    private Section520 section520;
    @JsonProperty("section5_2_1")
    private Section521 section521;
    @JsonProperty("section5_2_2")
    private Section522 section522;
    @JsonProperty("section5_2_3")
    private Section523 section523;
    @JsonProperty("section5_2_4")
    private Section524 section524;
    @JsonProperty("section5_2_5")
    private Section525 section525;
    @JsonProperty("section5_2_6")
    private Section526 section526;
    @JsonProperty("section5_2_7")
    private Section527 section527;
    @JsonProperty("section5_2_8")
    private Section528 section528;
    @JsonProperty("section5_2_9")
    private Section529 section529;
    @JsonProperty("section5_2_10")
    private Section5210 section5210;
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

    @JsonProperty("section5_2_0")
    public Section520 getSection520() {
        return section520;
    }

    @JsonProperty("section5_2_0")
    public void setSection520(Section520 section520) {
        this.section520 = section520;
    }

    @JsonProperty("section5_2_1")
    public Section521 getSection521() {
        return section521;
    }

    @JsonProperty("section5_2_1")
    public void setSection521(Section521 section521) {
        this.section521 = section521;
    }

    @JsonProperty("section5_2_2")
    public Section522 getSection522() {
        return section522;
    }

    @JsonProperty("section5_2_2")
    public void setSection522(Section522 section522) {
        this.section522 = section522;
    }

    @JsonProperty("section5_2_3")
    public Section523 getSection523() {
        return section523;
    }

    @JsonProperty("section5_2_3")
    public void setSection523(Section523 section523) {
        this.section523 = section523;
    }

    @JsonProperty("section5_2_4")
    public Section524 getSection524() {
        return section524;
    }

    @JsonProperty("section5_2_4")
    public void setSection524(Section524 section524) {
        this.section524 = section524;
    }

    @JsonProperty("section5_2_5")
    public Section525 getSection525() {
        return section525;
    }

    @JsonProperty("section5_2_5")
    public void setSection525(Section525 section525) {
        this.section525 = section525;
    }

    @JsonProperty("section5_2_6")
    public Section526 getSection526() {
        return section526;
    }

    @JsonProperty("section5_2_6")
    public void setSection526(Section526 section526) {
        this.section526 = section526;
    }

    @JsonProperty("section5_2_7")
    public Section527 getSection527() {
        return section527;
    }

    @JsonProperty("section5_2_7")
    public void setSection527(Section527 section527) {
        this.section527 = section527;
    }

    @JsonProperty("section5_2_8")
    public Section528 getSection528() {
        return section528;
    }

    @JsonProperty("section5_2_8")
    public void setSection528(Section528 section528) {
        this.section528 = section528;
    }

    @JsonProperty("section5_2_9")
    public Section529 getSection529() {
        return section529;
    }

    @JsonProperty("section5_2_9")
    public void setSection529(Section529 section529) {
        this.section529 = section529;
    }

    @JsonProperty("section5_2_10")
    public Section5210 getSection5210() {
        return section5210;
    }

    @JsonProperty("section5_2_10")
    public void setSection5210(Section5210 section5210) {
        this.section5210 = section5210;
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
