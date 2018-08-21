package org.avlasov.springexamples.lifecycle.configentity;

import org.avlasov.springexamples.lifecycle.configentity.config.ConfigEntityConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created By artemvlasov on 20/08/2018
 **/
public class ConfigEntityApp {

    public static void main(String[] args) {
        System.out.println("Example lifecycle with config entity");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigEntityConfig.class);
        applicationContext.close();
    }

}
