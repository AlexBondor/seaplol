package ro.cineseuita.essentials.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.essentials.entity.contractingauthority.ContractingAuthorityEssentials;

public interface ContractingAuthorityEssentialsRepository extends MongoRepository<ContractingAuthorityEssentials, Long> {

}
