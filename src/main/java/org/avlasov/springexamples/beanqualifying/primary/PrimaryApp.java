package org.avlasov.springexamples.beanqualifying.primary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.avlasov.springexamples.beanqualifying.entity.QualifierEntity;
import org.avlasov.springexamples.beanqualifying.primary.config.PrimaryAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by artemvlasov on 22/07/2017.
 */
public class PrimaryApp {

    private static final Logger LOGGER = LogManager.getLogger(PrimaryApp.class);

    public static void main(String[] args) {
        LOGGER.info("Primary Annotation Example");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PrimaryAppConfig.class);
        QualifierEntity bean = applicationContext.getBean(QualifierEntity.class);
        LOGGER.info("QualifierEntity bean contains qualified bean with type {}", bean.getQualifiedEntity().getClass().getName());
        applicationContext.close();
    }

}
