package ro.cineseuita.cpv.entity.components;

import ro.cineseuita.contract.entity.direct.components.DirectAcquisitionItem;
import ro.cineseuita.shared.itemMeasurement.ItemMeasurementStats;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CpvData {

    // this class should always be extended in order to add the equivalent for either CAs or Suppliers

    private final List<Long> contracts = new ArrayList<>();
    private String cpvCode;
    private String cpvCodeSimplified;
    private String description;
    private Double total = 0.0;
    private Long numberOfItems = 0L;
    private ItemMeasurementStats itemMeasurementStats = new ItemMeasurementStats();

    private String parentId;
    private List<String> childrenIds;

    public String getCpvCode() {
        return cpvCode;
    }

    public void setCpvCode(String cpvCode) {
        this.cpvCode = cpvCode;
    }

    public String getCpvCodeSimplified() {
        return cpvCodeSimplified;
    }

    public void setCpvCodeSimplified(String cpvCodeSimplified) {
        this.cpvCodeSimplified = cpvCodeSimplified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getContracts() {
        return contracts;
    }

    public Double getAverage() {
        return itemMeasurementStats.getAverage();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Long numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public ItemMeasurementStats getItemMeasurementStats() {
        return itemMeasurementStats;
    }

    public void setItemMeasurementStats(ItemMeasurementStats itemMeasurementStats) {
        this.itemMeasurementStats = itemMeasurementStats;
    }

    public void feedToMeasurementStats(DirectAcquisitionItem item) {
        this.itemMeasurementStats.feed(item);
    }

    public void incrementNumberOfItems(long nrItems) {
        this.numberOfItems += nrItems;
    }

    public void addToContracts(Long contractId) {
        this.contracts.add(contractId);
    }

    public void incrementTotal(Double itemClosingPrice) {
        this.total += itemClosingPrice;
    }

    public void addToContracts(Collection<Long> contractIds) {
        this.contracts.addAll(contractIds);
    }

    public void feed(CpvDataNode childNode) {
        this.total += childNode.getTotal();
        this.numberOfItems += childNode.getNumberOfItems();
        this.itemMeasurementStats.feed(childNode.getItemMeasurementStats());
    }

    public void computeAverage() {
        this.itemMeasurementStats.computeAverage();
    }

    public void fillFormFromCpvDataNode(CpvDataNode dataNode) {
        this.setCpvCode(dataNode.getCpvCode());
        this.setCpvCodeSimplified(dataNode.getCpvCodeSimplified());
        this.setDescription(dataNode.getDescription());
        this.addToContracts(dataNode.getContracts());
        this.setTotal(dataNode.getTotal());
        this.setNumberOfItems(dataNode.getNumberOfItems());
        this.setItemMeasurementStats(dataNode.getItemMeasurementStats());

        this.parentId = dataNode.getParent().getCpvCode();
        this.childrenIds = dataNode.getChildren().stream().map(CpvData::getCpvCode).collect(Collectors.toList());
    }

    public List<String> getChildrenIds() {
        return childrenIds;
    }

    public void setChildrenIds(List<String> childrenIds) {
        this.childrenIds = childrenIds;
    }

    public String getParentId() {
        return parentId;
    }
}
