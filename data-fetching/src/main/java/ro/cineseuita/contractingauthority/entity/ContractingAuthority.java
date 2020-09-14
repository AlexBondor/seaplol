package ro.cineseuita.contractingauthority.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.shared.entityComponents.Participant;

@Document(collection = "contractingAuthority")
public class ContractingAuthority extends Participant {

    // add any additional fields

}
