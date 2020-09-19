package ro.cineseuita.shared;

public class BasicStatistics implements Comparable<BasicStatistics> {
    private Long count;
    private Double sum;

    public BasicStatistics() {
        count = 0L;
        sum = 0.0;
    }

    public BasicStatistics(Long count, Double sum) {
        this.count = count;
        this.sum = sum;
    }

    public static BasicStatistics add(BasicStatistics stats1, BasicStatistics stats2) {
        return new BasicStatistics(stats1.count + stats2.count, stats1.sum + stats2.sum);
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public int compareTo(BasicStatistics o) {
        return this.getCount().compareTo(o.getCount());
    }
}
