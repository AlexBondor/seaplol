package ro.cineseuita.data.contract.auction.entity.detailed;

import com.fasterxml.jackson.annotation.*;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "isUtilityContract",
        "caNoticeEdit_New",
        "caNoticeEdit_New_U",
        "cNoticeId",
        "isView",
        "errorList",
        "hasErrors",
        "title",
        "caNoticeID",
        "isPPP",
        "noticeID",
        "previousPublicationNoticeID",
        "previousPublicationNoticeNumber",
        "sysContractAssignmentTypeID",
        "sysNoticeState",
        "sysNoticeType",
        "prevPubSysNoticeType",
        "contractingAuthorityType",
        "sysNoticeVersion",
        "procedureId",
        "isOnlineProcedure",
        "isLeProcedure",
        "paapModel",
        "paapSpentValue",
        "entityId",
        "legislationType",
        "procedureType",
        "parentCaNoticeId",
        "parentSysNoticeVersionId",
        "isCorrecting",
        "isCompleting",
        "isModifNotice",
        "versionNumber",
        "totalNotAwardedLots",
        "ackDocs",
        "noticeNumber",
        "createDate",
        "isCA",
        "acAssignedUser",
        "procedureHasLots",
        "publicationDate",
        "sentToJOUE",
        "tedNoticeNo",
        "ackDocsCount",
        "initState",
        "actions",
        "conditions"
})
@Document(collection = "auctionAcquisitionContractDetails")
public class AuctionAcquisitionContractDetails {

    @JsonProperty("isUtilityContract")
    private Boolean isUtilityContract;
    @JsonProperty("caNoticeEdit_New")
    private CaNoticeEditNew caNoticeEditNew;
    @JsonProperty("caNoticeEdit_New_U")
    private Object caNoticeEditNewU;
    @JsonProperty("cNoticeId")
    private Long cNoticeId;
    @JsonProperty("isView")
    private Boolean isView;
    @JsonProperty("errorList")
    private List<Object> errorList = null;
    @JsonProperty("hasErrors")
    private Boolean hasErrors;
    @JsonProperty("title")
    private String title;
    @JsonProperty("caNoticeID")
    private Long caNoticeID;
    @JsonProperty("isPPP")
    private Boolean isPPP;
    @JsonProperty("noticeID")
    private Long noticeID;
    @JsonProperty("previousPublicationNoticeID")
    private Long previousPublicationNoticeID;
    @JsonProperty("previousPublicationNoticeNumber")
    private Object previousPublicationNoticeNumber;
    @JsonProperty("sysContractAssignmentTypeID")
    private Long sysContractAssignmentTypeID;
    @JsonProperty("sysNoticeState")
    private GenericSeapData sysNoticeState;
    @JsonProperty("sysNoticeType")
    private GenericSeapData sysNoticeType;
    @JsonProperty("prevPubSysNoticeType")
    private GenericSeapData prevPubSysNoticeType;
    @JsonProperty("contractingAuthorityType")
    private GenericSeapData contractingAuthorityType;
    @JsonProperty("sysNoticeVersion")
    private GenericSeapData sysNoticeVersion;
    @JsonProperty("procedureId")
    private Long procedureId;
    @JsonProperty("isOnlineProcedure")
    private Boolean isOnlineProcedure;
    @JsonProperty("isLeProcedure")
    private Boolean isLeProcedure;
    @JsonProperty("paapModel")
    private PaapModel paapModel;
    @JsonProperty("paapSpentValue")
    private Double paapSpentValue;
    @JsonProperty("entityId")
    private Long entityId;
    @JsonProperty("legislationType")
    private GenericSeapData legislationType;
    @JsonProperty("procedureType")
    private GenericSeapData procedureType;
    @JsonProperty("parentCaNoticeId")
    private Object parentCaNoticeId;
    @JsonProperty("parentSysNoticeVersionId")
    private Object parentSysNoticeVersionId;
    @JsonProperty("isCorrecting")
    private Boolean isCorrecting;
    @JsonProperty("isCompleting")
    private Boolean isCompleting;
    @JsonProperty("isModifNotice")
    private Boolean isModifNotice;
    @JsonProperty("versionNumber")
    private Object versionNumber;
    @JsonProperty("totalNotAwardedLots")
    private Long totalNotAwardedLots;
    @JsonProperty("ackDocs")
    private List<Object> ackDocs = null;
    @JsonProperty("noticeNumber")
    private String noticeNumber;
    @JsonProperty("createDate")
    private String createDate;
    @JsonProperty("isCA")
    private Boolean isCA;
    @JsonProperty("acAssignedUser")
    private Object acAssignedUser;
    @JsonProperty("procedureHasLots")
    private Boolean procedureHasLots;
    @JsonProperty("publicationDate")
    private DateTime publicationDate;
    @JsonProperty("sentToJOUE")
    private Boolean sentToJOUE;
    @JsonProperty("tedNoticeNo")
    private String tedNoticeNo;
    @JsonProperty("ackDocsCount")
    private Long ackDocsCount;
    @JsonProperty("initState")
    private Object initState;
    @JsonProperty("actions")
    private Actions actions;
    @JsonProperty("conditions")
    private Conditions conditions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    private Integer year;

