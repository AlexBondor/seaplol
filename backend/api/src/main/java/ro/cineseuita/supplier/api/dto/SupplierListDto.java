package ro.cineseuita.supplier.api.dto;

public class SupplierListDto {
    private Long id;
    private String name;
    private Double totalContractsValue;
    private Double totalContractsValueSecondCurrency;
    private Long totalContractsCount;
    private Long averageNumberOfEmployeesLastYear;
    private Double averageRevenueFromPublicInstitutionsPerEmployeeLastYear;
    private Double averageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency;

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

    public Double getTotalContractsValue() {
        return totalContractsValue;
    }

    public void setTotalContractsValue(final Double totalContractsValue) {
        this.totalContractsValue = totalContractsValue;
    }

    public Double getTotalContractsValueSecondCurrency() {
        return totalContractsValueSecondCurrency;
    }

    public void setTotalContractsValueSecondCurrency(Double totalContractsValueSecondCurrency) {
        this.totalContractsValueSecondCurrency = totalContractsValueSecondCurrency;
    }

    public Long getTotalContractsCount() {
        return totalContractsCount;
    }

    public void setTotalContractsCount(final Long totalContractsCount) {
        this.totalContractsCount = totalContractsCount;
    }

    public Long getAverageNumberOfEmployeesLastYear() {
        return averageNumberOfEmployeesLastYear;
    }

    public void setAverageNumberOfEmployeesLastYear(Long averageNumberOfEmployeesLastYear) {
        this.averageNumberOfEmployeesLastYear = averageNumberOfEmployeesLastYear;
    }

    public Double getAverageRevenueFromPublicInstitutionsPerEmployeeLastYear() {
        return averageRevenueFromPublicInstitutionsPerEmployeeLastYear;
    }

    public void setAverageRevenueFromPublicInstitutionsPerEmployeeLastYear(Double averageRevenueFromPublicInstitutionsPerEmployeeLastYear) {
        this.averageRevenueFromPublicInstitutionsPerEmployeeLastYear = averageRevenueFromPublicInstitutionsPerEmployeeLastYear;
    }

    public Double getAverageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency() {
        return averageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency;
    }

    public void setAverageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency(Double averageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency) {
        this.averageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency = averageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency;
    }
}
