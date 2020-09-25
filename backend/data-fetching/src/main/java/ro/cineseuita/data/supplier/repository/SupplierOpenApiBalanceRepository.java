package ro.cineseuita.data.supplier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.supplier.entity.SupplierOpenApiBalance;

public interface SupplierOpenApiBalanceRepository extends MongoRepository<SupplierOpenApiBalance, String> {

}
