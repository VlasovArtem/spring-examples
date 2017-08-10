package org.avlasov.springexamples.value.properties.config;

import org.avlasov.springexamples.value.properties.entity.ValuePropertyEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created By artemvlasov on 27/07/2017
 **/
@Configuration
@PropertySource("classpath:org/avlasov/springexamples/value/properties/test.properties")
public class PropertiesConfig {

    @Bean
    public ValuePropertyEntity valuePropertyEntity(@Value("${config}") String propertyConfig) {
        return new ValuePropertyEntity(propertyConfig);
    }

}
