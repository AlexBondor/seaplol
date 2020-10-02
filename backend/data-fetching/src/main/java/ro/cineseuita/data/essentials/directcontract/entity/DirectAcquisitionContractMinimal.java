package ro.cineseuita.data.essentials.directcontract.entity;

import org.joda.time.DateTime;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionType;

public class DirectAcquisitionContractMinimal {

    private Long _id;
    private String name;
    private Double closingValue;
    private CpvCodeEssentials cpvCode;
    private DateTime finalizationDate;
    private DirectAcquisitionType type;

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

    public Double getClosingValue() {
        return closingValue;
    }

    public void setClosingValue(Double closingValue) {
        this.closingValue = closingValue;
    }

    public CpvCodeEssentials getCpvCode() {
        return cpvCode;
    }

    public void setCpvCode(CpvCodeEssentials cpvCode) {
        this.cpvCode = cpvCode;
    }

    public DateTime getFinalizationDate() {
        return finalizationDate;
    }

    public void setFinalizationDate(DateTime finalizationDate) {
        this.finalizationDate = finalizationDate;
    }

    public DirectAcquisitionType getType() {
        return type;
    }

    public void setType(DirectAcquisitionType type) {
        this.type = type;
    }
}
