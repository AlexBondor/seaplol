package ro.cineseuita.data.contractingauthority.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthority;

import java.util.List;

public interface ContractingAuthorityDataRepository extends MongoRepository<ContractingAuthority, Long> {

    @Query(value = "{}", fields = "{id : 1}")
    List<ContractingAuthority> findAllByIdsIn(List<Long> ids);

    @Query(value = "{}", fields = "{_id : 1}")
    List<ContractingAuthority> findAllJustIds();
}
