package ro.cineseuita.data.stats.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "countyStats")
public class CountyStats {
    private Long id;
    private String name;
    private Long population;
    private Long totalNumberContracts = 0L;
    private Double totalValueContracts = 0.0;
    private Double contractValuePowerPerPopulation;
    private Double contractCountPowerPerPopulation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getTotalNumberContracts() {
        return totalNumberContracts;
    }

    public void setTotalNumberContracts(Long totalNumberContracts) {
        this.totalNumberContracts = totalNumberContracts;
    }

    public Double getTotalValueContracts() {
        return totalValueContracts;
    }

    public void setTotalValueContracts(Double totalValueContracts) {
        this.totalValueContracts = totalValueContracts;
    }

    public Double getContractValuePowerPerPopulation() {
        return contractValuePowerPerPopulation;
    }

    public void setContractValuePowerPerPopulation(Double contractValuePowerPerPopulation) {
        this.contractValuePowerPerPopulation = contractValuePowerPerPopulation;
    }

    public Double getContractCountPowerPerPopulation() {
        return contractCountPowerPerPopulation;
    }

    public void setContractCountPowerPerPopulation(Double contractCountPowerPerPopulation) {
        this.contractCountPowerPerPopulation = contractCountPowerPerPopulation;
    }

    public void incrementNumberContracts(Long count) {
        this.totalNumberContracts += count;
    }

    public void incrementTotalValue(Double sum) {
        this.totalValueContracts += sum;
    }
}
