package ro.cineseuita.data.essentials.supplier.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.essentials.directcontract.entity.SupplierForDirectAcquisitionEssentials;

@Document(collection = "supplierEssentials")
public class SupplierEssentials extends SupplierForDirectAcquisitionEssentials {

    private Double totalContractsValue;
    private Double totalContractsValueSecondCurrency;
    private Long totalContractsCount;

    private Long averageNumberOfEmployeesLastYear;
    private Double averageRevenueFromPublicInstitutionsPerEmployeeLastYear;
    private Double averageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency;

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