    private AuctionAcquisitionLots auctionAcquisitionLots;
    private AuctionAcquisitionSubcontracts auctionAcquisitionSubcontracts;

    @JsonProperty("isUtilityContract")
    public Boolean getIsUtilityContract() {
        return isUtilityContract;
    }

    @JsonProperty("isUtilityContract")
    public void setIsUtilityContract(Boolean isUtilityContract) {
        this.isUtilityContract = isUtilityContract;
    }

    @JsonProperty("caNoticeEdit_New")
    public CaNoticeEditNew getCaNoticeEditNew() {
        return caNoticeEditNew;
    }

    @JsonProperty("caNoticeEdit_New")
    public void setCaNoticeEditNew(CaNoticeEditNew caNoticeEditNew) {
        this.caNoticeEditNew = caNoticeEditNew;
    }

    @JsonProperty("caNoticeEdit_New_U")
    public Object getCaNoticeEditNewU() {
        return caNoticeEditNewU;
    }

    @JsonProperty("caNoticeEdit_New_U")
    public void setCaNoticeEditNewU(Object caNoticeEditNewU) {
        this.caNoticeEditNewU = caNoticeEditNewU;
    }

    @JsonProperty("cNoticeId")
    public Long getCNoticeId() {
        return cNoticeId;
    }

    @JsonProperty("cNoticeId")
    public void setCNoticeId(Long cNoticeId) {
        this.cNoticeId = cNoticeId;
    }

    @JsonProperty("isView")
    public Boolean getIsView() {
        return isView;
    }

    @JsonProperty("isView")
    public void setIsView(Boolean isView) {
        this.isView = isView;
    }

    @JsonProperty("errorList")
    public List<Object> getErrorList() {
        return errorList;
    }

    @JsonProperty("errorList")
    public void setErrorList(List<Object> errorList) {
        this.errorList = errorList;
    }

    @JsonProperty("hasErrors")
    public Boolean getHasErrors() {
        return hasErrors;
    }

