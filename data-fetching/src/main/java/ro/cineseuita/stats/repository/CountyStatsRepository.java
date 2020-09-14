package ro.cineseuita.stats.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.stats.entity.CountyStats;

public interface CountyStatsRepository extends MongoRepository<CountyStats, Long> {

}
