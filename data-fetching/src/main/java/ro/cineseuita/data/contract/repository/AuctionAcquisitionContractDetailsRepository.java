package ro.cineseuita.data.contract.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.contract.entity.auction.detailed.AuctionAcquisitionContractDetails;

public interface AuctionAcquisitionContractDetailsRepository extends MongoRepository<AuctionAcquisitionContractDetails, Long> {

}
