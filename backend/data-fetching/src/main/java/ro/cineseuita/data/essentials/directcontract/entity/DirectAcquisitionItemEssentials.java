package ro.cineseuita.data.essentials.directcontract.entity;

public class DirectAcquisitionItemEssentials {

    private Integer _id;
    private String name;
    private String description;
    private Double catalogPrice;
    private Double estimatedPrice;
    private Double closingPrice;
    private Double quantity;
    private Double requestedQuantity;
    private String measureUnit;
    private String assignedUserEmail;
    private Double averageItemPrice;
    private Double deviationFromAverage;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCatalogPrice() {
        return catalogPrice;
    }

    public void setCatalogPrice(Double catalogPrice) {
        this.catalogPrice = catalogPrice;
    }

    public Double getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(Double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public Double getClosingPrice() {
        return closingPrice;
    }

    public void setClosingPrice(Double closingPrice) {
        this.closingPrice = closingPrice;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getRequestedQuantity() {
        return requestedQuantity;
    }

    public void setRequestedQuantity(Double requestedQuantity) {
        this.requestedQuantity = requestedQuantity;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public String getAssignedUserEmail() {
        return assignedUserEmail;
    }

    public void setAssignedUserEmail(String assignedUserEmail) {
        this.assignedUserEmail = assignedUserEmail;
    }

    public void setAverageItemPrice(Double averageItemPrice) {
        this.averageItemPrice = averageItemPrice;
    }

    public Double getDeviationFromAverage() {
        return deviationFromAverage;
    }

    public void setDeviationFromAverage(Double deviationFromAverage) {
        this.deviationFromAverage = deviationFromAverage;
    }

    public void computeDeviationFromAverage() {
        this.deviationFromAverage = this.closingPrice / this.averageItemPrice;
    }
}
