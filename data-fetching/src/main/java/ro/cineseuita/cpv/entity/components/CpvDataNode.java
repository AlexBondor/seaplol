package ro.cineseuita.cpv.entity.components;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.contract.entity.direct.components.DirectAcquisitionItem;
import ro.cineseuita.shared.itemMeasurement.ItemMeasurementStats;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Document(collection = "nationalCpvData")
public class CpvDataNode {
    // this class should always be extended in order to add the equivalent for either CAs or Suppliers

    @Id
    private String cpvCode;
    private String cpvCodeSimplified;
    private String description;
    private final List<Long> contracts = new ArrayList<>();
    private Double total = 0.0;
    private Long numberOfItems = 0L;
    private ItemMeasurementStats itemMeasurementStats = new ItemMeasurementStats();
    @DBRef(lazy = true)
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

    public void incrementNumberOfItems(long nrItems) {
        this.numberOfItems += nrItems;
    }

    public void addToContracts(Long contractId) {
        this.contracts.add(contractId);
    }

    public boolean hasChildren() {
        return children != null && children.size() > 0;
    }

    public void addToContracts(Collection<Long> contractIds) {
        this.contracts.addAll(contractIds);
    }

    public void feedParent() {
        this.parent.feed(this);
    }

    private void feed(CpvDataNode childNode) {
        this.total += childNode.getTotal();
        this.numberOfItems += childNode.getNumberOfItems();
        this.itemMeasurementStats.feed(childNode.getItemMeasurementStats());
    }

    public void computeAverage() {
        this.itemMeasurementStats.computeAverage();
    }
}
