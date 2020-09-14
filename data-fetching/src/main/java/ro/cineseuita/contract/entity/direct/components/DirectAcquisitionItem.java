package ro.cineseuita.contract.entity.direct.components;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.shared.entityComponents.GenericSeapData;
import ro.cineseuita.shared.itemMeasurement.ItemMeasurement;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "directAcquisitionItemID",
        "catalogItemID",
        "catalogItemHistoryID",
        "sysCatalogItemStateID",
        "catalogItemCode",
        "catalogItemName",
        "catalogItemDescription",
        "catalogItemPrice",
        "itemClosingPrice",
        "itemEstimatedPrice",
        "secondCurrencyEstimatedPrice",
        "itemQuantity",
        "itemRequestedQuantity",
        "itemMeasureUnit",
        "isRejectedBySupplier",
        "hasQuantityCorrection",
        "imageUrl",
        "imageThumbUrl",
        "associatedPaapDetailName",
        "assignedUserEmail",
        "cpvCode",
        "isExpired",
        "itemHistory"
})
public class DirectAcquisitionItem {

    @JsonProperty("directAcquisitionItemID")
    private Integer directAcquisitionItemID;
    @JsonProperty("catalogItemID")
    private Integer catalogItemID;
    @JsonProperty("catalogItemHistoryID")
    private Integer catalogItemHistoryID;
    @JsonProperty("sysCatalogItemStateID")
    private Integer sysCatalogItemStateID;
    @JsonProperty("catalogItemCode")
    private String catalogItemCode;
    @JsonProperty("catalogItemName")
    private String catalogItemName;
    @JsonProperty("catalogItemDescription")
    private String catalogItemDescription;
    @JsonProperty("catalogItemPrice")
    private Double catalogItemPrice;
    @JsonProperty("itemClosingPrice")
    private Double itemClosingPrice;
    @JsonProperty("itemEstimatedPrice")
    private Double itemEstimatedPrice;
    @JsonProperty("secondCurrencyEstimatedPrice")
    private Double secondCurrencyEstimatedPrice;
    @JsonProperty("itemQuantity")
    private Double itemQuantity;
    @JsonProperty("itemRequestedQuantity")
    private Double itemRequestedQuantity;
    @JsonProperty("itemMeasureUnit")
    private String itemMeasureUnit;
    @JsonProperty("isRejectedBySupplier")
    private Boolean isRejectedBySupplier;
    @JsonProperty("hasQuantityCorrection")
    private Boolean hasQuantityCorrection;
    @JsonProperty("imageUrl")
    private Object imageUrl;
    @JsonProperty("imageThumbUrl")
    private Object imageThumbUrl;
    @JsonProperty("associatedPaapDetailName")
    private Object associatedPaapDetailName;
    @JsonProperty("assignedUserEmail")
    private String assignedUserEmail;
    @JsonProperty("cpvCode")
    private GenericSeapData cpvCode;
    @JsonProperty("isExpired")
    private Object isExpired;
    @JsonProperty("itemHistory")
    private Object itemHistory;

    private Double averageItemPrice;
    private Double averageDeviation;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    private ItemMeasurement itemMeasureClass;

    @JsonProperty("directAcquisitionItemID")
    public Integer getDirectAcquisitionItemID() {
        return directAcquisitionItemID;
    }

    @JsonProperty("directAcquisitionItemID")
    public void setDirectAcquisitionItemID(Integer directAcquisitionItemID) {
        this.directAcquisitionItemID = directAcquisitionItemID;
    }

    @JsonProperty("catalogItemID")
    public Integer getCatalogItemID() {
        return catalogItemID;
    }

    @JsonProperty("catalogItemID")
    public void setCatalogItemID(Integer catalogItemID) {
        this.catalogItemID = catalogItemID;
    }

    @JsonProperty("catalogItemHistoryID")
    public Integer getCatalogItemHistoryID() {
        return catalogItemHistoryID;
    }

    @JsonProperty("catalogItemHistoryID")
    public void setCatalogItemHistoryID(Integer catalogItemHistoryID) {
        this.catalogItemHistoryID = catalogItemHistoryID;
    }

    @JsonProperty("sysCatalogItemStateID")
    public Integer getSysCatalogItemStateID() {
        return sysCatalogItemStateID;
    }

    @JsonProperty("sysCatalogItemStateID")
    public void setSysCatalogItemStateID(Integer sysCatalogItemStateID) {
        this.sysCatalogItemStateID = sysCatalogItemStateID;
    }

    @JsonProperty("catalogItemCode")
    public String getCatalogItemCode() {
        return catalogItemCode;
    }

    @JsonProperty("catalogItemCode")
    public void setCatalogItemCode(String catalogItemCode) {
        this.catalogItemCode = catalogItemCode;
    }

    @JsonProperty("catalogItemName")
    public String getCatalogItemName() {
        return catalogItemName;
    }

    @JsonProperty("catalogItemName")
    public void setCatalogItemName(String catalogItemName) {
        this.catalogItemName = catalogItemName;
    }

    @JsonProperty("catalogItemDescription")
    public String getCatalogItemDescription() {
        return catalogItemDescription;
    }

    @JsonProperty("catalogItemDescription")
    public void setCatalogItemDescription(String catalogItemDescription) {
        this.catalogItemDescription = catalogItemDescription;
    }

