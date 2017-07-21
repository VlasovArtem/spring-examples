package org.avlasov.springexamples.scope.prototype;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.avlasov.springexamples.scope.prototype.config.PrototypeAppConfig;
import org.avlasov.springexamples.scope.prototype.entity.BeanPrototypeEntity;
import org.avlasov.springexamples.scope.utils.BeanUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by artemvlasov on 20/07/2017.
 */
public class PrototypeApp {

    private static final Logger LOGGER = LogManager.getLogger(PrototypeApp.class);

    public static void main(String[] args) {
        LOGGER.info("Prototype Scope Example");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PrototypeAppConfig.class);
        BeanUtils bean = applicationContext.getBean(BeanUtils.class);
        bean.generateBeansInformation(BeanPrototypeEntity.class);
    }


}
