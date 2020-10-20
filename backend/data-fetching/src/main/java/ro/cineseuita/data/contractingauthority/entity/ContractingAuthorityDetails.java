package ro.cineseuita.data.contractingauthority.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.contractingauthority.entity.components.ContractingAuthorityProblem;
import ro.cineseuita.data.contractingauthority.entity.components.DedicatedSupplier;
import ro.cineseuita.data.shared.entityComponents.ParticipantDetails;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "contractingAuthorityDetails")
public class ContractingAuthorityDetails extends ParticipantDetails<ContractingAuthorityProblem> {

    // add any additional fields
}

