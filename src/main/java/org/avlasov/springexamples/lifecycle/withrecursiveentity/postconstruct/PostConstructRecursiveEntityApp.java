package org.avlasov.springexamples.lifecycle.withrecursiveentity.postconstruct;

import org.avlasov.springexamples.lifecycle.withrecursiveentity.postconstruct.config.PostConstructRecursiveEntityConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created By artemvlasov on 20/08/2018
 **/
public class PostConstructRecursiveEntityApp {

    public static void main(String[] args) {
        System.out.println("Example lifecycle with Post Construct Recursive autowired entity");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PostConstructRecursiveEntityConfig.class);
        applicationContext.close();
    }

}
