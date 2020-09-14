package ro.cineseuita.contract.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ro.cineseuita.contract.entity.direct.DirectAcquisitionContract;

public interface DirectAcquisitionContractRepository extends MongoRepository<DirectAcquisitionContract, Long> {

    @Query("{ 'uniqueIdentificationCode' : ?0 }")
    DirectAcquisitionContract findByUniqueIdentificationCode(String uniqueId);
}
