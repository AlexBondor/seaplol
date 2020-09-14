package ro.cineseuita.supplier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.supplier.entity.SupplierDetails;

public interface SupplierDetailsRepository extends MongoRepository<SupplierDetails, Long> {

}
