package org.avlasov.springexamples.scope.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.avlasov.springexamples.scope.entity.ComponentEntityBean;
import org.avlasov.springexamples.scope.entity.EntityBean;
import org.avlasov.springexamples.scope.entity.MainEntityBean;
import org.avlasov.springexamples.scope.singleton.config.SingletonAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by artemvlasov on 24/06/2017.
 */
public class SingletonApp {

    private static final Logger LOGGER = LogManager.getLogger(SingletonApp.class);
    private static AnnotationConfigApplicationContext applicationContext;

    public static void main(String[] args) {
        LOGGER.info("Scope Singleton Example");
        applicationContext = new AnnotationConfigApplicationContext(SingletonAppConfig.class);
        generateBeansInformation(EntityBean.class);
        generateBeansInformation(ComponentEntityBean.class);
        applicationContext.close();
    }

    private static void generateBeansInformation(Class<? extends MainEntityBean> clazz) {
        LOGGER.info("Validate {}", clazz.getName());
        MainEntityBean bean1 = applicationContext.getBean(clazz);
        LOGGER.info("First bean name {}", bean1.getName());
        MainEntityBean bean2 = applicationContext.getBean(clazz);
        LOGGER.info("Second bean name {}", bean2.getName());
        LOGGER.info("First bean and second bean are equals = {}", bean1.equals(bean2));
    }

}
