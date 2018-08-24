package org.avlasov.springexamples.aop;

import org.avlasov.springexamples.aop.config.AOPConfig;
import org.avlasov.springexamples.aop.example.SimpleAOP;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;

/**
 * Created By artemvlasov on 23/08/2018
 **/
public class AOPApp {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AOPConfig.class);
        SimpleAOP bean = annotationConfigApplicationContext.getBean(SimpleAOP.class);
        Method privateMinusDouble = bean.getClass().getDeclaredMethod("privateMinusDouble", double.class, double.class);
        privateMinusDouble.setAccessible(true);
        double invoke = (double) privateMinusDouble.invoke(bean, 11.3, 11.4);
    }

}
