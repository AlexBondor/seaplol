package ro.cineseuita.contractingauthority.api.dto;

import org.json.JSONObject;
import ro.cineseuita.shared.BasicStatistics;
import ro.cineseuita.shared.CpvCode;

import java.util.Map;

public class ContractingAuthorityCpvBasicStatsDto {
    public static final int NR_CPV_PER_CA_FOR_STATS = 5;
    private Map<CpvCode, BasicStatistics> stats;

    public Map<CpvCode, BasicStatistics> getStats() {
        return stats;
    }

    public void setStats(Map<CpvCode, BasicStatistics> stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return new JSONObject(stats).toString();
    }
}
