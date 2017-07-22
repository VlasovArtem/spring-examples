package org.avlasov.springexamples.beanqualifying.primary.config;

import org.avlasov.springexamples.beanqualifying.BeanQualifyingConfig;
import org.avlasov.springexamples.beanqualifying.entity.QualifiedEntity;
import org.avlasov.springexamples.beanqualifying.entity.QualifierEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by artemvlasov on 21/07/2017.
 */
@Configuration
@Import(BeanQualifyingConfig.class)
@ComponentScan("org.avlasov.springexamples.beanqualifying.primary.entity")
public class PrimaryAppConfig {

    @Bean
    public QualifierEntity qualifierEntity(QualifiedEntity qualifiedEntity) {
        return new QualifierEntity(qualifiedEntity);
    }

}
