package ro.cineseuita.data.contract.auction.entity;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "caNoticeId",
        "noticeId",
        "procedureId",
        "noticeNo",
        "sysNoticeTypeId",
        "sysNoticeState",
        "sysProcedureState",
        "contractingAuthorityNameAndFN",
        "contractTitle",
        "sysAcquisitionContractType",
        "sysProcedureType",
        "sysContractAssigmentType",
        "cpvCodeAndName",
        "ronContractValue",
        "isOnline",
        "noticeStateDate",
        "minTenderReceiptDeadline",
        "maxTenderReceiptDeadline",
        "errataNo",
        "versionNo",
        "sysNoticeVersionId",
        "tenderReceiptDeadlineExport",
        "estimatedValueExport",
        "highestOfferValue",
        "lowestOfferValue",
        "hasSubsequentContracts",
        "isUtility",
        "isPPP",
        "currencyCode"
})
@Document(collection = "auctionAcquisitionContract")
public class AuctionAcquisitionContract {

    @JsonProperty("caNoticeId")
    private Long caNoticeId;
    @JsonProperty("noticeId")
    private Long noticeId;
    @JsonProperty("procedureId")
    private Object procedureId;
    @JsonProperty("noticeNo")
    private String noticeNo;
    @JsonProperty("sysNoticeTypeId")
    private Long sysNoticeTypeId;
    @JsonProperty("sysNoticeState")
    private GenericSeapData auctionAcquisitionNoticeState;
    @JsonProperty("sysProcedureState")
    private GenericSeapData auctionAcquisitionProcedureState;
    @JsonProperty("contractingAuthorityNameAndFN")
    private String contractingAuthorityNameAndFN;
    @JsonProperty("contractTitle")
    private String contractTitle;
    @JsonProperty("sysAcquisitionContractType")
    private GenericSeapData contractType;
    @JsonProperty("sysProcedureType")
    private GenericSeapData auctionAcquisitionProcedureType;
    @JsonProperty("sysContractAssigmentType")
    private GenericSeapData auctionAcquisitionContractAssignmentType;
    @JsonProperty("cpvCodeAndName")
    private String cpvCodeAndName;
    @JsonProperty("ronContractValue")
    private Double ronContractValue;
    @JsonProperty("isOnline")
    private Boolean isOnline;
    @JsonProperty("noticeStateDate")
    private String noticeStateDate;
    @JsonProperty("minTenderReceiptDeadline")
    private Object minTenderReceiptDeadline;
    @JsonProperty("maxTenderReceiptDeadline")
    private Object maxTenderReceiptDeadline;
    @JsonProperty("errataNo")
    private Long errataNo;
    @JsonProperty("versionNo")
    private Object versionNo;
    @JsonProperty("sysNoticeVersionId")
    private Long sysNoticeVersionId;
    @JsonProperty("tenderReceiptDeadlineExport")
    private Object tenderReceiptDeadlineExport;
    @JsonProperty("estimatedValueExport")
    private String estimatedValueExport;
    @JsonProperty("highestOfferValue")
    private Double highestOfferValue;
    @JsonProperty("lowestOfferValue")
    private Double lowestOfferValue;
    @JsonProperty("hasSubsequentContracts")
    private Boolean hasSubsequentContracts;
    @JsonProperty("isUtility")
    private Boolean isUtility;
    @JsonProperty("isPPP")
    private Boolean isPPP;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    private Integer year;

    @JsonProperty("caNoticeId")
    public Long getCaNoticeId() {
        return caNoticeId;
    }

    @JsonProperty("caNoticeId")
    public void setCaNoticeId(Long caNoticeId) {
        this.caNoticeId = caNoticeId;
    }

    @JsonProperty("noticeId")
    public Long getNoticeId() {
        return noticeId;
    }

    @JsonProperty("noticeId")
    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    @JsonProperty("procedureId")
    public Object getProcedureId() {
        return procedureId;
    }

