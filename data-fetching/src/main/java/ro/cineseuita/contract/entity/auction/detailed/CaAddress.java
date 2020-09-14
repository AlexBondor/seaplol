package ro.cineseuita.contract.entity.auction.detailed;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.shared.entityComponents.GenericSeapData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "noticeId",
        "officialName",
        "address",
        "city",
        "cityItem",
        "postalCode",
        "postalCodeItem",
        "countryID",
        "country",
        "countryItem",
        "county",
        "email",
        "phone",
        "fax",
        "contactPoints",
        "attentionTo",
        "caMainAddressUrl",
        "buyerProfileUrl",
        "nutsCodeID",
        "nutsCode",
        "nutsCodeItem",
        "contactPerson",
        "internetAddressesUrl",
        "electronicInfoAccessUrl",
        "electronicDocumentsSendingUrl",
        "isSME",
        "sysNoticeEntityTypeID",
        "noticeEntityAddressId",
        "entityId",
        "entityItem",
        "isPublishingAgreed",
        "nationalIDNumber"
})
public class CaAddress {

    @JsonProperty("noticeId")
    private Long noticeId;
    @JsonProperty("officialName")
    private String officialName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("cityItem")
    private GenericSeapData cityItem;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("postalCodeItem")
    private Object postalCodeItem;
    @JsonProperty("countryID")
    private Long countryID;
    @JsonProperty("country")
    private String country;
    @JsonProperty("countryItem")
    private GenericSeapData countryItem;
    @JsonProperty("county")
    private GenericSeapData county;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("fax")
    private String fax;
    @JsonProperty("contactPoints")
    private String contactPoints;
    @JsonProperty("attentionTo")
    private String attentionTo;
    @JsonProperty("caMainAddressUrl")
    private String caMainAddressUrl;
    @JsonProperty("buyerProfileUrl")
    private String buyerProfileUrl;
    @JsonProperty("nutsCodeID")
    private Long nutsCodeID;
    @JsonProperty("nutsCode")
    private String nutsCode;
    @JsonProperty("nutsCodeItem")
    private GenericSeapData nutsCodeItem;
    @JsonProperty("contactPerson")
    private String contactPerson;
    @JsonProperty("internetAddressesUrl")
    private List<String> internetAddressesUrl = null;
    @JsonProperty("electronicInfoAccessUrl")
    private Object electronicInfoAccessUrl;
    @JsonProperty("electronicDocumentsSendingUrl")
    private Object electronicDocumentsSendingUrl;
    @JsonProperty("isSME")
    private Boolean isSME;
    @JsonProperty("sysNoticeEntityTypeID")
    private Long sysNoticeEntityTypeID;
    @JsonProperty("noticeEntityAddressId")
    private Long noticeEntityAddressId;
    @JsonProperty("entityId")
    private Long entityId;
    @JsonProperty("entityItem")
    private Object entityItem;
    @JsonProperty("isPublishingAgreed")
    private Object isPublishingAgreed;
    @JsonProperty("nationalIDNumber")
    private String nationalIDNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("noticeId")
    public Long getNoticeId() {
        return noticeId;
    }

    @JsonProperty("noticeId")
    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    @JsonProperty("officialName")
    public String getOfficialName() {
        return officialName;
    }

    @JsonProperty("officialName")
    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("cityItem")
    public GenericSeapData getCityItem() {
        return cityItem;
    }

