package ro.cineseuita.data.cpv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ro.cineseuita.data.cpv.entity.NationalCpvData;

import java.util.List;

public interface NationalCpvDataRepository extends MongoRepository<NationalCpvData, String> {

    @Query(fields = "{contracts : 0}")
    List<NationalCpvData> findByParentId(String parentId);

    @Query(fields = "{contracts : 0}")
    List<NationalCpvData> findAllByIdIn(List<String> ids);

}
