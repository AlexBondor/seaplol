package ro.cineseuita.essentials.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.essentials.entity.supplier.SupplierEssentials;

public interface SupplierEssentialsRepository extends MongoRepository<SupplierEssentials, Long> {

}
