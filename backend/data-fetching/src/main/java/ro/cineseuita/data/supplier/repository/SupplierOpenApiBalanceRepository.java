package ro.cineseuita.data.supplier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.supplier.entity.SupplierOpenApiBalance;

import java.util.List;

public interface SupplierOpenApiBalanceRepository extends MongoRepository<SupplierOpenApiBalance, String> {

    List<SupplierOpenApiBalance> findAllByCif(String cif);
}
