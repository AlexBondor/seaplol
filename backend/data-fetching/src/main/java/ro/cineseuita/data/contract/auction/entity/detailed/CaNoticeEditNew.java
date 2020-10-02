package ro.cineseuita.data.contract.auction.entity.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "publicationDetailsModel",
        "section0_New",
        "section1_New",
        "section2_New",
        "section4_New",
        "section5",
        "section6_New",
        "annexD_New"
})
public class CaNoticeEditNew {

    @JsonProperty("publicationDetailsModel")
    private PublicationDetailsModel publicationDetailsModel;
    @JsonProperty("section0_New")
    private Section0New section0New;
    @JsonProperty("section1_New")
    private Section1New section1New;
    @JsonProperty("section2_New")
    private Section2New section2New;
    @JsonProperty("section4_New")
    private Section4New section4New;
    @JsonProperty("section5")
    private Section5 section5;
    @JsonProperty("section6_New")
    private Section6New section6New;
    @JsonProperty("annexD_New")
    private AnnexDNew annexDNew;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("publicationDetailsModel")
    public PublicationDetailsModel getPublicationDetailsModel() {
        return publicationDetailsModel;
    }

    @JsonProperty("publicationDetailsModel")
    public void setPublicationDetailsModel(PublicationDetailsModel publicationDetailsModel) {
        this.publicationDetailsModel = publicationDetailsModel;
    }

    @JsonProperty("section0_New")
    public Section0New getSection0New() {
        return section0New;
    }

    @JsonProperty("section0_New")
    public void setSection0New(Section0New section0New) {
        this.section0New = section0New;
    }

    @JsonProperty("section1_New")
    public Section1New getSection1New() {
        return section1New;
    }

    @JsonProperty("section1_New")
    public void setSection1New(Section1New section1New) {
        this.section1New = section1New;
    }

    @JsonProperty("section2_New")
    public Section2New getSection2New() {
        return section2New;
    }

    @JsonProperty("section2_New")
    public void setSection2New(Section2New section2New) {
        this.section2New = section2New;
    }

    @JsonProperty("section4_New")
    public Section4New getSection4New() {
        return section4New;
    }

    @JsonProperty("section4_New")
    public void setSection4New(Section4New section4New) {
        this.section4New = section4New;
    }

    @JsonProperty("section5")
    public Section5 getSection5() {
        return section5;
    }

    @JsonProperty("section5")
    public void setSection5(Section5 section5) {
        this.section5 = section5;
    }

    @JsonProperty("section6_New")
    public Section6New getSection6New() {
        return section6New;
    }

    @JsonProperty("section6_New")
    public void setSection6New(Section6New section6New) {
        this.section6New = section6New;
    }

    @JsonProperty("annexD_New")
    public AnnexDNew getAnnexDNew() {
        return annexDNew;
    }

    @JsonProperty("annexD_New")
    public void setAnnexDNew(AnnexDNew annexDNew) {
        this.annexDNew = annexDNew;
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
