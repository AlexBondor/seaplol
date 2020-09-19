package ro.cineseuita.data.essentials.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.essentials.entity.directacquisitions.DirectAcquisitionContractEssentials;

public interface DirectContractEssentialsRepository extends MongoRepository<DirectAcquisitionContractEssentials, Long> {

}
