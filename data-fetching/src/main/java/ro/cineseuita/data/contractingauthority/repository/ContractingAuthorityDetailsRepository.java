package ro.cineseuita.data.contractingauthority.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityDetails;

public interface ContractingAuthorityDetailsRepository extends MongoRepository<ContractingAuthorityDetails, Long> {

}
