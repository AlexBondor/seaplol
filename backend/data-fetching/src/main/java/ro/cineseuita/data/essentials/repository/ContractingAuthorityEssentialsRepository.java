package ro.cineseuita.data.essentials.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.essentials.entity.contractingauthority.ContractingAuthorityEssentials;

public interface ContractingAuthorityEssentialsRepository extends MongoRepository<ContractingAuthorityEssentials, Long> {

}
