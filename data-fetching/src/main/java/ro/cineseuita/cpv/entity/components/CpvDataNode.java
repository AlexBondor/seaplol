package ro.cineseuita.cpv.entity.components;

import ro.cineseuita.contract.entity.direct.components.DirectAcquisitionItem;
import ro.cineseuita.essentials.entity.DirectAcquisitionContractMinimal;
import ro.cineseuita.shared.itemMeasurement.ItemMeasurementStats;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CpvDataNode {

    private String cpvCode;
    private String cpvCodeSimplified;
    private String description;
    private final List<DirectAcquisitionContractMinimal> contracts = new ArrayList<>();
    private Double average = 0.0;
    private Double total = 0.0;
    private Long numberOfItems = 0L;
    private ItemMeasurementStats itemMeasurementStats = new ItemMeasurementStats();
    private CpvDataNode parent;
    private List<CpvDataNode> children;

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

    public List<DirectAcquisitionContractMinimal> getContracts() {
        return contracts;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
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

    public CpvDataNode getParent() {
        return parent;
    }

    public void setParent(CpvDataNode parent) {
        this.parent = parent;
    }

    public List<CpvDataNode> getChildren() {
        return children;
    }

    public void setChildren(List<CpvDataNode> children) {
        this.children = children;
    }

    public static CpvDataNode fromSimpleNode(CpvSimpleTreeNode simpleNode) {
        CpvDataNode cpvDataNode = new CpvDataNode();
        cpvDataNode.cpvCode = simpleNode.getCode();
        cpvDataNode.cpvCodeSimplified = simpleNode.getCodeSimplified();
        cpvDataNode.description = simpleNode.getDescription();
        cpvDataNode.children = (simpleNode.getChildren() != null) ? simpleNode.getChildren().stream().map(CpvDataNode::fromSimpleNode).collect(toList()) : new ArrayList<>();
        cpvDataNode.children.forEach(child -> child.setParent(cpvDataNode));
        return cpvDataNode;
    }

    public void incrementTotal(Double itemClosingPrice) {
        this.total += itemClosingPrice;
    }

    public void feedToMeasurementStats(DirectAcquisitionItem item) {
        this.itemMeasurementStats.feed(item);
    }

    public void incrementNumberOfItems() {
        this.numberOfItems += 1;
    }

    public void addToContracts(DirectAcquisitionContractMinimal contract) {
        this.contracts.add(contract);
    }

    public boolean hasChildren() {
        return children == null || children.size() == 0;
    }

    public void feedParent() {
        this.parent.feed(this);
    }

    private void feed(CpvDataNode childNode) {
        this.total += childNode.getTotal();
        this.numberOfItems += childNode.getNumberOfItems();
        this.itemMeasurementStats.feed(childNode.getItemMeasurementStats());
    }
}
