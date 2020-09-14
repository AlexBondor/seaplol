package ro.cineseuita.cpv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.cpv.entity.components.CpvDataNode;

public interface NationalCpvDataRepository extends MongoRepository<CpvDataNode, Long> {

}
