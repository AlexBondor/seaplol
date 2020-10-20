package ro.cineseuita.contract.direct.api.dto;

import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionProblem;
import ro.cineseuita.data.essentials.directcontract.entity.components.ParticipantMinimal;
import ro.cineseuita.data.shared.entityComponents.ProblemIndicators;

public class DirectContractListDto extends ProblemIndicators<DirectAcquisitionProblem> {
    private Long id;
    private String name;
    private Double closingValue;
    private Double closingValueSecondCurrency;
    private String finalizationDate;
    private ParticipantMinimal contractingAuthority;
    private ParticipantMinimal supplier;

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

    public String getFinalizationDate() {
        return finalizationDate;
    }

    public void setFinalizationDate(String finalizationDate) {
        this.finalizationDate = finalizationDate;
    }

    public ParticipantMinimal getContractingAuthority() {
        return contractingAuthority;
    }

    public void setContractingAuthority(ParticipantMinimal contractingAuthority) {
        this.contractingAuthority = contractingAuthority;
    }

    public ParticipantMinimal getSupplier() {
        return supplier;
    }

    public void setSupplier(ParticipantMinimal supplier) {
        this.supplier = supplier;
    }

}
