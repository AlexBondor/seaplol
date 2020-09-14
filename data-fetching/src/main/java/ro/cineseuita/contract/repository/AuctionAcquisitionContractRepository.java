package ro.cineseuita.contract.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.contract.entity.auction.AuctionAcquisitionContract;

public interface AuctionAcquisitionContractRepository extends MongoRepository<AuctionAcquisitionContract, Long> {

}
