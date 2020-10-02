package ro.cineseuita.data.essentials.contractingauthority.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.essentials.shared.ParticipantEssentials;
import ro.cineseuita.data.shared.entityComponents.Address;

@Document(collection = "contractingAuthorityEssentials")
public class ContractingAuthorityEssentials extends ParticipantEssentials {

}
