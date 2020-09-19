package ro.cineseuita.data.essentials.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.essentials.entity.supplier.SupplierEssentials;

public interface SupplierEssentialsRepository extends MongoRepository<SupplierEssentials, Long> {

}