    @JsonProperty("hasErrors")
    public void setHasErrors(Boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("caNoticeID")
    public Long getCaNoticeID() {
        return caNoticeID;
    }

    @JsonProperty("caNoticeID")
    public void setCaNoticeID(Long caNoticeID) {
        this.caNoticeID = caNoticeID;
    }

    @JsonProperty("isPPP")
    public Boolean getIsPPP() {
        return isPPP;
    }

    @JsonProperty("isPPP")
    public void setIsPPP(Boolean isPPP) {
        this.isPPP = isPPP;
    }

    @JsonProperty("noticeID")
    public Long getNoticeID() {
        return noticeID;
    }

    @JsonProperty("noticeID")
    public void setNoticeID(Long noticeID) {
        this.noticeID = noticeID;
    }

    @JsonProperty("previousPublicationNoticeID")
    public Long getPreviousPublicationNoticeID() {
        return previousPublicationNoticeID;
    }

    @JsonProperty("previousPublicationNoticeID")
    public void setPreviousPublicationNoticeID(Long previousPublicationNoticeID) {
        this.previousPublicationNoticeID = previousPublicationNoticeID;
    }

    @JsonProperty("previousPublicationNoticeNumber")
    public Object getPreviousPublicationNoticeNumber() {
        return previousPublicationNoticeNumber;
    }

    @JsonProperty("previousPublicationNoticeNumber")
    public void setPreviousPublicationNoticeNumber(Object previousPublicationNoticeNumber) {
        this.previousPublicationNoticeNumber = previousPublicationNoticeNumber;
    }

    @JsonProperty("sysContractAssignmentTypeID")
    public Long getSysContractAssignmentTypeID() {
        return sysContractAssignmentTypeID;
    }

    @JsonProperty("sysContractAssignmentTypeID")
    public void setSysContractAssignmentTypeID(Long sysContractAssignmentTypeID) {
        this.sysContractAssignmentTypeID = sysContractAssignmentTypeID;
    }

    @JsonProperty("sysNoticeState")
    public GenericSeapData getSysNoticeState() {
        return sysNoticeState;
    }

    @JsonProperty("sysNoticeState")
    public void setSysNoticeState(GenericSeapData sysNoticeState) {
        this.sysNoticeState = sysNoticeState;
    }

    @JsonProperty("sysNoticeType")
    public GenericSeapData getSysNoticeType() {
        return sysNoticeType;
    }

    @JsonProperty("sysNoticeType")
    public void setSysNoticeType(GenericSeapData sysNoticeType) {
        this.sysNoticeType = sysNoticeType;
    }

    @JsonProperty("prevPubSysNoticeType")
    public GenericSeapData getPrevPubSysNoticeType() {
        return prevPubSysNoticeType;
    }

    @JsonProperty("prevPubSysNoticeType")
    public void setPrevPubSysNoticeType(GenericSeapData prevPubSysNoticeType) {
        this.prevPubSysNoticeType = prevPubSysNoticeType;
    }

    @JsonProperty("contractingAuthorityType")
    public GenericSeapData getContractingAuthorityType() {
        return contractingAuthorityType;
    }

    @JsonProperty("contractingAuthorityType")
    public void setContractingAuthorityType(GenericSeapData contractingAuthorityType) {
        this.contractingAuthorityType = contractingAuthorityType;
    }

    @JsonProperty("sysNoticeVersion")
    public GenericSeapData getSysNoticeVersion() {
        return sysNoticeVersion;
    }

    @JsonProperty("sysNoticeVersion")
    public void setSysNoticeVersion(GenericSeapData sysNoticeVersion) {
        this.sysNoticeVersion = sysNoticeVersion;
    }

    @JsonProperty("procedureId")
    public Long getProcedureId() {
        return procedureId;
    }

    @JsonProperty("procedureId")
    public void setProcedureId(Long procedureId) {
        this.procedureId = procedureId;
    }

    @JsonProperty("isOnlineProcedure")
    public Boolean getIsOnlineProcedure() {
        return isOnlineProcedure;
    }

    @JsonProperty("isOnlineProcedure")
    public void setIsOnlineProcedure(Boolean isOnlineProcedure) {
        this.isOnlineProcedure = isOnlineProcedure;
    }

    @JsonProperty("isLeProcedure")
    public Boolean getIsLeProcedure() {
        return isLeProcedure;
    }

    @JsonProperty("isLeProcedure")
    public void setIsLeProcedure(Boolean isLeProcedure) {
        this.isLeProcedure = isLeProcedure;
    }

    @JsonProperty("paapModel")
    public PaapModel getPaapModel() {
        return paapModel;
    }

    @JsonProperty("paapModel")
    public void setPaapModel(PaapModel paapModel) {
        this.paapModel = paapModel;
    }

    @JsonProperty("paapSpentValue")
    public Double getPaapSpentValue() {
        return paapSpentValue;
    }

    @JsonProperty("paapSpentValue")
    public void setPaapSpentValue(Double paapSpentValue) {
        this.paapSpentValue = paapSpentValue;
    }

    @JsonProperty("entityId")
    public Long getEntityId() {
        return entityId;
    }

    @JsonProperty("entityId")
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    @JsonProperty("legislationType")
    public GenericSeapData getLegislationType() {
        return legislationType;
    }

    @JsonProperty("legislationType")
    public void setLegislationType(GenericSeapData legislationType) {
        this.legislationType = legislationType;
    }

    @JsonProperty("procedureType")
    public GenericSeapData getProcedureType() {
        return procedureType;
    }

    @JsonProperty("procedureType")
    public void setProcedureType(GenericSeapData procedureType) {
        this.procedureType = procedureType;
    }

    @JsonProperty("parentCaNoticeId")
    public Object getParentCaNoticeId() {
        return parentCaNoticeId;
    }

    @JsonProperty("parentCaNoticeId")
    public void setParentCaNoticeId(Object parentCaNoticeId) {
        this.parentCaNoticeId = parentCaNoticeId;
    }

    @JsonProperty("parentSysNoticeVersionId")
    public Object getParentSysNoticeVersionId() {
        return parentSysNoticeVersionId;
    }

    @JsonProperty("parentSysNoticeVersionId")
    public void setParentSysNoticeVersionId(Object parentSysNoticeVersionId) {
        this.parentSysNoticeVersionId = parentSysNoticeVersionId;
    }

    @JsonProperty("isCorrecting")
    public Boolean getIsCorrecting() {
        return isCorrecting;
    }

    @JsonProperty("isCorrecting")
    public void setIsCorrecting(Boolean isCorrecting) {
        this.isCorrecting = isCorrecting;
    }

    @JsonProperty("isCompleting")
    public Boolean getIsCompleting() {
        return isCompleting;
    }

    @JsonProperty("isCompleting")
    public void setIsCompleting(Boolean isCompleting) {
        this.isCompleting = isCompleting;
    }

    @JsonProperty("isModifNotice")
    public Boolean getIsModifNotice() {
        return isModifNotice;
    }

    @JsonProperty("isModifNotice")
    public void setIsModifNotice(Boolean isModifNotice) {
        this.isModifNotice = isModifNotice;
    }

    @JsonProperty("versionNumber")
    public Object getVersionNumber() {
        return versionNumber;
    }

    @JsonProperty("versionNumber")
    public void setVersionNumber(Object versionNumber) {
        this.versionNumber = versionNumber;
    }

    @JsonProperty("totalNotAwardedLots")
    public Long getTotalNotAwardedLots() {
        return totalNotAwardedLots;
    }

    @JsonProperty("totalNotAwardedLots")
    public void setTotalNotAwardedLots(Long totalNotAwardedLots) {
        this.totalNotAwardedLots = totalNotAwardedLots;
    }

    @JsonProperty("ackDocs")
    public List<Object> getAckDocs() {
        return ackDocs;
    }

    @JsonProperty("ackDocs")
    public void setAckDocs(List<Object> ackDocs) {
        this.ackDocs = ackDocs;
    }

    @JsonProperty("noticeNumber")
    public String getNoticeNumber() {
        return noticeNumber;
    }

    @JsonProperty("noticeNumber")
    public void setNoticeNumber(String noticeNumber) {
        this.noticeNumber = noticeNumber;
    }

    @JsonProperty("createDate")
    public String getCreateDate() {
        return createDate;
    }

    @JsonProperty("createDate")
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @JsonProperty("isCA")
    public Boolean getIsCA() {
        return isCA;
    }

    @JsonProperty("isCA")
    public void setIsCA(Boolean isCA) {
        this.isCA = isCA;
    }

    @JsonProperty("acAssignedUser")
    public Object getAcAssignedUser() {
        return acAssignedUser;
    }

    @JsonProperty("acAssignedUser")
    public void setAcAssignedUser(Object acAssignedUser) {
        this.acAssignedUser = acAssignedUser;
    }

    @JsonProperty("procedureHasLots")
    public Boolean getProcedureHasLots() {
        return procedureHasLots;
    }

    @JsonProperty("procedureHasLots")
    public void setProcedureHasLots(Boolean procedureHasLots) {
        this.procedureHasLots = procedureHasLots;
    }

    @JsonProperty("publicationDate")
    public DateTime getPublicationDate() {
        return publicationDate;
    }

    @JsonProperty("publicationDate")
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = new DateTime(publicationDate);
    }

