package ro.cineseuita.supplier.api.dto;

import ro.cineseuita.data.essentials.contractingauthority.entity.Address;

public class SupplierDetailDto {

    private Long id;
    private String name;
    private String cui;
    private Address address;
    private String legalRepresentative;
    private Double totalContractsValue;
    private Double totalContractsValueSecondCurrency;
    private Long totalContractsCount;
    private Long averageNumberOfEmployeesLastYear;
    private Double averageRevenueFromPublicInstitutionsPerEmployeeLastYear;
    private Double averageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency;

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

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public Double getTotalContractsValue() {
        return totalContractsValue;
    }

    public void setTotalContractsValue(Double totalContractsValue) {
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

    public void setTotalContractsCount(Long totalContractsCount) {
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
