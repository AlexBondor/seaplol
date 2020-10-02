package ro.cineseuita.data.essentials.contractingauthority.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;

public interface ContractingAuthorityEssentialsRepository extends MongoRepository<ContractingAuthorityEssentials, Long>, ContractingAuthorityCustomRepository {

}
