package ro.cineseuita.supplier.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.supplier.entity.Supplier;

public interface SupplierRepository extends MongoRepository<Supplier, Long>, SupplierCustomRepository {
}
