package ro.cineseuita.data.contract.auction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.contract.auction.entity.AuctionAcquisitionContract;

public interface AuctionAcquisitionContractRepository extends MongoRepository<AuctionAcquisitionContract, Long> {

}
