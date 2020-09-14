package ro.cineseuita.contractingauthority.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.contractingauthority.entity.ContractingAuthorityDetails;

public interface ContractingAuthorityDetailsRepository extends MongoRepository<ContractingAuthorityDetails, Long> {

}
