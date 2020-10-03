package ro.cineseuita.contract.direct.api.dto;

import org.joda.time.DateTime;

public class DirectContractListDto {
    private Long id;
    private String name;
    private Double closingValue;
    private Double closingValueSecondCurrency;
    private DateTime finalizationDate;
    private Double corruption;

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

    public Double getClosingValue() {
        return closingValue;
    }

    public void setClosingValue(Double closingValue) {
        this.closingValue = closingValue;
    }

    public Double getClosingValueSecondCurrency() {
        return closingValueSecondCurrency;
    }

    public void setClosingValueSecondCurrency(Double closingValueSecondCurrency) {
        this.closingValueSecondCurrency = closingValueSecondCurrency;
    }

    public DateTime getFinalizationDate() {
        return finalizationDate;
    }

    public void setFinalizationDate(DateTime finalizationDate) {
        this.finalizationDate = finalizationDate;
    }

    public Double getCorruption() {
        return corruption;
    }

    public void setCorruption(Double corruption) {
        this.corruption = corruption;
    }
}
