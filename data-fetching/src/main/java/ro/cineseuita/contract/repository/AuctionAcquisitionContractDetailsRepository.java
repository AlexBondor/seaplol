package ro.cineseuita.contract.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.contract.entity.auction.detailed.AuctionAcquisitionContractDetails;

public interface AuctionAcquisitionContractDetailsRepository extends MongoRepository<AuctionAcquisitionContractDetails, Long> {

}
