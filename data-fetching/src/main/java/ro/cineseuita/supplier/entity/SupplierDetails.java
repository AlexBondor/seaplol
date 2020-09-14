package ro.cineseuita.supplier.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.shared.entityComponents.ParticipantDetails;

@Document(collection = "supplierDetails")
public class SupplierDetails extends ParticipantDetails {

    // add any additional fields

}
