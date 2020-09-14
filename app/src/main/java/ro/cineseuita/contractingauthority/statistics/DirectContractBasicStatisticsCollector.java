package ro.cineseuita.contractingauthority.statistics;

import ro.cineseuita.contract.direct.entity.DirectContract;
import ro.cineseuita.shared.BasicStatistics;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class DirectContractBasicStatisticsCollector
        implements Collector<DirectContract, BasicStatistics, BasicStatistics> {

    @Override
    public Supplier<BasicStatistics> supplier() {
        return BasicStatistics::new;
    }

    @Override
    public BiConsumer<BasicStatistics, DirectContract> accumulator() {
        return (stats, contract) -> {
            stats.setSum(stats.getSum() + contract.getClosingValue());
            stats.setCount(stats.getCount() + 1L);
        };
    }

    @Override
    public BinaryOperator<BasicStatistics> combiner() {
        return BasicStatistics::add;
    }

    @Override
    public Function<BasicStatistics, BasicStatistics> finisher() {
        return stats -> stats;
    }

    @Override
    public Set<Characteristics> characteristics() {
        Set<Characteristics> set = new HashSet<>();
        set.add(Characteristics.CONCURRENT);
        set.add(Characteristics.UNORDERED);
        return set;
    }
}
