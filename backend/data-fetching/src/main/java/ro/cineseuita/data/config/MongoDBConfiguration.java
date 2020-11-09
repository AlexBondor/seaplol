package ro.cineseuita.data.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "ro.cineseuita.data")
public class MongoDBConfiguration extends AbstractMongoClientConfiguration {

  @Value("${spring.data.mongodb.uri}")
  private String mongodbUri;
  @Value("${spring.data.mongodb.database}")
  private String mongodbDatabase;

  @Override
  public MongoClient mongoClient() {
    return MongoClients.create(mongodbUri);
  }

  @Override
  protected String getDatabaseName() {
    return mongodbDatabase;
  }
}
