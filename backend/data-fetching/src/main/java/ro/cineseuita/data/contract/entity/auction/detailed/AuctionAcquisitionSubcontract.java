package ro.cineseuita.data.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;
import org.joda.time.DateTime;
import ro.cineseuita.data.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "caNoticeContractId",
        "contractId",
        "caNoticeId",
        "noticeNo",
        "contractNo",
        "contractDate",
        "contractTitle",
        "winnerCaption",
        "winner",
        "winners",
        "lotsCaption",
        "lotsNoCaption",
        "contractValue",
        "currency",
        "defaultCurrencyContractValue",
        "currencyRate",
        "hasElectronicContract",
        "electronicContractId",
        "sysElectronicContractStateId",
        "parentElectronicContractId",
        "contractValueMinOffer",
        "contractValueMaxOffer",
        "defaultCurrencyContractValueMinOffer",
        "defaultCurrencyContractValueMaxOffer",
        "hasModifiedVersions",
        "modifiedCount",
        "actions",
        "conditions",
        "contractType"
})
public class AuctionAcquisitionSubcontract {

    @JsonProperty("caNoticeContractId")
    private Long caNoticeContractId;
    @JsonProperty("contractId")
    private Object contractId;
    @JsonProperty("caNoticeId")
    private Long caNoticeId;
    @JsonProperty("noticeNo")
    private String noticeNo;
    @JsonProperty("contractNo")
    private String contractNo;
    @JsonProperty("contractDate")
    private DateTime contractDate;
    @JsonProperty("contractTitle")
    private String contractTitle;
    @JsonProperty("winnerCaption")
    private String winnerCaption;
    @JsonProperty("winner")
    private Winner winner;
    @JsonProperty("winners")
    private List<Winner> winners = null;
    @JsonProperty("lotsCaption")
    private String lotsCaption;
    @JsonProperty("lotsNoCaption")
    private String lotsNoCaption;
    @JsonProperty("contractValue")
    private Double contractValue;
    @JsonProperty("currency")
    private GenericSeapData currency;
    @JsonProperty("defaultCurrencyContractValue")
    private Double defaultCurrencyContractValue;
    @JsonProperty("currencyRate")
    private Double currencyRate;
    @JsonProperty("hasElectronicContract")
    private Boolean hasElectronicContract;
    @JsonProperty("electronicContractId")
    private Object electronicContractId;
    @JsonProperty("sysElectronicContractStateId")
    private Object sysElectronicContractStateId;
    @JsonProperty("parentElectronicContractId")
    private Object parentElectronicContractId;
    @JsonProperty("contractValueMinOffer")
    private Object contractValueMinOffer;
    @JsonProperty("contractValueMaxOffer")
    private Object contractValueMaxOffer;
    @JsonProperty("defaultCurrencyContractValueMinOffer")
    private Object defaultCurrencyContractValueMinOffer;
    @JsonProperty("defaultCurrencyContractValueMaxOffer")
    private Object defaultCurrencyContractValueMaxOffer;
    @JsonProperty("hasModifiedVersions")
    private Boolean hasModifiedVersions;
    @JsonProperty("modifiedCount")
    private Long modifiedCount;
    @JsonProperty("actions")
    private Actions actions;
    @JsonProperty("conditions")
    private Conditions conditions;
    @JsonProperty("contractType")
    private Long contractType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("caNoticeContractId")
    public Long getCaNoticeContractId() {
        return caNoticeContractId;
    }

    @JsonProperty("caNoticeContractId")
    public void setCaNoticeContractId(Long caNoticeContractId) {
        this.caNoticeContractId = caNoticeContractId;
    }

    @JsonProperty("contractId")
    public Object getContractId() {
        return contractId;
    }

