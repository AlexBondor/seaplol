package ro.cineseuita.data.supplier.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.shared.entityComponents.ParticipantDetails;
import ro.cineseuita.data.supplier.entity.components.AverageRevenuePerYearAndEmployeeCount;
import ro.cineseuita.data.supplier.entity.components.SupplierProblem;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "supplierDetails")
public class SupplierDetails extends ParticipantDetails<SupplierProblem> {

    // add any additional fields
    private Map<Integer, AverageRevenuePerYearAndEmployeeCount> averageRevenuePerYearAndEmployeeCountMap = new HashMap<>();
    private AverageRevenuePerYearAndEmployeeCount latestYearAverageRevenuePerEmployeeCount;

    public void addAverageRevenuePerYearAndEmployeeCount(Integer year, AverageRevenuePerYearAndEmployeeCount data) {
        averageRevenuePerYearAndEmployeeCountMap.put(year, data);
    }

    public AverageRevenuePerYearAndEmployeeCount getLatestYearAverageRevenuePerEmployeeCount() {
        return latestYearAverageRevenuePerEmployeeCount;
    }

    public void setLatestYearAverageRevenuePerEmployeeCount(AverageRevenuePerYearAndEmployeeCount latestYearAverageRevenuePerEmployeeCount) {
        this.latestYearAverageRevenuePerEmployeeCount = latestYearAverageRevenuePerEmployeeCount;
    }

    public Map<Integer, AverageRevenuePerYearAndEmployeeCount> getAverageRevenuePerYearAndEmployeeCountMap() {
        return averageRevenuePerYearAndEmployeeCountMap;
    }
}
