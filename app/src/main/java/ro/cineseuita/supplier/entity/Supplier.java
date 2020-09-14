package ro.cineseuita.supplier.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "supplierEssentials")
public class Supplier {
    @Id
    private Long _id;
    private String name;
    private String numericFiscalNumber;
    private String fiscalNumber;
    private String address;
    private String phone;
    private String fax;
    private String email;
    private Object url;
    private String city;
    private String county;
    private String country;
    private String postalCode;
    private Object bankAccount;
    private Object bankName;
    private Long totalContractsValue;
    private Long totalContractsCount;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumericFiscalNumber() {
        return numericFiscalNumber;
    }

    public void setNumericFiscalNumber(String numericFiscalNumber) {
        this.numericFiscalNumber = numericFiscalNumber;
    }

    public String getFiscalNumber() {
        return fiscalNumber;
    }

    public void setFiscalNumber(String fiscalNumber) {
        this.fiscalNumber = fiscalNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Object getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Object bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Object getBankName() {
        return bankName;
    }

    public void setBankName(Object bankName) {
        this.bankName = bankName;
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