    @JsonProperty("sentToJOUE")
    public Boolean getSentToJOUE() {
        return sentToJOUE;
    }

    @JsonProperty("sentToJOUE")
    public void setSentToJOUE(Boolean sentToJOUE) {
        this.sentToJOUE = sentToJOUE;
    }

    @JsonProperty("tedNoticeNo")
    public String getTedNoticeNo() {
        return tedNoticeNo;
    }

    @JsonProperty("tedNoticeNo")
    public void setTedNoticeNo(String tedNoticeNo) {
        this.tedNoticeNo = tedNoticeNo;
    }

    @JsonProperty("ackDocsCount")
    public Long getAckDocsCount() {
        return ackDocsCount;
    }

    @JsonProperty("ackDocsCount")
    public void setAckDocsCount(Long ackDocsCount) {
        this.ackDocsCount = ackDocsCount;
    }

    @JsonProperty("initState")
    public Object getInitState() {
        return initState;
    }

    @JsonProperty("initState")
    public void setInitState(Object initState) {
        this.initState = initState;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public AuctionAcquisitionLots getAuctionAcquisitionLots() {
        return auctionAcquisitionLots;
    }

    public void setAuctionAcquisitionLots(AuctionAcquisitionLots auctionAcquisitionLots) {
        this.auctionAcquisitionLots = auctionAcquisitionLots;
    }

    public AuctionAcquisitionSubcontracts getAuctionAcquisitionSubcontracts() {
        return auctionAcquisitionSubcontracts;
    }

    public void setAuctionAcquisitionSubcontracts(AuctionAcquisitionSubcontracts auctionAcquisitionSubcontracts) {
        this.auctionAcquisitionSubcontracts = auctionAcquisitionSubcontracts;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
