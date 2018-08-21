package org.avlasov.springexamples.lifecycle.withautowiredentity;

import org.avlasov.springexamples.lifecycle.withautowiredentity.config.WithAutowiredEntityConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created By artemvlasov on 20/08/2018
 **/
public class WithAutowiredEntityApp {

    public static void main(String[] args) {
        System.out.println("Example lifecycle with autowired entity");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(WithAutowiredEntityConfig.class);
        applicationContext.close();
    }

}
