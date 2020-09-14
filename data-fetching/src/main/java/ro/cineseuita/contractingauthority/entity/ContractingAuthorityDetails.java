package ro.cineseuita.contractingauthority.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.shared.entityComponents.ParticipantDetails;

@Document(collection = "contractingAuthorityDetails")
public class ContractingAuthorityDetails extends ParticipantDetails {

    // add any additional fields

}
