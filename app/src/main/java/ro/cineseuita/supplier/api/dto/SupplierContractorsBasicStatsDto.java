package ro.cineseuita.supplier.api.dto;

import org.json.JSONObject;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityMinimalDto;
import ro.cineseuita.shared.BasicStatistics;

import java.util.Map;

public class SupplierContractorsBasicStatsDto {
    public static final int NR_CAS_PER_SUPPLIER_FOR_STATS = 5;

    private Map<ContractingAuthorityMinimalDto, BasicStatistics> stats;

    public Map<ContractingAuthorityMinimalDto, BasicStatistics> getStats() {
        return stats;
    }

    public void setStats(Map<ContractingAuthorityMinimalDto, BasicStatistics> stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return new JSONObject(stats).toString();
    }
}
