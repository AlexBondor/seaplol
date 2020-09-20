package ro.cineseuita.data.cpv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.cpv.entity.NationalCpvData;
import ro.cineseuita.data.cpv.entity.NationalCpvDataSimplified;

import java.util.List;

public interface NationalCpvDataSimplifiedRepository extends MongoRepository<NationalCpvDataSimplified, String> {

    List<NationalCpvData> findAllByCpvCodeIn(List<String> ids);

}
