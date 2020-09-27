package ro.cineseuita.data.supplier.entity.components;

public class AverageRevenuePerYearAndEmployeeCount {

    private Integer year;
    private Double totalRevenueFromPublicInstitutionsThisYear;
    private Double totalRevenueFromPublicInstitutionsThisYearSecondCurrency;
    private Integer averageNumberOfEmployeesThisYear;
    private Double averageRevenueFromPublicInstitutionsPerEmployeeThisYear;
    private Double averageRevenueFromPublicInstitutionsPerEmployeeThisYearSecondCurrency;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getTotalRevenueFromPublicInstitutionsThisYear() {
        return totalRevenueFromPublicInstitutionsThisYear;
    }

    public void setTotalRevenueFromPublicInstitutionsThisYear(Double totalRevenueFromPublicInstitutionsThisYear) {
        this.totalRevenueFromPublicInstitutionsThisYear = totalRevenueFromPublicInstitutionsThisYear;
    }

    public Integer getAverageNumberOfEmployeesThisYear() {
        return averageNumberOfEmployeesThisYear;
    }

    public void setAverageNumberOfEmployeesThisYear(Integer averageNumberOfEmployeesThisYear) {
        this.averageNumberOfEmployeesThisYear = averageNumberOfEmployeesThisYear;
    }

    public Double getAverageRevenueFromPublicInstitutionsPerEmployeeThisYear() {
        return averageRevenueFromPublicInstitutionsPerEmployeeThisYear;
    }

    public void setAverageRevenueFromPublicInstitutionsPerEmployeeThisYear(Double averageRevenueFromPublicInstitutionsPerEmployeeThisYear) {
        this.averageRevenueFromPublicInstitutionsPerEmployeeThisYear = averageRevenueFromPublicInstitutionsPerEmployeeThisYear;
    }

    public Double getTotalRevenueFromPublicInstitutionsThisYearSecondCurrency() {
        return totalRevenueFromPublicInstitutionsThisYearSecondCurrency;
    }

    public void setTotalRevenueFromPublicInstitutionsThisYearSecondCurrency(Double totalRevenueFromPublicInstitutionsThisYearSecondCurrency) {
        this.totalRevenueFromPublicInstitutionsThisYearSecondCurrency = totalRevenueFromPublicInstitutionsThisYearSecondCurrency;
    }

    public Double getAverageRevenueFromPublicInstitutionsPerEmployeeThisYearSecondCurrency() {
        return averageRevenueFromPublicInstitutionsPerEmployeeThisYearSecondCurrency;
    }

    public void setAverageRevenueFromPublicInstitutionsPerEmployeeThisYearSecondCurrency(Double averageRevenueFromPublicInstitutionsPerEmployeeThisYearSecondCurrency) {
        this.averageRevenueFromPublicInstitutionsPerEmployeeThisYearSecondCurrency = averageRevenueFromPublicInstitutionsPerEmployeeThisYearSecondCurrency;
    }

    public void computeAverage() {
        this.averageRevenueFromPublicInstitutionsPerEmployeeThisYear = totalRevenueFromPublicInstitutionsThisYear / averageNumberOfEmployeesThisYear;
        this.averageRevenueFromPublicInstitutionsPerEmployeeThisYearSecondCurrency = totalRevenueFromPublicInstitutionsThisYearSecondCurrency / averageNumberOfEmployeesThisYear;
    }
}
