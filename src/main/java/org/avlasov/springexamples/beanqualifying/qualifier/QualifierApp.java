package org.avlasov.springexamples.beanqualifying.qualifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.avlasov.springexamples.beanqualifying.entity.QualifierEntity;
import org.avlasov.springexamples.beanqualifying.qualifier.config.QualifierAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by artemvlasov on 20/07/2017.
 */
public class QualifierApp {

    private static final Logger LOGGER = LogManager.getLogger(QualifierApp.class);

    public static void main(String[] args) {
        LOGGER.info("Qualifier Example");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(QualifierAppConfig.class);
        QualifierEntity bean = applicationContext.getBean(QualifierEntity.class);
        LOGGER.info("QualifierEntity bean contains qualified bean with type {}", bean.getQualifiedEntity().getClass().getName());
        applicationContext.close();
    }

}
