package ro.cineseuita.data.stats.entity;

import com.mongodb.client.model.geojson.Point;

public final class CityStatsBuilder {
    private Long id;
    private String name;
    private String county;
    private Long population;
    private Point location;
    private Long totalNumberContracts;
    private Double totalValueContracts;

    public CityStatsBuilder() {
    }

    public static CityStatsBuilder aCityStats() {
        return new CityStatsBuilder();
    }

    public CityStatsBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public CityStatsBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CityStatsBuilder withCounty(String county) {
        this.county = county;
        return this;
    }

    public CityStatsBuilder withPopulation(Long population) {
        this.population = population;
        return this;
    }

    public CityStatsBuilder withLocation(Point location) {
        this.location = location;
        return this;
    }

    public CityStatsBuilder withTotalNumberContracts(Long totalNumberContracts) {
        this.totalNumberContracts = totalNumberContracts;
        return this;
    }

    public CityStatsBuilder withTotalValueContracts(Double totalValueContracts) {
        this.totalValueContracts = totalValueContracts;
        return this;
    }

    public CityStats build() {
        CityStats cityStats = new CityStats();
        cityStats.setId(id);
        cityStats.setName(name);
        cityStats.setCounty(county);
        cityStats.setPopulation(population);
        cityStats.setLocation(location);
        cityStats.setTotalNumberContracts(totalNumberContracts);
        cityStats.setTotalValueContracts(totalValueContracts);
        return cityStats;
    }
}
