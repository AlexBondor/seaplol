package ro.cineseuita.data.contractingauthority.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityWith5kMarginContracts;


public interface ContractingAuthorityWith5kMarginContractsRepository extends MongoRepository<ContractingAuthorityWith5kMarginContracts, Long> {
}
