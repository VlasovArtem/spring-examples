package org.avlasov.springexamples.beanqualifying.qualifier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.avlasov.springexamples.beanqualifying.entity.QualifierEntity;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by artemvlasov on 20/07/2017.
 */
public class QualifierApp {

    private static final Logger LOGGER = LogManager.getLogger(QualifierApp.class);

    public static void main(String[] args) {
        LOGGER.info("Qualifier Example");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(QualifierEntity.class);
        applicationContext.close();
    }

}
