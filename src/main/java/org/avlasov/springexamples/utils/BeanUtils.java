package org.avlasov.springexamples.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.avlasov.springexamples.scope.entity.MainEntityBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by artemvlasov on 20/07/2017.
 */
@Component
public class BeanUtils {

    //Bad practice, do not add ApplicationContext into beand
    private final ApplicationContext applicationContext;
    private static final Logger LOGGER = LogManager.getLogger(BeanUtils.class);

    @Autowired
    public BeanUtils(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void generateBeansInformation(Class<? extends MainEntityBean> clazz) {
        LOGGER.info("Validate {}", clazz.getName());
        MainEntityBean bean1 = applicationContext.getBean(clazz);
        LOGGER.info("First bean name {}", bean1.getName());
        MainEntityBean bean2 = applicationContext.getBean(clazz);
        LOGGER.info("Second bean name {}", bean2.getName());
        LOGGER.info("First bean and second bean are equals = {}", bean1.equals(bean2));
    }

}
