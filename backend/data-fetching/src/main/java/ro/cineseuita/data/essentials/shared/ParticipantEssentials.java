package ro.cineseuita.data.essentials.shared;

import ro.cineseuita.data.shared.entityComponents.Address;

public class ParticipantEssentials<T extends Enum<T>> extends IndexedCountProblemIndicator<T> {

    private Long _id;
    private String name;
    private String cui;
    private Address address;
    private String legalRepresentative;
    private Double totalContractsValue;
    private Double totalContractsValueSecondCurrency;
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
}
