package org.avlasov.springexamples.lifecycle.withrecursiveentity.lazy;

import org.avlasov.springexamples.lifecycle.withrecursiveentity.lazy.config.LazyRecursiveEntityConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created By artemvlasov on 20/08/2018
 **/
public class LazyRecursiveEntityApp {

    public static void main(String[] args) {
        System.out.println("Example lifecycle with Lazy Recursive autowired entity");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LazyRecursiveEntityConfig.class);
        applicationContext.close();
    }

}
