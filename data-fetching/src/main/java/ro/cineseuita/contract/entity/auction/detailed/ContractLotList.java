package ro.cineseuita.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "section5_2",
        "caNoticeContractId",
        "contractId",
        "caNoticeId",
        "contractNo",
        "contractDate",
        "contractTitle",
        "sysContractAssignmentType",
        "noticeNo",
        "sysContractPhase",
        "contractValue",
        "defaultCurrencyContractValue",
        "currency",
        "awardedNoticeLotList",
        "supplierWinners",
        "parentContractId",
        "isSignedBySu",
        "originalContractId",
        "isCurrentVersion",
        "actions",
        "conditions",
        "sysContractFrameworkTypeId"
})
public class ContractLotList {

    @JsonProperty("section5_2")
    private Section52 section52;
    @JsonProperty("caNoticeContractId")
    private Long caNoticeContractId;
    @JsonProperty("contractId")
    private Long contractId;
    @JsonProperty("caNoticeId")
    private Long caNoticeId;
    @JsonProperty("contractNo")
    private String contractNo;
    @JsonProperty("contractDate")
    private String contractDate;
    @JsonProperty("contractTitle")
    private String contractTitle;
    @JsonProperty("sysContractAssignmentType")
    private Object sysContractAssignmentType;
    @JsonProperty("noticeNo")
    private String noticeNo;
    @JsonProperty("sysContractPhase")
    private Object sysContractPhase;
    @JsonProperty("contractValue")
    private Double contractValue;
    @JsonProperty("defaultCurrencyContractValue")
    private Object defaultCurrencyContractValue;
    @JsonProperty("currency")
    private GenericSeapData currency;
    @JsonProperty("awardedNoticeLotList")
    private List<AwardedNoticeLotList> awardedNoticeLotList = null;
    @JsonProperty("supplierWinners")
    private List<SupplierWinner> supplierWinners = null;
    @JsonProperty("parentContractId")
    private Object parentContractId;
    @JsonProperty("isSignedBySu")
    private Object isSignedBySu;
    @JsonProperty("originalContractId")
    private Long originalContractId;
    @JsonProperty("isCurrentVersion")
    private Boolean isCurrentVersion;
    @JsonProperty("actions")
    private Actions actions;
    @JsonProperty("conditions")
    private Conditions conditions;
    @JsonProperty("sysContractFrameworkTypeId")
    private Long sysContractFrameworkTypeId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("section5_2")
    public Section52 getSection52() {
        return section52;
    }

    @JsonProperty("section5_2")
    public void setSection52(Section52 section52) {
        this.section52 = section52;
    }

    @JsonProperty("caNoticeContractId")
    public Long getCaNoticeContractId() {
        return caNoticeContractId;
    }

    @JsonProperty("caNoticeContractId")
    public void setCaNoticeContractId(Long caNoticeContractId) {
        this.caNoticeContractId = caNoticeContractId;
    }

    @JsonProperty("contractId")
    public Long getContractId() {
        return contractId;
    }

    @JsonProperty("contractId")
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    @JsonProperty("caNoticeId")
    public Long getCaNoticeId() {
        return caNoticeId;
    }

    @JsonProperty("caNoticeId")
    public void setCaNoticeId(Long caNoticeId) {
        this.caNoticeId = caNoticeId;
    }

    @JsonProperty("contractNo")
    public String getContractNo() {
        return contractNo;
    }

    @JsonProperty("contractNo")
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @JsonProperty("contractDate")
    public String getContractDate() {
        return contractDate;
    }

    @JsonProperty("contractDate")
    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    @JsonProperty("contractTitle")
    public String getContractTitle() {
        return contractTitle;
    }

    @JsonProperty("contractTitle")
    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    @JsonProperty("sysContractAssignmentType")
    public Object getSysContractAssignmentType() {
        return sysContractAssignmentType;
    }

    @JsonProperty("sysContractAssignmentType")
    public void setSysContractAssignmentType(Object sysContractAssignmentType) {
        this.sysContractAssignmentType = sysContractAssignmentType;
    }

    @JsonProperty("noticeNo")
    public String getNoticeNo() {
        return noticeNo;
    }

    @JsonProperty("noticeNo")
    public void setNoticeNo(String noticeNo) {
        this.noticeNo = noticeNo;
    }

    @JsonProperty("sysContractPhase")
    public Object getSysContractPhase() {
        return sysContractPhase;
    }

    @JsonProperty("sysContractPhase")
    public void setSysContractPhase(Object sysContractPhase) {
        this.sysContractPhase = sysContractPhase;
    }

    @JsonProperty("contractValue")
    public Double getContractValue() {
        return contractValue;
    }

    @JsonProperty("contractValue")
    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }

    @JsonProperty("defaultCurrencyContractValue")
    public Object getDefaultCurrencyContractValue() {
        return defaultCurrencyContractValue;
    }

    @JsonProperty("defaultCurrencyContractValue")
    public void setDefaultCurrencyContractValue(Object defaultCurrencyContractValue) {
        this.defaultCurrencyContractValue = defaultCurrencyContractValue;
    }

    @JsonProperty("currency")
    public GenericSeapData getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(GenericSeapData currency) {
        this.currency = currency;
    }

    @JsonProperty("awardedNoticeLotList")
    public List<AwardedNoticeLotList> getAwardedNoticeLotList() {
        return awardedNoticeLotList;
    }

    @JsonProperty("awardedNoticeLotList")
    public void setAwardedNoticeLotList(List<AwardedNoticeLotList> awardedNoticeLotList) {
        this.awardedNoticeLotList = awardedNoticeLotList;
    }

    @JsonProperty("supplierWinners")
    public List<SupplierWinner> getSupplierWinners() {
        return supplierWinners;
    }

    @JsonProperty("supplierWinners")
    public void setSupplierWinners(List<SupplierWinner> supplierWinners) {
        this.supplierWinners = supplierWinners;
    }

    @JsonProperty("parentContractId")
    public Object getParentContractId() {
        return parentContractId;
    }

    @JsonProperty("parentContractId")
    public void setParentContractId(Object parentContractId) {
        this.parentContractId = parentContractId;
    }

    @JsonProperty("isSignedBySu")
    public Object getIsSignedBySu() {
        return isSignedBySu;
    }

    @JsonProperty("isSignedBySu")
    public void setIsSignedBySu(Object isSignedBySu) {
        this.isSignedBySu = isSignedBySu;
    }

    @JsonProperty("originalContractId")
    public Long getOriginalContractId() {
        return originalContractId;
    }

    @JsonProperty("originalContractId")
    public void setOriginalContractId(Long originalContractId) {
        this.originalContractId = originalContractId;
    }

    @JsonProperty("isCurrentVersion")
    public Boolean getIsCurrentVersion() {
        return isCurrentVersion;
    }

    @JsonProperty("isCurrentVersion")
    public void setIsCurrentVersion(Boolean isCurrentVersion) {
        this.isCurrentVersion = isCurrentVersion;
    }

    @JsonProperty("actions")
    public Actions getActions() {
        return actions;
    }

    @JsonProperty("actions")
    public void setActions(Actions actions) {
        this.actions = actions;
    }

    @JsonProperty("conditions")
    public Conditions getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(Conditions conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("sysContractFrameworkTypeId")
    public Long getSysContractFrameworkTypeId() {
        return sysContractFrameworkTypeId;
    }

    @JsonProperty("sysContractFrameworkTypeId")
    public void setSysContractFrameworkTypeId(Long sysContractFrameworkTypeId) {
        this.sysContractFrameworkTypeId = sysContractFrameworkTypeId;
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
