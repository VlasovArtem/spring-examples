package org.avlasov.springexamples.lifecycle.postprocessor;

import org.avlasov.springexamples.lifecycle.entity.AbstractLifecycleEntity;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import static org.avlasov.springexamples.lifecycle.utils.MessageUtils.postProcessAfterInitializationMessage;
import static org.avlasov.springexamples.lifecycle.utils.MessageUtils.postProcessBeforeInitializationMessage;

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
        if (o instanceof AbstractLifecycleEntity) {
            System.out.println(((AbstractLifecycleEntity) o).addLifeCycle(postProcessBeforeInitializationMessage(s, o.getClass().getSimpleName())));
            System.out.println("===========================");
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (o instanceof AbstractLifecycleEntity) {
            System.out.println(((AbstractLifecycleEntity) o).addLifeCycle(postProcessAfterInitializationMessage(s, o.getClass().getSimpleName())));
            System.out.println("===========================");
        }
        return o;
    }
}
