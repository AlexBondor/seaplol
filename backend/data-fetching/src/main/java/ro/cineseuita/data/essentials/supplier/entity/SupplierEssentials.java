package ro.cineseuita.data.essentials.supplier.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractMinimal;
import ro.cineseuita.data.essentials.directcontract.entity.SupplierForDirectAcquisitionEssentials;

import java.util.List;

@Document(collection = "supplierEssentials")
public class SupplierEssentials extends SupplierForDirectAcquisitionEssentials {

    private Double totalContractsValue;
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
