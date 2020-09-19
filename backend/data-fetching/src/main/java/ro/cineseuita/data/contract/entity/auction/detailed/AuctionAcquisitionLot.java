package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.data.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "noticeLotID",
        "contractTitle",
        "lotNumber",
        "mainCPVCodes",
        "secondaryCPVCodes",
        "nutsCode",
        "mainLocation",
        "shortDescription",
        "noticeAwardCriteriaList",
        "hasOptions",
        "optionsDescription",
        "isEUFunded",
        "euProject",
        "supplementaryInformation",
        "monthDuration",
        "dayDuration",
        "startDate",
        "completionDate",
        "showSysAwardCriteriaType",
        "sysAwardCriteriaTypeId",
        "sysAwardCriteriaType",
        "sysEuropeanFundId",
        "sysEuropeanFund",
        "sysFinancingTypeId",
        "sysFinancingType",
        "communityProgramReference",
        "estimatedValue",
        "minEstimatedValue",
        "maxEstimatedValue",
        "currency",
        "lotInfo"
})
public class AuctionAcquisitionLot {

    @JsonProperty("noticeLotID")
    private Long noticeLotID;
    @JsonProperty("contractTitle")
    private String contractTitle;
    @JsonProperty("lotNumber")
    private String lotNumber;
    @JsonProperty("mainCPVCodes")
    private GenericSeapData mainCPVCodes;
    @JsonProperty("secondaryCPVCodes")
    private List<Object> secondaryCPVCodes = null;
    @JsonProperty("nutsCode")
    private GenericSeapData nutsCode;
    @JsonProperty("mainLocation")
    private String mainLocation;
    @JsonProperty("shortDescription")
    private String shortDescription;
    @JsonProperty("noticeAwardCriteriaList")
    private List<Object> noticeAwardCriteriaList = null;
    @JsonProperty("hasOptions")
    private Boolean hasOptions;
    @JsonProperty("optionsDescription")
    private Object optionsDescription;
    @JsonProperty("isEUFunded")
    private Boolean isEUFunded;
    @JsonProperty("euProject")
    private Object euProject;
    @JsonProperty("supplementaryInformation")
    private Object supplementaryInformation;
    @JsonProperty("monthDuration")
    private Long monthDuration;
    @JsonProperty("dayDuration")
    private Object dayDuration;
    @JsonProperty("startDate")
    private Object startDate;
    @JsonProperty("completionDate")
    private Object completionDate;
    @JsonProperty("showSysAwardCriteriaType")
    private Boolean showSysAwardCriteriaType;
    @JsonProperty("sysAwardCriteriaTypeId")
    private Long sysAwardCriteriaTypeId;
    @JsonProperty("sysAwardCriteriaType")
    private GenericSeapData sysAwardCriteriaType;
    @JsonProperty("sysEuropeanFundId")
    private Object sysEuropeanFundId;
    @JsonProperty("sysEuropeanFund")
    private Object sysEuropeanFund;
    @JsonProperty("sysFinancingTypeId")
    private Object sysFinancingTypeId;
    @JsonProperty("sysFinancingType")
    private GenericSeapData sysFinancingType;
    @JsonProperty("communityProgramReference")
    private Object communityProgramReference;
    @JsonProperty("estimatedValue")
    private Object estimatedValue;
    @JsonProperty("minEstimatedValue")
    private Object minEstimatedValue;
    @JsonProperty("maxEstimatedValue")
    private Object maxEstimatedValue;
    @JsonProperty("currency")
    private GenericSeapData currency;
    @JsonProperty("lotInfo")
    private String lotInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("noticeLotID")
    public Long getNoticeLotID() {
        return noticeLotID;
    }

    @JsonProperty("noticeLotID")
    public void setNoticeLotID(Long noticeLotID) {
        this.noticeLotID = noticeLotID;
    }

    @JsonProperty("contractTitle")
    public String getContractTitle() {
        return contractTitle;
    }

