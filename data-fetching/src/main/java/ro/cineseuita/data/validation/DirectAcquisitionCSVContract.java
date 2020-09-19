package ro.cineseuita.data.validation;

public class DirectAcquisitionCSVContract {

    private String supplierName; //CASTIGATOR
    private String supplierId; // CASTIGATOR_CUI
    private String supplierCountry; // CASTIGATOR_TARA
    private String supplierCity; //CASTIGATOR_LOCALITATE
    private String supplierAddress; // CASTIGATOR_ADRESA
    private String procedureType; // TIP_PROCEDURA
    private String contractingAuthorityName; // AUTORITATE_CONTRACTANTA
    private String contractingAuthorityId; //AUTORITATE_CONTRACTANTA_CUI
    private String contractId; // NUMAR_ANUNT
    private String contractPublishingDate; // DATA_ANUNT
    private String description; // DESCRIERE
    private String contractClosingType; // TIP_INCHEIERE_CONTRACT
    private String contractNumber; // NUMAR_CONTRACT - same with contractId
    private String contractDate; //DATA_CONTRACT
    private String contractTitle; // TITLU_CONTRACT
    private Double contractValue; // VALOARE
    private String currency; // MONEDA
    private Double contractValueRon; // VALOARE_RON
    private Double contractValueEur; // VALOARE_EUR
    private Double cpvCodeId; // CPV_CODE_ID
    private String cpvCode; // CPV_CODE

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierCountry() {
        return supplierCountry;
    }

    public void setSupplierCountry(String supplierCountry) {
        this.supplierCountry = supplierCountry;
    }

    public String getSupplierCity() {
        return supplierCity;
    }

    public void setSupplierCity(String supplierCity) {
        this.supplierCity = supplierCity;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    public String getContractingAuthorityName() {
        return contractingAuthorityName;
    }

    public void setContractingAuthorityName(String contractingAuthorityName) {
        this.contractingAuthorityName = contractingAuthorityName;
    }

    public String getContractingAuthorityId() {
        return contractingAuthorityId;
    }

    public void setContractingAuthorityId(String contractingAuthorityId) {
        this.contractingAuthorityId = contractingAuthorityId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractPublishingDate() {
        return contractPublishingDate;
    }

    public void setContractPublishingDate(String contractPublishingDate) {
        this.contractPublishingDate = contractPublishingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContractClosingType() {
        return contractClosingType;
    }

    public void setContractClosingType(String contractClosingType) {
        this.contractClosingType = contractClosingType;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractTitle() {
        return contractTitle;
    }

    public void setContractTitle(String contractTitle) {
        this.contractTitle = contractTitle;
    }

    public Double getContractValue() {
        return contractValue;
    }

    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getContractValueRon() {
        return contractValueRon;
    }

    public void setContractValueRon(Double contractValueRon) {
        this.contractValueRon = contractValueRon;
    }

    public Double getContractValueEur() {
        return contractValueEur;
    }

    public void setContractValueEur(Double contractValueEur) {
        this.contractValueEur = contractValueEur;
    }

    public Double getCpvCodeId() {
        return cpvCodeId;
    }

    public void setCpvCodeId(Double cpvCodeId) {
        this.cpvCodeId = cpvCodeId;
    }

    public String getCpvCode() {
        return cpvCode;
    }

    public void setCpvCode(String cpvCode) {
        this.cpvCode = cpvCode;
    }
}
