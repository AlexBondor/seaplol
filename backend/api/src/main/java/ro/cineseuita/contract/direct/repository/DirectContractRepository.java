package ro.cineseuita.contract.direct.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.contract.direct.entity.DirectContract;

import java.util.List;

public interface DirectContractRepository extends MongoRepository<DirectContract, Long> {


    List<DirectContract> findAllBySupplier__id(Long id);

    List<DirectContract> findAllByContractingAuthority__id(Long caId);
}
