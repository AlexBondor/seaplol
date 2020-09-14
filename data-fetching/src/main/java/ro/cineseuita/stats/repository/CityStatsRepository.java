package ro.cineseuita.stats.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.stats.entity.CityStats;

public interface CityStatsRepository extends MongoRepository<CityStats, Long> {

}
