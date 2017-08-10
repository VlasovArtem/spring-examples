package org.avlasov.springexamples.conditionbean.config;

import org.avlasov.springexamples.conditionbean.annotation.TestConditionalAnnotation;
import org.avlasov.springexamples.conditionbean.conditional.BeanFactoryConditionalExample;
import org.avlasov.springexamples.conditionbean.conditional.EnvironmentConditionalExample;
import org.avlasov.springexamples.conditionbean.conditional.MetaDataConditionalExample;
import org.avlasov.springexamples.conditionbean.conditional.SimpleBeanConditionalExample;
import org.avlasov.springexamples.conditionbean.entity.BeanFactoryConditionEntity;
import org.avlasov.springexamples.conditionbean.entity.EnvironmentConditionEntity;
import org.avlasov.springexamples.conditionbean.entity.MetaDataConditionEntity;
import org.avlasov.springexamples.conditionbean.entity.SimpleConditionEntity;
import org.springframework.context.annotation.*;

/**
 * Created By artemvlasov on 22/07/2017
 */
@Configuration
@ComponentScan("org.avlasov.springexamples.conditionbean")
@PropertySource("classpath:/org/avlasov/springexamples/conditionbean/condition.properties")
public class ConditionBeanConfig {

    @Bean
    @Conditional(SimpleBeanConditionalExample.class)
    public SimpleConditionEntity simpleConditionEntity() {
        return new SimpleConditionEntity();
    }

    @Bean
    @Conditional(EnvironmentConditionalExample.class)
    public EnvironmentConditionEntity environmentConditionEntity() {
        return new EnvironmentConditionEntity();
    }

    @Bean
    @Conditional(BeanFactoryConditionalExample.class)
    public BeanFactoryConditionEntity beanFactoryConditionEntity() {
        return new BeanFactoryConditionEntity();
    }

    @Bean
    @TestConditionalAnnotation(show = true)
    @Conditional(MetaDataConditionalExample.class)
    public MetaDataConditionEntity metaDataConditionEntity() {
        return new MetaDataConditionEntity();
    }

}
