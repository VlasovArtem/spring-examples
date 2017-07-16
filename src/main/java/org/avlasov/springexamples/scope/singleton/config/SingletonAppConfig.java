package org.avlasov.springexamples.scope.singleton.config;

import org.avlasov.springexamples.scope.entity.EntityBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by artemvlasov on 24/06/2017.
 */
@Configuration
@ComponentScan("org.avlasov.springexamples.scope.entity")
public class SingletonAppConfig {

    @Bean
    public EntityBean entityBean() {
        return new EntityBean();
    }

}
