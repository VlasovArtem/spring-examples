package org.avlasov.springexamples.spring5.repository.nosql.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created By artemvlasov on 22/07/2018
 **/
@Configuration
@ComponentScan(basePackages = "org.avlasov.springexamples.spring5.repository.nosql")
@EnableMongoRepositories(basePackages = "org.avlasov.springexamples.spring5.repository.nosql.repository")
public class NoSQLRepositoryConfig {
}
