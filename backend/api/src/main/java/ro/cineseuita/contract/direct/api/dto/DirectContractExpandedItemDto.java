package ro.cineseuita.contract.direct.api.dto;

import ro.cineseuita.data.essentials.directcontract.entity.components.CpvCodeEssentials;
import ro.cineseuita.data.shared.itemMeasurement.ItemMeasurement;

import java.util.List;

public class DirectContractExpandedItemDto {
  private String measurementUnit;
  private ItemMeasurement measurementBucket;
  private List<String> measurementBucketExamples;
  private Double itemAverageCost;
  private Double nationalAverageCost;
  private Double priceDeviationPercentage;
  private Double numberOfItems;
  private Double pricePerItem;
  private String description;
  private CpvCodeEssentials cpvData;

  public String getMeasurementUnit() {
    return measurementUnit;
  }

  public void setMeasurementUnit(String measurementUnit) {
    this.measurementUnit = measurementUnit;
  }

  public ItemMeasurement getMeasurementBucket() {
    return measurementBucket;
  }

  public void setMeasurementBucket(ItemMeasurement measurementBucket) {
    this.measurementBucket = measurementBucket;
  }

  public List<String> getMeasurementBucketExamples() {
    return measurementBucketExamples;
  }

  public void setMeasurementBucketExamples(List<String> measurementBucketExamples) {
    this.measurementBucketExamples = measurementBucketExamples;
  }

  public Double getItemAverageCost() {
    return itemAverageCost;
  }

  public void setItemAverageCost(Double itemAverageCost) {
    this.itemAverageCost = itemAverageCost;
  }

  public Double getNationalAverageCost() {
    return nationalAverageCost;
  }

  public void setNationalAverageCost(Double nationalAverageCost) {
    this.nationalAverageCost = nationalAverageCost;
  }

  public double getPriceDeviationPercentage() {
    return priceDeviationPercentage;
  }

  public void setPriceDeviationPercentage(Double priceDeviation) {
    this.priceDeviationPercentage = priceDeviation;
  }

  public Double getNumberOfItems() {
    return numberOfItems;
  }

  public void setNumberOfItems(Double numberOfItems) {
    this.numberOfItems = numberOfItems;
  }

  public Double getPricePerItem() {
    return pricePerItem;
  }

  public void setPricePerItem(Double pricePerItem) {
    this.pricePerItem = pricePerItem;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CpvCodeEssentials getCpvData() {
    return cpvData;
  }

  public void setCpvData(CpvCodeEssentials cpvData) {
    this.cpvData = cpvData;
  }
}
