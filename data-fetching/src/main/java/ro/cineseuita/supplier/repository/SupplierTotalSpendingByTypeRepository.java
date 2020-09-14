package ro.cineseuita.supplier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.supplier.entity.SupplierTotalSpendingByType;

public interface SupplierTotalSpendingByTypeRepository extends MongoRepository<SupplierTotalSpendingByType, Long> {
}
