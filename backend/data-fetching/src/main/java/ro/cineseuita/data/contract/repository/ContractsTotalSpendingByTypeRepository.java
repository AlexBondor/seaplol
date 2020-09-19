package ro.cineseuita.data.contract.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.contract.entity.direct.ContractsTotalSpendingByType;

public interface ContractsTotalSpendingByTypeRepository extends MongoRepository<ContractsTotalSpendingByType, Long> {
}
