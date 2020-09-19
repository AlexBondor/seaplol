package ro.cineseuita.contractingauthority.api.dto;

import ro.cineseuita.contractingauthority.entity.Address;

public class ContractingAuthorityDetailDto {
    private Long id;
    private String name;
    private String cui;
    private Address address;
    private String legalRepresentative;
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

    public String getCui() {
        return cui;
    }

    public void setCui(final String cui) {
        this.cui = cui;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(final String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
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
