package ro.cineseuita.data.cpv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.cpv.entity.SupplierCpvData;

public interface SupplierCpvDataRepository extends MongoRepository<SupplierCpvData, Long> {

}
