package ro.cineseuita.essentials.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.essentials.entity.directacquisitions.DirectAcquisitionContractEssentials;

public interface DirectContractEssentialsRepository extends MongoRepository<DirectAcquisitionContractEssentials, Long> {

}