    @JsonProperty("contractId")
    public void setContractId(Object contractId) {
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

    @JsonProperty("noticeNo")
    public String getNoticeNo() {
        return noticeNo;
    }

    @JsonProperty("noticeNo")
    public void setNoticeNo(String noticeNo) {
        this.noticeNo = noticeNo;
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
    public DateTime getContractDate() {
        return contractDate;
    }

    @JsonProperty("contractDate")
    public void setContractDate(String contractDate) {
        this.contractDate = new DateTime(contractDate);
    }

    @JsonProperty("contractTitle")
    public String getContractTitle() {
        return contractTitle;
    }

    @JsonProperty("contractTitle")
    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    @JsonProperty("winnerCaption")
    public String getWinnerCaption() {
        return winnerCaption;
    }

    @JsonProperty("winnerCaption")
    public void setWinnerCaption(String winnerCaption) {
        this.winnerCaption = winnerCaption;
    }

    @JsonProperty("winner")
    public Winner getWinner() {
        return winner;
    }

    @JsonProperty("winner")
    public void setWinner(Winner winner) {
        this.winner = winner;
    }

    @JsonProperty("winners")
    public List<Winner> getWinners() {
        return winners;
    }

    @JsonProperty("winners")
    public void setWinners(List<Winner> winners) {
        this.winners = winners;
    }

    @JsonProperty("lotsCaption")
    public String getLotsCaption() {
        return lotsCaption;
    }

    @JsonProperty("lotsCaption")
    public void setLotsCaption(String lotsCaption) {
        this.lotsCaption = lotsCaption;
    }

    @JsonProperty("lotsNoCaption")
    public String getLotsNoCaption() {
        return lotsNoCaption;
    }

    @JsonProperty("lotsNoCaption")
    public void setLotsNoCaption(String lotsNoCaption) {
        this.lotsNoCaption = lotsNoCaption;
    }

    @JsonProperty("contractValue")
    public Double getContractValue() {
        return contractValue;
    }

    @JsonProperty("contractValue")
    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }

    @JsonProperty("currency")
    public GenericSeapData getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(GenericSeapData currency) {
        this.currency = currency;
    }

    @JsonProperty("defaultCurrencyContractValue")
    public Double getDefaultCurrencyContractValue() {
        return defaultCurrencyContractValue;
    }

    @JsonProperty("defaultCurrencyContractValue")
    public void setDefaultCurrencyContractValue(Double defaultCurrencyContractValue) {
        this.defaultCurrencyContractValue = defaultCurrencyContractValue;
    }

    @JsonProperty("currencyRate")
    public Double getCurrencyRate() {
        return currencyRate;
    }

    @JsonProperty("currencyRate")
    public void setCurrencyRate(Double currencyRate) {
        this.currencyRate = currencyRate;
    }

    @JsonProperty("hasElectronicContract")
    public Boolean getHasElectronicContract() {
        return hasElectronicContract;
    }

    @JsonProperty("hasElectronicContract")
    public void setHasElectronicContract(Boolean hasElectronicContract) {
        this.hasElectronicContract = hasElectronicContract;
    }

    @JsonProperty("electronicContractId")
    public Object getElectronicContractId() {
        return electronicContractId;
    }

    @JsonProperty("electronicContractId")
    public void setElectronicContractId(Object electronicContractId) {
        this.electronicContractId = electronicContractId;
    }

    @JsonProperty("sysElectronicContractStateId")
    public Object getSysElectronicContractStateId() {
        return sysElectronicContractStateId;
    }

    @JsonProperty("sysElectronicContractStateId")
    public void setSysElectronicContractStateId(Object sysElectronicContractStateId) {
        this.sysElectronicContractStateId = sysElectronicContractStateId;
    }

    @JsonProperty("parentElectronicContractId")
    public Object getParentElectronicContractId() {
        return parentElectronicContractId;
    }

    @JsonProperty("parentElectronicContractId")
    public void setParentElectronicContractId(Object parentElectronicContractId) {
        this.parentElectronicContractId = parentElectronicContractId;
    }

    @JsonProperty("contractValueMinOffer")
    public Object getContractValueMinOffer() {
        return contractValueMinOffer;
    }

    @JsonProperty("contractValueMinOffer")
    public void setContractValueMinOffer(Object contractValueMinOffer) {
        this.contractValueMinOffer = contractValueMinOffer;
    }

    @JsonProperty("contractValueMaxOffer")
    public Object getContractValueMaxOffer() {
        return contractValueMaxOffer;
    }

    @JsonProperty("contractValueMaxOffer")
    public void setContractValueMaxOffer(Object contractValueMaxOffer) {
        this.contractValueMaxOffer = contractValueMaxOffer;
    }

    @JsonProperty("defaultCurrencyContractValueMinOffer")
    public Object getDefaultCurrencyContractValueMinOffer() {
        return defaultCurrencyContractValueMinOffer;
    }

    @JsonProperty("defaultCurrencyContractValueMinOffer")
    public void setDefaultCurrencyContractValueMinOffer(Object defaultCurrencyContractValueMinOffer) {
        this.defaultCurrencyContractValueMinOffer = defaultCurrencyContractValueMinOffer;
    }

    @JsonProperty("defaultCurrencyContractValueMaxOffer")
    public Object getDefaultCurrencyContractValueMaxOffer() {
        return defaultCurrencyContractValueMaxOffer;
    }

    @JsonProperty("defaultCurrencyContractValueMaxOffer")
    public void setDefaultCurrencyContractValueMaxOffer(Object defaultCurrencyContractValueMaxOffer) {
        this.defaultCurrencyContractValueMaxOffer = defaultCurrencyContractValueMaxOffer;
    }

    @JsonProperty("hasModifiedVersions")
    public Boolean getHasModifiedVersions() {
        return hasModifiedVersions;
    }

    @JsonProperty("hasModifiedVersions")
    public void setHasModifiedVersions(Boolean hasModifiedVersions) {
        this.hasModifiedVersions = hasModifiedVersions;
    }

    @JsonProperty("modifiedCount")
    public Long getModifiedCount() {
        return modifiedCount;
    }

    @JsonProperty("modifiedCount")
    public void setModifiedCount(Long modifiedCount) {
        this.modifiedCount = modifiedCount;
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

    @JsonProperty("contractType")
    public Long getContractType() {
        return contractType;
    }

    @JsonProperty("contractType")
    public void setContractType(Long contractType) {
        this.contractType = contractType;
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
