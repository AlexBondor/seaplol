package ro.cineseuita.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sysProcedureTypeId",
        "sysProcedureType",
        "isAcceleratedProcedure",
        "acceleratedProcedureJustification",
        "sysContractAssigmentTypeId",
        "sysContractAssigmentType",
        "hasElectronicAuction",
        "hasGpaAgreement",
        "canEdit",
        "caNoticeId",
        "sectionName",
        "sectionCode",
        "noticePreviousPublication"
})
public class Section41New {

    @JsonProperty("sysProcedureTypeId")
    private Long sysProcedureTypeId;
    @JsonProperty("sysProcedureType")
    private GenericSeapData sysProcedureType;
    @JsonProperty("isAcceleratedProcedure")
    private Object isAcceleratedProcedure;
    @JsonProperty("acceleratedProcedureJustification")
    private String acceleratedProcedureJustification;
    @JsonProperty("sysContractAssigmentTypeId")
    private Long sysContractAssigmentTypeId;
    @JsonProperty("sysContractAssigmentType")
    private Object sysContractAssigmentType;
    @JsonProperty("hasElectronicAuction")
    private Boolean hasElectronicAuction;
    @JsonProperty("hasGpaAgreement")
    private Boolean hasGpaAgreement;
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

    @JsonProperty("sysProcedureTypeId")
    public Long getSysProcedureTypeId() {
        return sysProcedureTypeId;
    }

    @JsonProperty("sysProcedureTypeId")
    public void setSysProcedureTypeId(Long sysProcedureTypeId) {
        this.sysProcedureTypeId = sysProcedureTypeId;
    }

    @JsonProperty("sysProcedureType")
    public GenericSeapData getSysProcedureType() {
        return sysProcedureType;
    }

    @JsonProperty("sysProcedureType")
    public void setSysProcedureType(GenericSeapData sysProcedureType) {
        this.sysProcedureType = sysProcedureType;
    }

    @JsonProperty("isAcceleratedProcedure")
    public Object getIsAcceleratedProcedure() {
        return isAcceleratedProcedure;
    }

    @JsonProperty("isAcceleratedProcedure")
    public void setIsAcceleratedProcedure(Object isAcceleratedProcedure) {
        this.isAcceleratedProcedure = isAcceleratedProcedure;
    }

    @JsonProperty("acceleratedProcedureJustification")
    public String getAcceleratedProcedureJustification() {
        return acceleratedProcedureJustification;
    }

    @JsonProperty("acceleratedProcedureJustification")
    public void setAcceleratedProcedureJustification(String acceleratedProcedureJustification) {
        this.acceleratedProcedureJustification = acceleratedProcedureJustification;
    }

    @JsonProperty("sysContractAssigmentTypeId")
    public Long getSysContractAssigmentTypeId() {
        return sysContractAssigmentTypeId;
    }

    @JsonProperty("sysContractAssigmentTypeId")
    public void setSysContractAssigmentTypeId(Long sysContractAssigmentTypeId) {
        this.sysContractAssigmentTypeId = sysContractAssigmentTypeId;
    }

    @JsonProperty("sysContractAssigmentType")
    public Object getSysContractAssigmentType() {
        return sysContractAssigmentType;
    }

    @JsonProperty("sysContractAssigmentType")
    public void setSysContractAssigmentType(Object sysContractAssigmentType) {
        this.sysContractAssigmentType = sysContractAssigmentType;
    }

    @JsonProperty("hasElectronicAuction")
    public Boolean getHasElectronicAuction() {
        return hasElectronicAuction;
    }

    @JsonProperty("hasElectronicAuction")
    public void setHasElectronicAuction(Boolean hasElectronicAuction) {
        this.hasElectronicAuction = hasElectronicAuction;
    }

    @JsonProperty("hasGpaAgreement")
    public Boolean getHasGpaAgreement() {
        return hasGpaAgreement;
    }

    @JsonProperty("hasGpaAgreement")
    public void setHasGpaAgreement(Boolean hasGpaAgreement) {
        this.hasGpaAgreement = hasGpaAgreement;
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