    @JsonProperty("contractTitle")
    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    @JsonProperty("lotNumber")
    public String getLotNumber() {
        return lotNumber;
    }

    @JsonProperty("lotNumber")
    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    @JsonProperty("mainCPVCodes")
    public GenericSeapData getMainCPVCodes() {
        return mainCPVCodes;
    }

    @JsonProperty("mainCPVCodes")
    public void setMainCPVCodes(GenericSeapData mainCPVCodes) {
        this.mainCPVCodes = mainCPVCodes;
    }

    @JsonProperty("secondaryCPVCodes")
    public List<Object> getSecondaryCPVCodes() {
        return secondaryCPVCodes;
    }

    @JsonProperty("secondaryCPVCodes")
    public void setSecondaryCPVCodes(List<Object> secondaryCPVCodes) {
        this.secondaryCPVCodes = secondaryCPVCodes;
    }

    @JsonProperty("nutsCode")
    public GenericSeapData getNutsCode() {
        return nutsCode;
    }

    @JsonProperty("nutsCode")
    public void setNutsCode(GenericSeapData nutsCode) {
        this.nutsCode = nutsCode;
    }

    @JsonProperty("mainLocation")
    public String getMainLocation() {
        return mainLocation;
    }

    @JsonProperty("mainLocation")
    public void setMainLocation(String mainLocation) {
        this.mainLocation = mainLocation;
    }

    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("noticeAwardCriteriaList")
    public List<Object> getNoticeAwardCriteriaList() {
        return noticeAwardCriteriaList;
    }

    @JsonProperty("noticeAwardCriteriaList")
    public void setNoticeAwardCriteriaList(List<Object> noticeAwardCriteriaList) {
        this.noticeAwardCriteriaList = noticeAwardCriteriaList;
    }

    @JsonProperty("hasOptions")
    public Boolean getHasOptions() {
        return hasOptions;
    }

    @JsonProperty("hasOptions")
    public void setHasOptions(Boolean hasOptions) {
        this.hasOptions = hasOptions;
    }

    @JsonProperty("optionsDescription")
    public Object getOptionsDescription() {
        return optionsDescription;
    }

    @JsonProperty("optionsDescription")
    public void setOptionsDescription(Object optionsDescription) {
        this.optionsDescription = optionsDescription;
    }

    @JsonProperty("isEUFunded")
    public Boolean getIsEUFunded() {
        return isEUFunded;
    }

    @JsonProperty("isEUFunded")
    public void setIsEUFunded(Boolean isEUFunded) {
        this.isEUFunded = isEUFunded;
    }

    @JsonProperty("euProject")
    public Object getEuProject() {
        return euProject;
    }

    @JsonProperty("euProject")
    public void setEuProject(Object euProject) {
        this.euProject = euProject;
    }

    @JsonProperty("supplementaryInformation")
    public Object getSupplementaryInformation() {
        return supplementaryInformation;
    }

    @JsonProperty("supplementaryInformation")
    public void setSupplementaryInformation(Object supplementaryInformation) {
        this.supplementaryInformation = supplementaryInformation;
    }

    @JsonProperty("monthDuration")
    public Long getMonthDuration() {
        return monthDuration;
    }

    @JsonProperty("monthDuration")
    public void setMonthDuration(Long monthDuration) {
        this.monthDuration = monthDuration;
    }

    @JsonProperty("dayDuration")
    public Object getDayDuration() {
        return dayDuration;
    }

    @JsonProperty("dayDuration")
    public void setDayDuration(Object dayDuration) {
        this.dayDuration = dayDuration;
    }

