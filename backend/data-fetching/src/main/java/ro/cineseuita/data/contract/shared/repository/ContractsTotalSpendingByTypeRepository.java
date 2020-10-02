package ro.cineseuita.data.contract.shared.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.contract.shared.entity.ContractsTotalSpendingByType;

public interface ContractsTotalSpendingByTypeRepository extends MongoRepository<ContractsTotalSpendingByType, Long> {
}
