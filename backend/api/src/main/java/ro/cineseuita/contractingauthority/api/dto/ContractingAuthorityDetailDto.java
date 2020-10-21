package ro.cineseuita.contractingauthority.api.dto;


import ro.cineseuita.data.contractingauthority.entity.components.DedicatedSupplier;
import ro.cineseuita.shared.ParticipantDetailDto;

import java.util.List;

public class ContractingAuthorityDetailDto extends ParticipantDetailDto {
    private List<DedicatedSupplier> dedicatedSuppliers;

    public List<DedicatedSupplier> getDedicatedSuppliers() {
        return dedicatedSuppliers;
    }

    public void setDedicatedSuppliers(List<DedicatedSupplier> dedicatedSuppliers) {
        this.dedicatedSuppliers = dedicatedSuppliers;
    }
}
