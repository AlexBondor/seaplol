package ro.cineseuita.data.contract.auction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.contract.auction.entity.detailed.AuctionAcquisitionContractDetails;

public interface AuctionAcquisitionContractDetailsRepository extends MongoRepository<AuctionAcquisitionContractDetails, Long> {

}
