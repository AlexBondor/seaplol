package ro.cineseuita.contractingauthority.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.contractingauthority.entity.ContractingAuthorityTotalSpendingByType;

public interface ContractingAuthorityTotalSpendingByTypeRepository extends MongoRepository<ContractingAuthorityTotalSpendingByType, Long> {
}