    @JsonProperty("startDate")
    public Object getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(Object startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("completionDate")
    public Object getCompletionDate() {
        return completionDate;
    }

    @JsonProperty("completionDate")
    public void setCompletionDate(Object completionDate) {
        this.completionDate = completionDate;
    }

    @JsonProperty("showSysAwardCriteriaType")
    public Boolean getShowSysAwardCriteriaType() {
        return showSysAwardCriteriaType;
    }

    @JsonProperty("showSysAwardCriteriaType")
    public void setShowSysAwardCriteriaType(Boolean showSysAwardCriteriaType) {
        this.showSysAwardCriteriaType = showSysAwardCriteriaType;
    }

    @JsonProperty("sysAwardCriteriaTypeId")
    public Long getSysAwardCriteriaTypeId() {
        return sysAwardCriteriaTypeId;
    }

    @JsonProperty("sysAwardCriteriaTypeId")
    public void setSysAwardCriteriaTypeId(Long sysAwardCriteriaTypeId) {
        this.sysAwardCriteriaTypeId = sysAwardCriteriaTypeId;
    }

    @JsonProperty("sysAwardCriteriaType")
    public GenericSeapData getSysAwardCriteriaType() {
        return sysAwardCriteriaType;
    }

    @JsonProperty("sysAwardCriteriaType")
    public void setSysAwardCriteriaType(GenericSeapData sysAwardCriteriaType) {
        this.sysAwardCriteriaType = sysAwardCriteriaType;
    }

    @JsonProperty("sysEuropeanFundId")
    public Object getSysEuropeanFundId() {
        return sysEuropeanFundId;
    }

    @JsonProperty("sysEuropeanFundId")
    public void setSysEuropeanFundId(Object sysEuropeanFundId) {
        this.sysEuropeanFundId = sysEuropeanFundId;
    }

    @JsonProperty("sysEuropeanFund")
    public Object getSysEuropeanFund() {
        return sysEuropeanFund;
    }

    @JsonProperty("sysEuropeanFund")
    public void setSysEuropeanFund(Object sysEuropeanFund) {
        this.sysEuropeanFund = sysEuropeanFund;
    }

    @JsonProperty("sysFinancingTypeId")
    public Object getSysFinancingTypeId() {
        return sysFinancingTypeId;
    }

    @JsonProperty("sysFinancingTypeId")
    public void setSysFinancingTypeId(Object sysFinancingTypeId) {
        this.sysFinancingTypeId = sysFinancingTypeId;
    }

    @JsonProperty("sysFinancingType")
    public GenericSeapData getSysFinancingType() {
        return sysFinancingType;
    }

    @JsonProperty("sysFinancingType")
    public void setSysFinancingType(GenericSeapData sysFinancingType) {
        this.sysFinancingType = sysFinancingType;
    }

    @JsonProperty("communityProgramReference")
    public Object getCommunityProgramReference() {
        return communityProgramReference;
    }

    @JsonProperty("communityProgramReference")
    public void setCommunityProgramReference(Object communityProgramReference) {
        this.communityProgramReference = communityProgramReference;
    }

    @JsonProperty("estimatedValue")
    public Object getEstimatedValue() {
        return estimatedValue;
    }

    @JsonProperty("estimatedValue")
    public void setEstimatedValue(Object estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    @JsonProperty("minEstimatedValue")
    public Object getMinEstimatedValue() {
        return minEstimatedValue;
    }

    @JsonProperty("minEstimatedValue")
    public void setMinEstimatedValue(Object minEstimatedValue) {
        this.minEstimatedValue = minEstimatedValue;
    }

    @JsonProperty("maxEstimatedValue")
    public Object getMaxEstimatedValue() {
        return maxEstimatedValue;
    }

    @JsonProperty("maxEstimatedValue")
    public void setMaxEstimatedValue(Object maxEstimatedValue) {
        this.maxEstimatedValue = maxEstimatedValue;
    }

    @JsonProperty("currency")
    public GenericSeapData getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(GenericSeapData currency) {
        this.currency = currency;
    }

    @JsonProperty("lotInfo")
    public String getLotInfo() {
        return lotInfo;
    }

    @JsonProperty("lotInfo")
    public void setLotInfo(String lotInfo) {
        this.lotInfo = lotInfo;
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
