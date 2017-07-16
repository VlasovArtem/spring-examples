package org.avlasov.springexamples.lifecycle.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by artemvlasov on 24/06/2017.
 */
@Component
public class EntityBeanPostProcessor implements BeanPostProcessor {

    public EntityBeanPostProcessor() {
        System.out.println("EntityBeanPostProcessor constructor");
        System.out.println("===========================");
    }

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (o instanceof EntityBeanFullLifeCycle) {
            System.out.println("EntityBeanPostProcessor Post Process Before Initialization for bean " + s + " (" + o.getClass().getSimpleName() + ")");
            System.out.println("===========================");
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (o instanceof EntityBeanFullLifeCycle) {
            System.out.println("EntityBeanPostProcessor Post Process After Initialization for bean " + s + " (" + o.getClass().getSimpleName() + ")");
            System.out.println("===========================");
        }
        return o;
    }
}
