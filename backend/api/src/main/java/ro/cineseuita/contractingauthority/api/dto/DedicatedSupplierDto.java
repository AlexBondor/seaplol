package ro.cineseuita.contractingauthority.api.dto;

import java.util.ArrayList;
import java.util.List;

public class DedicatedSupplierDto {
    private String supplierName;
    private List<DedicatedSupplierData> data = new ArrayList<>();

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public List<DedicatedSupplierData> getData() {
        return data;
    }

    public void setData(List<DedicatedSupplierData> data) {
        this.data = data;
    }

    public static class DedicatedSupplierData {
        private String label;
        private Double value;
        private Long count;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }
    }
}
