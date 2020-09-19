package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "paapDetailName",
        "procedureType",
        "uniqueIdentificationCode",
        "acquisitionValue",
        "contractAcquisitionValue",
        "currency",
        "paapDetailId",
        "paapName",
        "paapYear",
        "paapVersion",
        "sysFinancingType",
        "cpvCode",
        "localStrategyObjective",
        "isOnline",
        "responsibleUnit",
        "valueLeftToAllocateRON"
})
public class PaapModel {

    @JsonProperty("paapDetailName")
    private String paapDetailName;
    @JsonProperty("procedureType")
    private String procedureType;
    @JsonProperty("uniqueIdentificationCode")
    private Object uniqueIdentificationCode;
    @JsonProperty("acquisitionValue")
    private Double acquisitionValue;
    @JsonProperty("contractAcquisitionValue")
    private Double contractAcquisitionValue;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("paapDetailId")
    private Long paapDetailId;
    @JsonProperty("paapName")
    private String paapName;
    @JsonProperty("paapYear")
    private Object paapYear;
    @JsonProperty("paapVersion")
    private Object paapVersion;
    @JsonProperty("sysFinancingType")
    private Object sysFinancingType;
    @JsonProperty("cpvCode")
    private Object cpvCode;
    @JsonProperty("localStrategyObjective")
    private Object localStrategyObjective;
    @JsonProperty("isOnline")
    private Object isOnline;
    @JsonProperty("responsibleUnit")
    private Object responsibleUnit;
    @JsonProperty("valueLeftToAllocateRON")
    private Object valueLeftToAllocateRON;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("paapDetailName")
    public String getPaapDetailName() {
        return paapDetailName;
    }

    @JsonProperty("paapDetailName")
    public void setPaapDetailName(String paapDetailName) {
        this.paapDetailName = paapDetailName;
    }

    @JsonProperty("procedureType")
    public String getProcedureType() {
        return procedureType;
    }

    @JsonProperty("procedureType")
    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    @JsonProperty("uniqueIdentificationCode")
    public Object getUniqueIdentificationCode() {
        return uniqueIdentificationCode;
    }

    @JsonProperty("uniqueIdentificationCode")
    public void setUniqueIdentificationCode(Object uniqueIdentificationCode) {
        this.uniqueIdentificationCode = uniqueIdentificationCode;
    }

    @JsonProperty("acquisitionValue")
    public Double getAcquisitionValue() {
        return acquisitionValue;
    }

    @JsonProperty("acquisitionValue")
    public void setAcquisitionValue(Double acquisitionValue) {
        this.acquisitionValue = acquisitionValue;
    }

    @JsonProperty("contractAcquisitionValue")
    public Double getContractAcquisitionValue() {
        return contractAcquisitionValue;
    }

    @JsonProperty("contractAcquisitionValue")
    public void setContractAcquisitionValue(Double contractAcquisitionValue) {
        this.contractAcquisitionValue = contractAcquisitionValue;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("paapDetailId")
    public Long getPaapDetailId() {
        return paapDetailId;
    }

    @JsonProperty("paapDetailId")
    public void setPaapDetailId(Long paapDetailId) {
        this.paapDetailId = paapDetailId;
    }

    @JsonProperty("paapName")
    public String getPaapName() {
        return paapName;
    }

    @JsonProperty("paapName")
    public void setPaapName(String paapName) {
        this.paapName = paapName;
    }

    @JsonProperty("paapYear")
    public Object getPaapYear() {
        return paapYear;
    }

    @JsonProperty("paapYear")
    public void setPaapYear(Object paapYear) {
        this.paapYear = paapYear;
    }

    @JsonProperty("paapVersion")
    public Object getPaapVersion() {
        return paapVersion;
    }

    @JsonProperty("paapVersion")
    public void setPaapVersion(Object paapVersion) {
        this.paapVersion = paapVersion;
    }

    @JsonProperty("sysFinancingType")
    public Object getSysFinancingType() {
        return sysFinancingType;
    }

    @JsonProperty("sysFinancingType")
    public void setSysFinancingType(Object sysFinancingType) {
        this.sysFinancingType = sysFinancingType;
    }

    @JsonProperty("cpvCode")
    public Object getCpvCode() {
        return cpvCode;
    }

    @JsonProperty("cpvCode")
    public void setCpvCode(Object cpvCode) {
        this.cpvCode = cpvCode;
    }

    @JsonProperty("localStrategyObjective")
    public Object getLocalStrategyObjective() {
        return localStrategyObjective;
    }

    @JsonProperty("localStrategyObjective")
    public void setLocalStrategyObjective(Object localStrategyObjective) {
        this.localStrategyObjective = localStrategyObjective;
    }

    @JsonProperty("isOnline")
    public Object getIsOnline() {
        return isOnline;
    }

    @JsonProperty("isOnline")
    public void setIsOnline(Object isOnline) {
        this.isOnline = isOnline;
    }

    @JsonProperty("responsibleUnit")
    public Object getResponsibleUnit() {
        return responsibleUnit;
    }

    @JsonProperty("responsibleUnit")
    public void setResponsibleUnit(Object responsibleUnit) {
        this.responsibleUnit = responsibleUnit;
    }

    @JsonProperty("valueLeftToAllocateRON")
    public Object getValueLeftToAllocateRON() {
        return valueLeftToAllocateRON;
    }

    @JsonProperty("valueLeftToAllocateRON")
    public void setValueLeftToAllocateRON(Object valueLeftToAllocateRON) {
        this.valueLeftToAllocateRON = valueLeftToAllocateRON;
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
