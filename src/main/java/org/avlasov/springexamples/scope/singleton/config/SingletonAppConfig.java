package org.avlasov.springexamples.scope.singleton.config;

import org.avlasov.springexamples.scope.ScopeConfig;
import org.avlasov.springexamples.scope.singleton.entity.EntityBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by artemvlasov on 24/06/2017.
 */
@Configuration
@Import(ScopeConfig.class)
public class SingletonAppConfig {

    @Bean
    public EntityBean entityBean() {
        return new EntityBean();
    }

}
