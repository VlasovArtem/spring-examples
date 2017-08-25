package org.avlasov.springexamples.repository.nosql.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created By artemvlasov on 11/08/2017
 **/
@Configuration
@ComponentScan(basePackages = "org.avlasov.springexamples.repository.nosql")
@EnableMongoRepositories(basePackages = "org.avlasov.springexamples.repository.nosql.repository")
public class NoSQLRepositoryConfig {
}
