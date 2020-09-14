package ro.cineseuita.shared;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class BasicStatisticsCollector {
    public static <T> LinkedHashMap<T, BasicStatistics> collect(Map<T, BasicStatistics> groupedContracts, int limit) {
        return groupedContracts.entrySet().stream()
                .sorted(Map.Entry.<T, BasicStatistics>comparingByValue().reversed())
                .limit(limit).collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new)
                );
    }
}