    @JsonProperty("catalogItemPrice")
    public Double getCatalogItemPrice() {
        return catalogItemPrice;
    }

    @JsonProperty("catalogItemPrice")
    public void setCatalogItemPrice(Double catalogItemPrice) {
        this.catalogItemPrice = catalogItemPrice;
    }

    @JsonProperty("itemClosingPrice")
    public Double getItemClosingPrice() {
        return itemClosingPrice;
    }

    @JsonProperty("itemClosingPrice")
    public void setItemClosingPrice(Double itemClosingPrice) {
        this.itemClosingPrice = itemClosingPrice;
    }

    @JsonProperty("itemEstimatedPrice")
    public Double getItemEstimatedPrice() {
        return itemEstimatedPrice;
    }

    @JsonProperty("itemEstimatedPrice")
    public void setItemEstimatedPrice(Double itemEstimatedPrice) {
        this.itemEstimatedPrice = itemEstimatedPrice;
    }

    @JsonProperty("secondCurrencyEstimatedPrice")
    public Double getSecondCurrencyEstimatedPrice() {
        return secondCurrencyEstimatedPrice;
    }

    @JsonProperty("secondCurrencyEstimatedPrice")
    public void setSecondCurrencyEstimatedPrice(Double secondCurrencyEstimatedPrice) {
        this.secondCurrencyEstimatedPrice = secondCurrencyEstimatedPrice;
    }

    @JsonProperty("itemQuantity")
    public Double getItemQuantity() {
        return itemQuantity;
    }

    @JsonProperty("itemQuantity")
    public void setItemQuantity(Double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @JsonProperty("itemRequestedQuantity")
    public Double getItemRequestedQuantity() {
        return itemRequestedQuantity;
    }

    @JsonProperty("itemRequestedQuantity")
    public void setItemRequestedQuantity(Double itemRequestedQuantity) {
        this.itemRequestedQuantity = itemRequestedQuantity;
    }

    @JsonProperty("itemMeasureUnit")
    public String getItemMeasureUnit() {
        return itemMeasureUnit;
    }

    @JsonProperty("itemMeasureUnit")
    public void setItemMeasureUnit(String itemMeasureUnit) {
        this.itemMeasureUnit = itemMeasureUnit;
    }

    @JsonProperty("isRejectedBySupplier")
    public Boolean getIsRejectedBySupplier() {
        return isRejectedBySupplier;
    }

    @JsonProperty("isRejectedBySupplier")
    public void setIsRejectedBySupplier(Boolean isRejectedBySupplier) {
        this.isRejectedBySupplier = isRejectedBySupplier;
    }

    @JsonProperty("hasQuantityCorrection")
    public Boolean getHasQuantityCorrection() {
        return hasQuantityCorrection;
    }

    @JsonProperty("hasQuantityCorrection")
    public void setHasQuantityCorrection(Boolean hasQuantityCorrection) {
        this.hasQuantityCorrection = hasQuantityCorrection;
    }

    @JsonProperty("imageUrl")
    public Object getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("imageThumbUrl")
    public Object getImageThumbUrl() {
        return imageThumbUrl;
    }

    @JsonProperty("imageThumbUrl")
    public void setImageThumbUrl(Object imageThumbUrl) {
        this.imageThumbUrl = imageThumbUrl;
    }

    @JsonProperty("associatedPaapDetailName")
    public Object getAssociatedPaapDetailName() {
        return associatedPaapDetailName;
    }

    @JsonProperty("associatedPaapDetailName")
    public void setAssociatedPaapDetailName(Object associatedPaapDetailName) {
        this.associatedPaapDetailName = associatedPaapDetailName;
    }

    @JsonProperty("assignedUserEmail")
    public String getAssignedUserEmail() {
        return assignedUserEmail;
    }

    @JsonProperty("assignedUserEmail")
    public void setAssignedUserEmail(String assignedUserEmail) {
        this.assignedUserEmail = assignedUserEmail;
    }

    @JsonProperty("cpvCode")
    public GenericSeapData getCpvCode() {
        return cpvCode;
    }

    @JsonProperty("cpvCode")
    public void setCpvCode(GenericSeapData cpvCode) {
        this.cpvCode = cpvCode;
    }

    @JsonProperty("isExpired")
    public Object getIsExpired() {
        return isExpired;
    }

    @JsonProperty("isExpired")
    public void setIsExpired(Object isExpired) {
        this.isExpired = isExpired;
    }

    @JsonProperty("itemHistory")
    public Object getItemHistory() {
        return itemHistory;
    }

    @JsonProperty("itemHistory")
    public void setItemHistory(Object itemHistory) {
        this.itemHistory = itemHistory;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Double getAverageItemPrice() {
        return averageItemPrice;
    }

    public void setAverageItemPrice(Double averageItemPrice) {
        this.averageItemPrice = averageItemPrice;
    }

    public Double getAverageDeviation() {
        return averageDeviation;
    }

    public void setAverageDeviation(Double averageDeviation) {
        this.averageDeviation = averageDeviation;
    }

    public void computeAverageDeviation() {
        this.averageDeviation = this.itemClosingPrice / this.averageItemPrice;
    }

    public void setItemMeasureClass(ItemMeasurement itemMeasureClass) {
        this.itemMeasureClass = itemMeasureClass;
    }

    public ItemMeasurement getItemMeasureClass() {
        return itemMeasureClass;
    }
}
