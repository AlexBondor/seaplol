package ro.cineseuita.data.supplier.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.contract.shared.entity.ContractsTotalSpendingByType;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionType;

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
