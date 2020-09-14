package ro.cineseuita.stats.entity;

public final class CountyStatsBuilder {
    private Long id;
    private String name;
    private Long population;
    private Long totalNumberContracts = 0L;
    private Double totalValueContracts = 0.0;
    private Double contractValuePowerPerPopulation;
    private Double contractCountPowerPerPopulation;

    public CountyStatsBuilder() {
    }

    public static CountyStatsBuilder aCountyStats() {
        return new CountyStatsBuilder();
    }

    public CountyStatsBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CountyStatsBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CountyStatsBuilder withPopulation(Long population) {
        this.population = population;
        return this;
    }

    public CountyStatsBuilder withTotalNumberContracts(Long totalNumberContracts) {
        this.totalNumberContracts = totalNumberContracts;
        return this;
    }

    public CountyStatsBuilder withTotalValueContracts(Double totalValueContracts) {
        this.totalValueContracts = totalValueContracts;
        return this;
    }

    public CountyStatsBuilder withContractValuePowerPerPopulation(Double contractValuePowerPerPopulation) {
        this.contractValuePowerPerPopulation = contractValuePowerPerPopulation;
        return this;
    }

    public CountyStatsBuilder withContractCountPowerPerPopulation(Double contractCountPowerPerPopulation) {
        this.contractCountPowerPerPopulation = contractCountPowerPerPopulation;
        return this;
    }

    public CountyStats build() {
        CountyStats countyStats = new CountyStats();
        countyStats.setId(id);
        countyStats.setName(name);
        countyStats.setPopulation(population);
        countyStats.setTotalNumberContracts(totalNumberContracts);
        countyStats.setTotalValueContracts(totalValueContracts);
        countyStats.setContractValuePowerPerPopulation(contractValuePowerPerPopulation);
        countyStats.setContractCountPowerPerPopulation(contractCountPowerPerPopulation);
        return countyStats;
    }
}
