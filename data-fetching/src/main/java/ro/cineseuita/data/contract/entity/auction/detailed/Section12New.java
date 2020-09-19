package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isCommonProcurement",
        "commonProcurementLaw",
        "isAwardedByCentralAcquisitionOrgan",
        "otherCANoticeAdresses",
        "canEdit",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class Section12New {

    @JsonProperty("isCommonProcurement")
    private Boolean isCommonProcurement;
    @JsonProperty("commonProcurementLaw")
    private Object commonProcurementLaw;
    @JsonProperty("isAwardedByCentralAcquisitionOrgan")
    private Boolean isAwardedByCentralAcquisitionOrgan;
    @JsonProperty("otherCANoticeAdresses")
    private List<Object> otherCANoticeAdresses = null;
    @JsonProperty("canEdit")
    private Boolean canEdit;
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

    @JsonProperty("isCommonProcurement")
    public Boolean getIsCommonProcurement() {
        return isCommonProcurement;
    }

    @JsonProperty("isCommonProcurement")
    public void setIsCommonProcurement(Boolean isCommonProcurement) {
        this.isCommonProcurement = isCommonProcurement;
    }

    @JsonProperty("commonProcurementLaw")
    public Object getCommonProcurementLaw() {
        return commonProcurementLaw;
    }

    @JsonProperty("commonProcurementLaw")
    public void setCommonProcurementLaw(Object commonProcurementLaw) {
        this.commonProcurementLaw = commonProcurementLaw;
    }

    @JsonProperty("isAwardedByCentralAcquisitionOrgan")
    public Boolean getIsAwardedByCentralAcquisitionOrgan() {
        return isAwardedByCentralAcquisitionOrgan;
    }

    @JsonProperty("isAwardedByCentralAcquisitionOrgan")
    public void setIsAwardedByCentralAcquisitionOrgan(Boolean isAwardedByCentralAcquisitionOrgan) {
        this.isAwardedByCentralAcquisitionOrgan = isAwardedByCentralAcquisitionOrgan;
    }

    @JsonProperty("otherCANoticeAdresses")
    public List<Object> getOtherCANoticeAdresses() {
        return otherCANoticeAdresses;
    }

    @JsonProperty("otherCANoticeAdresses")
    public void setOtherCANoticeAdresses(List<Object> otherCANoticeAdresses) {
        this.otherCANoticeAdresses = otherCANoticeAdresses;
    }

    @JsonProperty("canEdit")
    public Boolean getCanEdit() {
        return canEdit;
    }

    @JsonProperty("canEdit")
    public void setCanEdit(Boolean canEdit) {
        this.canEdit = canEdit;
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
