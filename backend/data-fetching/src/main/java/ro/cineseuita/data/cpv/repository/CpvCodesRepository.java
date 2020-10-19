package ro.cineseuita.data.cpv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.cpv.entity.CpvCode;

public interface CpvCodesRepository extends MongoRepository<CpvCode, String> {
}
