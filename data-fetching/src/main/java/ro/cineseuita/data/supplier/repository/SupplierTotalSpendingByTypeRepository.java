package ro.cineseuita.data.supplier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.supplier.entity.SupplierTotalSpendingByType;

public interface SupplierTotalSpendingByTypeRepository extends MongoRepository<SupplierTotalSpendingByType, Long> {
}
