package ro.cineseuita.data.contractingauthority.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.contractingauthority.entity.components.ContractingAuthorityProblem;
import ro.cineseuita.data.shared.entityComponents.ParticipantDetails;
import ro.cineseuita.data.shared.entityComponents.ProblemIndicators;

@Document(collection = "contractingAuthorityDetails")
public class ContractingAuthorityDetails extends ParticipantDetails<ContractingAuthorityProblem> {

    // add any additional fields

}
