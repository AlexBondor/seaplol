package ro.cineseuita.data.essentials.directcontract.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractEssentials;

public interface DirectContractEssentialsRepository extends MongoRepository<DirectAcquisitionContractEssentials, Long>, DirectAcquisitionContractEssentialsCustomRepository {

}
