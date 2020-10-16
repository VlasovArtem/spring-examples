package org.avlasov.springexamples.email.config;

import org.avlasov.springexamples.email.entity.EmailServerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created By artemvlasov on 04/09/2018
 **/
@Configuration
@ComponentScan("org.avlasov.springexamples.email")
public class EmailServerTestConfig {

    @Bean
    public EmailServerConfiguration emailServerConfiguration() {
        return null;
    }



}
