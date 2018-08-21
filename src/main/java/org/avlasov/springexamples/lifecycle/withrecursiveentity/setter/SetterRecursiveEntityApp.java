package org.avlasov.springexamples.lifecycle.withrecursiveentity.setter;

import org.avlasov.springexamples.lifecycle.withrecursiveentity.setter.config.SetterRecursiveEntityConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created By artemvlasov on 20/08/2018
 **/
public class SetterRecursiveEntityApp {

    public static void main(String[] args) {
        System.out.println("Example lifecycle with Setter Recursive autowired entity");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SetterRecursiveEntityConfig.class);
        applicationContext.close();
    }

}
