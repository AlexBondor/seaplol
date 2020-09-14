package ro.cineseuita.contractingauthority.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.contractingauthority.entity.ContractingAuthority;

public interface ContractingAuthorityRepository extends MongoRepository<ContractingAuthority, Long>, ContractingAuthorityCustomRepository {
}
