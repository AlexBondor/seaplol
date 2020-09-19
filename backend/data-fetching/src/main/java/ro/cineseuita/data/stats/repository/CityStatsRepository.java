package ro.cineseuita.data.stats.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.stats.entity.CityStats;

public interface CityStatsRepository extends MongoRepository<CityStats, Long> {

}
