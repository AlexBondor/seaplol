package ro.cineseuita.data.contractingauthority.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.shared.entityComponents.ParticipantDetails;

@Document(collection = "contractingAuthorityDetails")
public class ContractingAuthorityDetails extends ParticipantDetails {

    // add any additional fields

}
