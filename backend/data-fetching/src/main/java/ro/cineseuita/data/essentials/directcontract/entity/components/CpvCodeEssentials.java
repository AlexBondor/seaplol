package ro.cineseuita.data.essentials.directcontract.entity.components;

import ro.cineseuita.data.shared.entityComponents.GenericSeapData;

public class CpvCodeEssentials {

    private Long _id;
    private String code;
    private String description;

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static CpvCodeEssentials fromGenericSeapData(GenericSeapData cpvCode) {
        CpvCodeEssentials cpvCodeEssentials = new CpvCodeEssentials();
        cpvCodeEssentials.set_id(cpvCode.getId());
        cpvCodeEssentials.setCode(cpvCode.getLocaleKey());
        cpvCodeEssentials.setDescription(cpvCode.getText());

        return cpvCodeEssentials;
    }
}
