package ro.cineseuita.data.supplier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.supplier.entity.SupplierDetails;

public interface SupplierDetailsRepository extends MongoRepository<SupplierDetails, Long> {

}
