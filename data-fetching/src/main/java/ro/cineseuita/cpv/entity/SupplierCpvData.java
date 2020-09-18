package ro.cineseuita.cpv.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.cpv.entity.components.CpvData;
import ro.cineseuita.cpv.entity.components.CpvDataNode;

@Document(collection = "supplierCpvData")
public class SupplierCpvData extends CpvData {

    @Id
    private String id;

    @Indexed
    private Long supplierId;

    public static SupplierCpvData formSupplierCpvDataFromCpvDataNode(CpvDataNode dataNode, Long supplierId) {
        SupplierCpvData supplierCpvData = new SupplierCpvData();
        supplierCpvData.fillFormFromCpvDataNode(dataNode);
        supplierCpvData.id = dataNode.getCpvCode() + " (" + supplierId + ")";
        supplierCpvData.supplierId = supplierId;
        return supplierCpvData;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
