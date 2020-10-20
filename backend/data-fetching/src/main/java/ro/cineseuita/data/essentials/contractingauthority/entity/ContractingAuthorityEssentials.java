package ro.cineseuita.data.essentials.contractingauthority.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.contractingauthority.entity.components.ContractingAuthorityProblem;
import ro.cineseuita.data.contractingauthority.entity.components.DedicatedSupplier;
import ro.cineseuita.data.essentials.shared.ParticipantEssentials;

import java.util.List;

@Document(collection = "contractingAuthorityEssentials")
public class ContractingAuthorityEssentials extends ParticipantEssentials<ContractingAuthorityProblem> {

    private List<DedicatedSupplier> dedicatedSuppliers;

    public void setDedicatedSuppliers(List<DedicatedSupplier> dedicatedSuppliers) {
        this.dedicatedSuppliers = dedicatedSuppliers;
    }

    public List<DedicatedSupplier> getDedicatedSuppliers() {
        return dedicatedSuppliers;
    }
}
