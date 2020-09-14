package ro.cineseuita.contractingauthority.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ro.cineseuita.contractingauthority.entity.ContractingAuthority;

import java.util.List;

public interface ContractingAuthorityRepository extends MongoRepository<ContractingAuthority, Long> {

    @Query(value = "{}", fields = "{id : 1}")
    List<ContractingAuthority> findAllByIdsIn(List<Long> ids);

    @Query(value = "{}", fields = "{_id : 1}")
    List<ContractingAuthority> findAllJustIds();
}
