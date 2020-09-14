package ro.cineseuita.supplier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ro.cineseuita.supplier.entity.Supplier;

import java.util.List;

public interface SupplierRepository extends MongoRepository<Supplier, Long> {

    @Query(value = "{}", fields = "{_id : 1}")
    List<Supplier> findAllByIdsIn(List<Long> ids);

    @Query(value = "{}", fields = "{_id : 1}")
    List<Supplier> findAllJustIds();

}
