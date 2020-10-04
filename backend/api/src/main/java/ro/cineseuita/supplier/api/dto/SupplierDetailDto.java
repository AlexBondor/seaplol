package ro.cineseuita.supplier.api.dto;

import ro.cineseuita.shared.ParticipantDetailDto;

public class SupplierDetailDto extends ParticipantDetailDto {

    private Long averageNumberOfEmployeesLastYear;
    private Double averageRevenueFromPublicInstitutionsPerEmployeeLastYear;
    private Double averageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency;

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
