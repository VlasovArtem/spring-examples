package org.avlasov.springexamples.repository.nosql;

import org.avlasov.springexamples.repository.nosql.config.NoSQLRepositoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created By artemvlasov on 11/08/2017
 **/
@SpringBootConfiguration
@EnableAutoConfiguration
public class NoSQLApp {

    public static void main(String[] args) {
        SpringApplication.run(NoSQLRepositoryConfig.class);
    }

}
