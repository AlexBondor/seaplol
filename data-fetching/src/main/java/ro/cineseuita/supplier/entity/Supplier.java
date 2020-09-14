package ro.cineseuita.supplier.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.shared.entityComponents.Participant;

@Document(collection = "supplier")
public class Supplier extends Participant {

    // add any additional fields

}
