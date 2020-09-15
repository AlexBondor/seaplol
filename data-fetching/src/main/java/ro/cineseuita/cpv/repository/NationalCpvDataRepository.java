package ro.cineseuita.cpv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.cpv.entity.NationalCpvData;

public interface NationalCpvDataRepository extends MongoRepository<NationalCpvData, Long> {

}
