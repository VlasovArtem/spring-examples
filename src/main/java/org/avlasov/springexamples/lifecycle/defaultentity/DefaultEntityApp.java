package org.avlasov.springexamples.lifecycle.defaultentity;

import org.avlasov.springexamples.lifecycle.defaultentity.config.DefaultEntityConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created By artemvlasov on 20/08/2018
 **/
public class DefaultEntityApp {

    public static void main(String[] args) {
        System.out.println("Example lifecycle with default entity");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DefaultEntityConfig.class);
        applicationContext.close();
    }

}
