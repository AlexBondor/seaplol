package ro.cineseuita.contract.direct.entity;

public class DirectContractItem {
    private Integer directAcquisitionItemID;
    private String catalogItemName;
    private String catalogItemDescription;
    private Double catalogItemPrice;
    private Double itemEstimatedPrice;
    private Double itemClosingPrice;
    private Double itemQuantity;
    private Double itemRequestedQuantity;
    private String itemMeasureUnit;
    private String assignedUserEmail;

    public Integer getDirectAcquisitionItemID() {
        return directAcquisitionItemID;
    }

    public void setDirectAcquisitionItemID(Integer directAcquisitionItemID) {
        this.directAcquisitionItemID = directAcquisitionItemID;
    }

    public String getCatalogItemName() {
        return catalogItemName;
    }

    public void setCatalogItemName(String catalogItemName) {
        this.catalogItemName = catalogItemName;
    }

    public String getCatalogItemDescription() {
        return catalogItemDescription;
    }

    public void setCatalogItemDescription(String catalogItemDescription) {
        this.catalogItemDescription = catalogItemDescription;
    }

    public Double getCatalogItemPrice() {
        return catalogItemPrice;
    }

    public void setCatalogItemPrice(Double catalogItemPrice) {
        this.catalogItemPrice = catalogItemPrice;
    }

    public Double getItemEstimatedPrice() {
        return itemEstimatedPrice;
    }

    public void setItemEstimatedPrice(Double itemEstimatedPrice) {
        this.itemEstimatedPrice = itemEstimatedPrice;
    }

    public Double getItemClosingPrice() {
        return itemClosingPrice;
    }

    public void setItemClosingPrice(Double itemClosingPrice) {
        this.itemClosingPrice = itemClosingPrice;
    }

    public Double getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getItemRequestedQuantity() {
        return itemRequestedQuantity;
    }

    public void setItemRequestedQuantity(Double itemRequestedQuantity) {
        this.itemRequestedQuantity = itemRequestedQuantity;
    }

    public String getItemMeasureUnit() {
        return itemMeasureUnit;
    }

    public void setItemMeasureUnit(String itemMeasureUnit) {
        this.itemMeasureUnit = itemMeasureUnit;
    }

    public String getAssignedUserEmail() {
        return assignedUserEmail;
    }

    public void setAssignedUserEmail(String assignedUserEmail) {
        this.assignedUserEmail = assignedUserEmail;
    }
}
