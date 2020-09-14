package ro.cineseuita.contract.entity.direct;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "directAcquisitionId",
        "directAcquisitionName",
        "sysDirectAcquisitionState",
        "uniqueIdentificationCode",
        "cpvCode",
        "publicationDate",
        "finalizationDate",
        "caDecisionDeadline",
        "supplierDecisionDeadline",
        "supplier",
        "contractingAuthority",
        "estimatedValueRon",
        "estimatedValueOtherCurrency",
        "closingValue",
        "isOpenForCorrection",
        "isOpenForContractCorrection"
})
@Document(collection = "directAcquisitionContract")
public class DirectAcquisitionContract {

    @Id
    private Long _id;
    @JsonProperty("directAcquisitionId")
    private Long directAcquisitionId;
    @JsonProperty("directAcquisitionName")
    private String directAcquisitionName;
    @JsonProperty("sysDirectAcquisitionState")
    private GenericSeapData sysDirectAcquisitionState;
    @JsonProperty("uniqueIdentificationCode")
    private String uniqueIdentificationCode;
    @JsonProperty("cpvCode")
    private String cpvCode;
    @JsonProperty("publicationDate")
    private String publicationDate;
    @JsonProperty("finalizationDate")
    private String finalizationDate;
    @JsonProperty("caDecisionDeadline")
    private String caDecisionDeadline;
    @JsonProperty("supplierDecisionDeadline")
    private String supplierDecisionDeadline;
    @JsonProperty("supplier")
    private String supplier;
    @JsonProperty("contractingAuthority")
    private String contractingAuthority;
    @JsonProperty("estimatedValueRon")
    private Double estimatedValueRon;
    @JsonProperty("estimatedValueOtherCurrency")
    private Double estimatedValueOtherCurrency;
    @JsonProperty("closingValue")
    private Double closingValue;
    @JsonProperty("isOpenForCorrection")
    private Object isOpenForCorrection;
    @JsonProperty("isOpenForContractCorrection")
    private Boolean isOpenForContractCorrection;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnore
    private Integer year;

    @JsonProperty("directAcquisitionId")
    public Long getDirectAcquisitionId() {
        return directAcquisitionId;
    }

    @JsonProperty("directAcquisitionId")
    public void setDirectAcquisitionId(Long directAcquisitionId) {
        this.directAcquisitionId = directAcquisitionId;
    }

    @JsonProperty("directAcquisitionName")
    public String getDirectAcquisitionName() {
        return directAcquisitionName;
    }

    @JsonProperty("directAcquisitionName")
    public void setDirectAcquisitionName(String directAcquisitionName) {
        this.directAcquisitionName = directAcquisitionName;
    }

    @JsonProperty("sysDirectAcquisitionState")
    public GenericSeapData getSysDirectAcquisitionState() {
        return sysDirectAcquisitionState;
    }

    @JsonProperty("sysDirectAcquisitionState")
    public void setSysDirectAcquisitionState(GenericSeapData sysDirectAcquisitionState) {
        this.sysDirectAcquisitionState = sysDirectAcquisitionState;
    }

    @JsonProperty("uniqueIdentificationCode")
    public String getUniqueIdentificationCode() {
        return uniqueIdentificationCode;
    }

    @JsonProperty("uniqueIdentificationCode")
    public void setUniqueIdentificationCode(String uniqueIdentificationCode) {
        this.uniqueIdentificationCode = uniqueIdentificationCode;
    }

    @JsonProperty("cpvCode")
    public String getCpvCode() {
        return cpvCode;
    }

    @JsonProperty("cpvCode")
    public void setCpvCode(String cpvCode) {
        this.cpvCode = cpvCode;
    }

    @JsonProperty("publicationDate")
    public String getPublicationDate() { //TODO: change to DateTime (same for other field)
        return publicationDate;
    }

    @JsonProperty("publicationDate")
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    @JsonProperty("finalizationDate")
    public String getFinalizationDate() {
        return finalizationDate;
    }

    @JsonProperty("finalizationDate")
    public void setFinalizationDate(String finalizationDate) {
        this.finalizationDate = finalizationDate;
    }

    @JsonProperty("caDecisionDeadline")
    public String getCaDecisionDeadline() {
        return caDecisionDeadline;
    }

    @JsonProperty("caDecisionDeadline")
    public void setCaDecisionDeadline(String caDecisionDeadline) {
        this.caDecisionDeadline = caDecisionDeadline;
    }

    @JsonProperty("supplierDecisionDeadline")
    public String getSupplierDecisionDeadline() {
        return supplierDecisionDeadline;
    }

    @JsonProperty("supplierDecisionDeadline")
    public void setSupplierDecisionDeadline(String supplierDecisionDeadline) {
        this.supplierDecisionDeadline = supplierDecisionDeadline;
    }

    @JsonProperty("supplier")
    public String getSupplier() {
        return supplier;
    }

    @JsonProperty("supplier")
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @JsonProperty("contractingAuthority")
    public String getContractingAuthority() {
        return contractingAuthority;
    }

    @JsonProperty("contractingAuthority")
    public void setContractingAuthority(String contractingAuthority) {
        this.contractingAuthority = contractingAuthority;
    }

    @JsonProperty("estimatedValueRon")
    public Double getEstimatedValueRon() {
        return estimatedValueRon;
    }

    @JsonProperty("estimatedValueRon")
    public void setEstimatedValueRon(Double estimatedValueRon) {
        this.estimatedValueRon = estimatedValueRon;
    }

    @JsonProperty("estimatedValueOtherCurrency")
    public Double getEstimatedValueOtherCurrency() {
        return estimatedValueOtherCurrency;
    }

    @JsonProperty("estimatedValueOtherCurrency")
    public void setEstimatedValueOtherCurrency(Double estimatedValueOtherCurrency) {
        this.estimatedValueOtherCurrency = estimatedValueOtherCurrency;
    }

    @JsonProperty("closingValue")
    public Double getClosingValue() {
        return closingValue;
    }

    @JsonProperty("closingValue")
    public void setClosingValue(Double closingValue) {
        this.closingValue = closingValue;
    }

    @JsonProperty("isOpenForCorrection")
    public Object getIsOpenForCorrection() {
        return isOpenForCorrection;
    }

    @JsonProperty("isOpenForCorrection")
    public void setIsOpenForCorrection(Object isOpenForCorrection) {
        this.isOpenForCorrection = isOpenForCorrection;
    }

    @JsonProperty("isOpenForContractCorrection")
    public Boolean getIsOpenForContractCorrection() {
        return isOpenForContractCorrection;
    }

    @JsonProperty("isOpenForContractCorrection")
    public void setIsOpenForContractCorrection(Boolean isOpenForContractCorrection) {
        this.isOpenForContractCorrection = isOpenForContractCorrection;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }
}