    @JsonProperty("cityItem")
    public void setCityItem(GenericSeapData cityItem) {
        this.cityItem = cityItem;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("postalCodeItem")
    public Object getPostalCodeItem() {
        return postalCodeItem;
    }

    @JsonProperty("postalCodeItem")
    public void setPostalCodeItem(Object postalCodeItem) {
        this.postalCodeItem = postalCodeItem;
    }

    @JsonProperty("countryID")
    public Long getCountryID() {
        return countryID;
    }

    @JsonProperty("countryID")
    public void setCountryID(Long countryID) {
        this.countryID = countryID;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("countryItem")
    public GenericSeapData getCountryItem() {
        return countryItem;
    }

    @JsonProperty("countryItem")
    public void setCountryItem(GenericSeapData countryItem) {
        this.countryItem = countryItem;
    }

    @JsonProperty("county")
    public GenericSeapData getCounty() {
        return county;
    }

    @JsonProperty("county")
    public void setCounty(GenericSeapData county) {
        this.county = county;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("fax")
    public String getFax() {
        return fax;
    }

    @JsonProperty("fax")
    public void setFax(String fax) {
        this.fax = fax;
    }

    @JsonProperty("contactPoints")
    public String getContactPoints() {
        return contactPoints;
    }

    @JsonProperty("contactPoints")
    public void setContactPoints(String contactPoints) {
        this.contactPoints = contactPoints;
    }

    @JsonProperty("attentionTo")
    public String getAttentionTo() {
        return attentionTo;
    }

    @JsonProperty("attentionTo")
    public void setAttentionTo(String attentionTo) {
        this.attentionTo = attentionTo;
    }

    @JsonProperty("caMainAddressUrl")
    public String getCaMainAddressUrl() {
        return caMainAddressUrl;
    }

    @JsonProperty("caMainAddressUrl")
    public void setCaMainAddressUrl(String caMainAddressUrl) {
        this.caMainAddressUrl = caMainAddressUrl;
    }

    @JsonProperty("buyerProfileUrl")
    public String getBuyerProfileUrl() {
        return buyerProfileUrl;
    }

    @JsonProperty("buyerProfileUrl")
    public void setBuyerProfileUrl(String buyerProfileUrl) {
        this.buyerProfileUrl = buyerProfileUrl;
    }

    @JsonProperty("nutsCodeID")
    public Long getNutsCodeID() {
        return nutsCodeID;
    }

    @JsonProperty("nutsCodeID")
    public void setNutsCodeID(Long nutsCodeID) {
        this.nutsCodeID = nutsCodeID;
    }

    @JsonProperty("nutsCode")
    public String getNutsCode() {
        return nutsCode;
    }

    @JsonProperty("nutsCode")
    public void setNutsCode(String nutsCode) {
        this.nutsCode = nutsCode;
    }

    @JsonProperty("nutsCodeItem")
    public GenericSeapData getNutsCodeItem() {
        return nutsCodeItem;
    }

    @JsonProperty("nutsCodeItem")
    public void setNutsCodeItem(GenericSeapData nutsCodeItem) {
        this.nutsCodeItem = nutsCodeItem;
    }

    @JsonProperty("contactPerson")
    public String getContactPerson() {
        return contactPerson;
    }

    @JsonProperty("contactPerson")
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @JsonProperty("internetAddressesUrl")
    public List<String> getInternetAddressesUrl() {
        return internetAddressesUrl;
    }

    @JsonProperty("internetAddressesUrl")
    public void setInternetAddressesUrl(List<String> internetAddressesUrl) {
        this.internetAddressesUrl = internetAddressesUrl;
    }

    @JsonProperty("electronicInfoAccessUrl")
    public Object getElectronicInfoAccessUrl() {
        return electronicInfoAccessUrl;
    }

    @JsonProperty("electronicInfoAccessUrl")
    public void setElectronicInfoAccessUrl(Object electronicInfoAccessUrl) {
        this.electronicInfoAccessUrl = electronicInfoAccessUrl;
    }

    @JsonProperty("electronicDocumentsSendingUrl")
    public Object getElectronicDocumentsSendingUrl() {
        return electronicDocumentsSendingUrl;
    }

    @JsonProperty("electronicDocumentsSendingUrl")
    public void setElectronicDocumentsSendingUrl(Object electronicDocumentsSendingUrl) {
        this.electronicDocumentsSendingUrl = electronicDocumentsSendingUrl;
    }

    @JsonProperty("isSME")
    public Boolean getIsSME() {
        return isSME;
    }

    @JsonProperty("isSME")
    public void setIsSME(Boolean isSME) {
        this.isSME = isSME;
    }

    @JsonProperty("sysNoticeEntityTypeID")
    public Long getSysNoticeEntityTypeID() {
        return sysNoticeEntityTypeID;
    }

    @JsonProperty("sysNoticeEntityTypeID")
    public void setSysNoticeEntityTypeID(Long sysNoticeEntityTypeID) {
        this.sysNoticeEntityTypeID = sysNoticeEntityTypeID;
    }

    @JsonProperty("noticeEntityAddressId")
    public Long getNoticeEntityAddressId() {
        return noticeEntityAddressId;
    }

    @JsonProperty("noticeEntityAddressId")
    public void setNoticeEntityAddressId(Long noticeEntityAddressId) {
        this.noticeEntityAddressId = noticeEntityAddressId;
    }

    @JsonProperty("entityId")
    public Long getEntityId() {
        return entityId;
    }

    @JsonProperty("entityId")
    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    @JsonProperty("entityItem")
    public Object getEntityItem() {
        return entityItem;
    }

    @JsonProperty("entityItem")
    public void setEntityItem(Object entityItem) {
        this.entityItem = entityItem;
    }

    @JsonProperty("isPublishingAgreed")
    public Object getIsPublishingAgreed() {
        return isPublishingAgreed;
    }

    @JsonProperty("isPublishingAgreed")
    public void setIsPublishingAgreed(Object isPublishingAgreed) {
        this.isPublishingAgreed = isPublishingAgreed;
    }

    @JsonProperty("nationalIDNumber")
    public String getNationalIDNumber() {
        return nationalIDNumber;
    }

    @JsonProperty("nationalIDNumber")
    public void setNationalIDNumber(String nationalIDNumber) {
        this.nationalIDNumber = nationalIDNumber;
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
