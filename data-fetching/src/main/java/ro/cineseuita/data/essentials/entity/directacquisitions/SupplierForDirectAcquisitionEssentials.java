package ro.cineseuita.data.essentials.entity.directacquisitions;

public class SupplierForDirectAcquisitionEssentials {

    private Long _id;
    private String name;
    private String numericFiscalNumber;
    private String address;
    private String phone;
    private String fax;
    private Object url;
    private String city;
    private String county;
    private String postalCode;

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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

}
