package ro.cineseuita.supplier.api.dto;

public class SupplierListDto {
    private Long id;
    private String name;
    private Long totalContractsValue;
    private Long totalContractsCount;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getTotalContractsValue() {
        return totalContractsValue;
    }

    public void setTotalContractsValue(final Long totalContractsValue) {
        this.totalContractsValue = totalContractsValue;
    }

    public Long getTotalContractsCount() {
        return totalContractsCount;
    }

    public void setTotalContractsCount(final Long totalContractsCount) {
        this.totalContractsCount = totalContractsCount;
    }
}
