package org.avlasov.springexamples.repository.sql;

import org.avlasov.springexamples.repository.sql.config.SQLRepositoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created By artemvlasov on 11/08/2017
 **/
@SpringBootConfiguration
@EnableAutoConfiguration
public class SQLApp {

    public static void main(String[] args) {
        SpringApplication.run(SQLRepositoryConfig.class);
    }

}
