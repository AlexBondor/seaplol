package ro.cineseuita.contract.direct.api.dto;

import ro.cineseuita.data.shared.itemMeasurement.ItemMeasurement;

import java.util.List;

public class DirectContractExpandedItemDto {
    private String measurementUnit;
    private ItemMeasurement measurementBucket;
    private List<String> measurementBucketExamples;
    private Double itemAverageCost;
    private Double nationalAverageCost;
    private Double priceDeviationPercentage;

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementBucket(ItemMeasurement measurementBucket) {
        this.measurementBucket = measurementBucket;
    }

    public ItemMeasurement getMeasurementBucket() {
        return measurementBucket;
    }

    public void setMeasurementBucketExamples(List<String> measurementBucketExamples) {
        this.measurementBucketExamples = measurementBucketExamples;
    }

    public List<String> getMeasurementBucketExamples() {
        return measurementBucketExamples;
    }

    public void setItemAverageCost(Double itemAverageCost) {
        this.itemAverageCost = itemAverageCost;
    }

    public Double getItemAverageCost() {
        return itemAverageCost;
    }

    public void setNationalAverageCost(Double nationalAverageCost) {
        this.nationalAverageCost = nationalAverageCost;
    }

    public Double getNationalAverageCost() {
        return nationalAverageCost;
    }

    public void setPriceDeviationPercentage(Double priceDeviation) {
        this.priceDeviationPercentage = priceDeviation;
    }

    public double getPriceDeviationPercentage() {
        return priceDeviationPercentage;
    }
}
