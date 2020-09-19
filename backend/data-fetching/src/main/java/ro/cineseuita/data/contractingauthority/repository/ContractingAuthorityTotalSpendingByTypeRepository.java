package ro.cineseuita.data.contractingauthority.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityTotalSpendingByType;

public interface ContractingAuthorityTotalSpendingByTypeRepository extends MongoRepository<ContractingAuthorityTotalSpendingByType, Long> {
}
