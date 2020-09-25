package ro.cineseuita.data.supplier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.supplier.entity.SupplierOpenApiDetails;

public interface SupplierOpenApiDetailsRepository extends MongoRepository<SupplierOpenApiDetails, String> {

}
