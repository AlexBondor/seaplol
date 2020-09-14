package ro.cineseuita.contract.entity.direct;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.contract.entity.direct.components.DirectAcquisitionType;

@Document(collection = "contractsTotalSpendingByType")
public class ContractsTotalSpendingByType {

    @Id
    protected String id;
    private DirectAcquisitionType type;
    private Double total;

    public ContractsTotalSpendingByType(DirectAcquisitionType type) {
        this.type = type;
        this.total = 0d;
        this.id = type.toString();
    }

    public DirectAcquisitionType getType() {
        return type;
    }

    public void setType(DirectAcquisitionType type) {
        this.type = type;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void addToTotal(Double closingValue) {
        this.total += closingValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
