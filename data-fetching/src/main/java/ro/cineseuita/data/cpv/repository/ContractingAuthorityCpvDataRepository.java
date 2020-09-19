package ro.cineseuita.data.cpv.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.cpv.entity.ContractingAuthorityCpvData;

public interface ContractingAuthorityCpvDataRepository extends MongoRepository<ContractingAuthorityCpvData, Long> {

}
