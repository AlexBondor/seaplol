package ro.cineseuita.cpv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.cpv.entity.ContractingAuthorityCpvData;

public interface ContractingAuthorityCpvDataRepository extends MongoRepository<ContractingAuthorityCpvData, Long> {

}
