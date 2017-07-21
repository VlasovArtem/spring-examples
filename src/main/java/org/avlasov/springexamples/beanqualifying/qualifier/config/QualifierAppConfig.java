package org.avlasov.springexamples.beanqualifying.qualifier.config;

import org.avlasov.springexamples.beanqualifying.BeanQualifyingConfig;
import org.avlasov.springexamples.beanqualifying.entity.QualifiedEntity;
import org.avlasov.springexamples.beanqualifying.entity.QualifierEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by artemvlasov on 20/07/2017.
 */
@Configuration
@Import(BeanQualifyingConfig.class)
public class QualifierAppConfig {

    @Bean
    public QualifierEntity qualifierEntity(@Qualifier("secondBean") QualifiedEntity qualifiedEntity) {
        return new QualifierEntity(qualifiedEntity);
    }


}
