package ro.cineseuita.cpv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.cpv.entity.NationalCpvData;

import java.util.List;

public interface NationalCpvDataRepository extends MongoRepository<NationalCpvData, Long> {

    List<NationalCpvData> findByParentId(String parentId);

}
