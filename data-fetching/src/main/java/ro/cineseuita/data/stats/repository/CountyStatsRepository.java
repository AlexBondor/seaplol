package ro.cineseuita.data.stats.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ro.cineseuita.data.stats.entity.CountyStats;

public interface CountyStatsRepository extends MongoRepository<CountyStats, Long> {

}
