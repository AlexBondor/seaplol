package ro.cineseuita.data.essentials.supplier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;

public interface SupplierEssentialsRepository extends MongoRepository<SupplierEssentials, Long>, SupplierCustomRepository {

}
