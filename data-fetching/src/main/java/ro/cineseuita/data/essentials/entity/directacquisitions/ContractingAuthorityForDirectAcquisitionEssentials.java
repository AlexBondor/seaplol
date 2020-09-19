package ro.cineseuita.data.essentials.entity.directacquisitions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ro.cineseuita.data.shared.entityComponents.Address;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContractingAuthorityForDirectAcquisitionEssentials {

    @JsonIgnore
    private Long _id;
    private String name;
    private String cui;
    private Address address;
    private String legalRepresentative;

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

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
