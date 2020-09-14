package ro.cineseuita.contract.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.contract.entity.direct.ContractsTotalSpendingByType;

public interface ContractsTotalSpendingByTypeRepository extends MongoRepository<ContractsTotalSpendingByType, Long> {
}
