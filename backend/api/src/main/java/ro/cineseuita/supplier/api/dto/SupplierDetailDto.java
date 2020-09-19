package ro.cineseuita.supplier.api.dto;

public class SupplierDetailDto {
    private Long id;
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

    public String getNumericFiscalNumber() {
        return numericFiscalNumber;
    }

    public void setNumericFiscalNumber(final String numericFiscalNumber) {
        this.numericFiscalNumber = numericFiscalNumber;
    }

    public String getFiscalNumber() {
        return fiscalNumber;
    }

    public void setFiscalNumber(final String fiscalNumber) {
        this.fiscalNumber = fiscalNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(final String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(final Object url) {
        this.url = url;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(final String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
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