    @JsonProperty("procedureId")
    public void setProcedureId(Object procedureId) {
        this.procedureId = procedureId;
    }

    @JsonProperty("noticeNo")
    public String getNoticeNo() {
        return noticeNo;
    }

    @JsonProperty("noticeNo")
    public void setNoticeNo(String noticeNo) {
        this.noticeNo = noticeNo;
    }

    @JsonProperty("sysNoticeTypeId")
    public Long getSysNoticeTypeId() {
        return sysNoticeTypeId;
    }

    @JsonProperty("sysNoticeTypeId")
    public void setSysNoticeTypeId(Long sysNoticeTypeId) {
        this.sysNoticeTypeId = sysNoticeTypeId;
    }

    @JsonProperty("sysNoticeState")
    public GenericSeapData getSAuctionAcquisitionNoticeState() {
        return auctionAcquisitionNoticeState;
    }

    @JsonProperty("sysNoticeState")
    public void setAuctionAcquisitionNoticeState(GenericSeapData auctionAcquisitionNoticeState) {
        this.auctionAcquisitionNoticeState = auctionAcquisitionNoticeState;
    }

    @JsonProperty("sysProcedureState")
    public GenericSeapData getAuctionAcquisitionProcedureState() {
        return auctionAcquisitionProcedureState;
    }

    @JsonProperty("sysProcedureState")
    public void setAuctionAcquisitionProcedureState(GenericSeapData auctionAcquisitionProcedureState) {
        this.auctionAcquisitionProcedureState = auctionAcquisitionProcedureState;
    }

    @JsonProperty("contractingAuthorityNameAndFN")
    public String getContractingAuthorityNameAndFN() {
        return contractingAuthorityNameAndFN;
    }

    @JsonProperty("contractingAuthorityNameAndFN")
    public void setContractingAuthorityNameAndFN(String contractingAuthorityNameAndFN) {
        this.contractingAuthorityNameAndFN = contractingAuthorityNameAndFN;
    }

    @JsonProperty("contractTitle")
    public String getContractTitle() {
        return contractTitle;
    }

    @JsonProperty("contractTitle")
    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    @JsonProperty("sysAcquisitionContractType")
    public GenericSeapData getContractType() {
        return contractType;
    }

    @JsonProperty("sysAcquisitionContractType")
    public void setContractType(GenericSeapData contractType) {
        this.contractType = contractType;
    }

    @JsonProperty("sysProcedureType")
    public GenericSeapData getAuctionAcquisitionProcedureType() {
        return auctionAcquisitionProcedureType;
    }

    @JsonProperty("sysProcedureType")
    public void setAuctionAcquisitionProcedureType(GenericSeapData auctionAcquisitionProcedureType) {
        this.auctionAcquisitionProcedureType = auctionAcquisitionProcedureType;
    }

    @JsonProperty("sysContractAssigmentType")
    public GenericSeapData getAuctionAcquisitionContractAssignmentType() {
        return auctionAcquisitionContractAssignmentType;
    }

    @JsonProperty("sysContractAssigmentType")
    public void setAuctionAcquisitionContractAssignmentType(GenericSeapData auctionAcquisitionContractAssignmentType) {
        this.auctionAcquisitionContractAssignmentType = auctionAcquisitionContractAssignmentType;
    }

    @JsonProperty("cpvCodeAndName")
    public String getCpvCodeAndName() {
        return cpvCodeAndName;
    }

    @JsonProperty("cpvCodeAndName")
    public void setCpvCodeAndName(String cpvCodeAndName) {
        this.cpvCodeAndName = cpvCodeAndName;
    }

    @JsonProperty("ronContractValue")
    public Double getRonContractValue() {
        return ronContractValue;
    }

    @JsonProperty("ronContractValue")
    public void setRonContractValue(Double ronContractValue) {
        this.ronContractValue = ronContractValue;
    }

    @JsonProperty("isOnline")
    public Boolean getIsOnline() {
        return isOnline;
    }

    @JsonProperty("isOnline")
    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    @JsonProperty("noticeStateDate")
    public String getNoticeStateDate() {
        return noticeStateDate;
    }

