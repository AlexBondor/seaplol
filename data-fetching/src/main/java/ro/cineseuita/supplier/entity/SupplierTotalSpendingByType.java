package ro.cineseuita.supplier.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.contract.entity.direct.ContractsTotalSpendingByType;
import ro.cineseuita.contract.entity.direct.components.DirectAcquisitionType;

@Document(collection = "supplierTotalSpendingByType")
public class SupplierTotalSpendingByType extends ContractsTotalSpendingByType {

    private Long supplierId;

    public SupplierTotalSpendingByType(DirectAcquisitionType type, Long supplierId) {
        super(type);
        this.supplierId = supplierId;
        this.id = supplierId + " - " + type.toString();
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }


}
