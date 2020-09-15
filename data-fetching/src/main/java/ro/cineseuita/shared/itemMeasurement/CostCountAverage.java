package ro.cineseuita.shared.itemMeasurement;

public class CostCountAverage {

    private Long count = 0L;
    private Double cost = 0.0;
    private Double average = 0.0;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void incrementCount(Long count) {
        this.count += count;
    }

    public void incrementCost(Double cost) {
        this.cost += cost;
    }

    public void add(CostCountAverage other) {
        this.cost += other.getCost();
        this.count += other.getCount();
    }

    public Double getAverage() {
        return average;
    }

    public void computeAverage() {
        this.average = this.cost / this.count;
    }
}
