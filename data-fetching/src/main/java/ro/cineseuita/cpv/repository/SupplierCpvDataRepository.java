package ro.cineseuita.cpv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.cpv.entity.SupplierCpvData;

public interface SupplierCpvDataRepository extends MongoRepository<SupplierCpvData, Long> {

}
