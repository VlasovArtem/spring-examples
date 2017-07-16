package org.avlasov.springexamples.lifecycle;

import org.avlasov.springexamples.lifecycle.config.LifecycleAppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by artemvlasov on 16/07/2017.
 */
public class LifecycleApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifecycleAppConfig.class);
        applicationContext.close();
    }

}