    @JsonProperty("noticeStateDate")
    public void setNoticeStateDate(String noticeStateDate) {
        this.noticeStateDate = noticeStateDate;
    }

    @JsonProperty("minTenderReceiptDeadline")
    public Object getMinTenderReceiptDeadline() {
        return minTenderReceiptDeadline;
    }

    @JsonProperty("minTenderReceiptDeadline")
    public void setMinTenderReceiptDeadline(Object minTenderReceiptDeadline) {
        this.minTenderReceiptDeadline = minTenderReceiptDeadline;
    }

    @JsonProperty("maxTenderReceiptDeadline")
    public Object getMaxTenderReceiptDeadline() {
        return maxTenderReceiptDeadline;
    }

    @JsonProperty("maxTenderReceiptDeadline")
    public void setMaxTenderReceiptDeadline(Object maxTenderReceiptDeadline) {
        this.maxTenderReceiptDeadline = maxTenderReceiptDeadline;
    }

    @JsonProperty("errataNo")
    public Long getErrataNo() {
        return errataNo;
    }

    @JsonProperty("errataNo")
    public void setErrataNo(Long errataNo) {
        this.errataNo = errataNo;
    }

    @JsonProperty("versionNo")
    public Object getVersionNo() {
        return versionNo;
    }

    @JsonProperty("versionNo")
    public void setVersionNo(Object versionNo) {
        this.versionNo = versionNo;
    }

    @JsonProperty("sysNoticeVersionId")
    public Long getSysNoticeVersionId() {
        return sysNoticeVersionId;
    }

    @JsonProperty("sysNoticeVersionId")
    public void setSysNoticeVersionId(Long sysNoticeVersionId) {
        this.sysNoticeVersionId = sysNoticeVersionId;
    }

    @JsonProperty("tenderReceiptDeadlineExport")
    public Object getTenderReceiptDeadlineExport() {
        return tenderReceiptDeadlineExport;
    }

    @JsonProperty("tenderReceiptDeadlineExport")
    public void setTenderReceiptDeadlineExport(Object tenderReceiptDeadlineExport) {
        this.tenderReceiptDeadlineExport = tenderReceiptDeadlineExport;
    }

    @JsonProperty("estimatedValueExport")
    public String getEstimatedValueExport() {
        return estimatedValueExport;
    }

    @JsonProperty("estimatedValueExport")
    public void setEstimatedValueExport(String estimatedValueExport) {
        this.estimatedValueExport = estimatedValueExport;
    }

    @JsonProperty("highestOfferValue")
    public Double getHighestOfferValue() {
        return highestOfferValue;
    }

    @JsonProperty("highestOfferValue")
    public void setHighestOfferValue(Double highestOfferValue) {
        this.highestOfferValue = highestOfferValue;
    }

    @JsonProperty("lowestOfferValue")
    public Double getLowestOfferValue() {
        return lowestOfferValue;
    }

    @JsonProperty("lowestOfferValue")
    public void setLowestOfferValue(Double lowestOfferValue) {
        this.lowestOfferValue = lowestOfferValue;
    }

    @JsonProperty("hasSubsequentContracts")
    public Boolean getHasSubsequentContracts() {
        return hasSubsequentContracts;
    }

    @JsonProperty("hasSubsequentContracts")
    public void setHasSubsequentContracts(Boolean hasSubsequentContracts) {
        this.hasSubsequentContracts = hasSubsequentContracts;
    }

    @JsonProperty("isUtility")
    public Boolean getIsUtility() {
        return isUtility;
    }

    @JsonProperty("isUtility")
    public void setIsUtility(Boolean isUtility) {
        this.isUtility = isUtility;
    }

    @JsonProperty("isPPP")
    public Boolean getIsPPP() {
        return isPPP;
    }

    @JsonProperty("isPPP")
    public void setIsPPP(Boolean isPPP) {
        this.isPPP = isPPP;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
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
}
