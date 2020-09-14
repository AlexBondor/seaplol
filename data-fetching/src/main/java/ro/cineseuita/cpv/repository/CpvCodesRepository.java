package ro.cineseuita.cpv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.cpv.entity.CpvCode;

public interface CpvCodesRepository extends MongoRepository<CpvCode, Long> {
}
