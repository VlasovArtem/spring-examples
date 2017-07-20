package org.avlasov.springexamples.scope.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.avlasov.springexamples.scope.entity.ComponentEntityBean;
import org.avlasov.springexamples.scope.singleton.config.SingletonAppConfig;
import org.avlasov.springexamples.scope.singleton.entity.EntityBean;
import org.avlasov.springexamples.utils.BeanUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by artemvlasov on 24/06/2017.
 */
public class SingletonApp {

    private static final Logger LOGGER = LogManager.getLogger(SingletonApp.class);

    public static void main(String[] args) {
        LOGGER.info("Scope Singleton Example");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SingletonAppConfig.class);
        BeanUtils bean = applicationContext.getBean(BeanUtils.class);
        bean.generateBeansInformation(EntityBean.class);
        bean.generateBeansInformation(ComponentEntityBean.class);
        applicationContext.close();
    }

}
