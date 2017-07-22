package org.avlasov.springexamples.conditionbean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.avlasov.springexamples.conditionbean.config.ConditionBeanConfig;
import org.avlasov.springexamples.conditionbean.entity.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Objects;

/**
 * Created By artemvlasov on 22/07/2017
 **/
public class ConditionBeanApp {

    private static final Logger LOGGER = LogManager.getLogger(ConditionBeanApp.class);

    public static void main(String[] args) {
        LOGGER.info("Condition Bean Example");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionBeanConfig.class);
        SimpleConditionEntity simpleConditionEntity = applicationContext.getBean(SimpleConditionEntity.class);
        assert Objects.nonNull(simpleConditionEntity);
        LOGGER.info("Simple Condition Entity with condition equals to true. Bean is exists.");
        EnvironmentConditionEntity environmentConditionEntity = applicationContext.getBean(EnvironmentConditionEntity.class);
        assert Objects.isNull(environmentConditionEntity);
        LOGGER.info("Environment Conditional Example with condition based on value in properties file data. Bean is not exists.");
        BeanFactoryConditionEntity beanFactoryConditionEntity = applicationContext.getBean(BeanFactoryConditionEntity.class);
        assert Objects.nonNull(beanFactoryConditionEntity);
        LOGGER.info("Bean Factory Condition with validation if another bean is exists. Bean is exists.");
        MetaDataConditionEntity metaDataConditionEntity = applicationContext.getBean(MetaDataConditionEntity.class);
        assert Objects.nonNull(metaDataConditionEntity);
        LOGGER.info("Meta Data condition with validation component contains annotation with required attribute value. Bean is exists.");
        assert !applicationContext.containsBean(ComponentConditionalEntity.class.getName());
        LOGGER.info("Component Entity Meta Data condition with validation component contains annotation with required attribute value. Bean is not exists.");
        applicationContext.close();
    }

}
