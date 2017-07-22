package org.avlasov.springexamples.beanqualifying.multiplequalifiers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.avlasov.springexamples.beanqualifying.multiplequalifiers.config.MultipleQualifiersConfig;
import org.avlasov.springexamples.beanqualifying.multiplequalifiers.entity.ChristopherNolanNewFilm;
import org.avlasov.springexamples.beanqualifying.multiplequalifiers.entity.SethRogenNewFilm;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MultipleQualifiersApp {

    private static final Logger LOGGER = LogManager.getLogger(MultipleQualifiersApp.class);

    public static void main(String[] args) {
        LOGGER.info("Multiple Qualifier Example");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MultipleQualifiersConfig.class);
        ChristopherNolanNewFilm christopherNolanNewFilm = applicationContext.getBean(ChristopherNolanNewFilm.class);
        SethRogenNewFilm sethRogenNewFilm = applicationContext.getBean(SethRogenNewFilm.class);
        LOGGER.info("Christopher Nolan New Film new actor is {}", christopherNolanNewFilm.getActor().getClass().getSimpleName());
        LOGGER.info("Seth Rogen New Film new actor is {}", sethRogenNewFilm.getActor().getClass().getSimpleName());
        applicationContext.close();
    }

}
