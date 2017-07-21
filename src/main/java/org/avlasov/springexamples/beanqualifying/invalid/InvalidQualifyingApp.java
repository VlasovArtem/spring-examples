package org.avlasov.springexamples.beanqualifying.invalid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.avlasov.springexamples.beanqualifying.invalid.config.InvalidQualifyingConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by artemvlasov on 21/07/2017.
 */
public class InvalidQualifyingApp {

    private static final Logger LOGGER = LogManager.getLogger(InvalidQualifyingApp.class);

    public static void main(String[] args) {
        LOGGER.info("Invalid Qualifying Example");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(InvalidQualifyingConfig.class);
    }

}
