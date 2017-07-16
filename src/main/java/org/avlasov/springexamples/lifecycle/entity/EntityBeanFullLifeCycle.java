package org.avlasov.springexamples.lifecycle.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by artemvlasov on 25/06/2017.
 * List of methods goes in orders how they runs with Spring
 */
@Component
public class EntityBeanFullLifeCycle implements BeanNameAware, InitializingBean, DisposableBean, BeanFactoryAware, ApplicationContextAware {

    public EntityBeanFullLifeCycle() {
        System.out.println("EntityBeanFullLifeCycle default constructor");
        System.out.println("===========================");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("EntityBeanFullLifeCycle setBeanName from BeanNameAware");
        System.out.println(s);
        System.out.println("===========================");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("EntityBeanFullLifeCycle setBeanFactory from BeanFactoryAware");
        System.out.println(beanFactory);
        System.out.println("===========================");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("EntityBeanFullLifeCycle setApplicationContext from ApplicationContextAware");
        System.out.println(applicationContext);
        System.out.println("===========================");
    }

//    postProcessBeforeInitialization

    @PostConstruct
    public void annotationPostConstructMethod() {
        System.out.println("EntityBeanFullLifeCycle annotationPostConstructMethod");
        System.out.println("===========================");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("EntityBeanFullLifeCycle afterPropertiesSet from InitializingBean interface");
        System.out.println("===========================");
    }

    public void appConfigInitMethod() {
        System.out.println("EntityBeanFullLifeCycle appConfigInitMethod");
        System.out.println("===========================");
    }

    // /postProcessAfterInitialization

    @Override
    public void destroy() throws Exception {
        System.out.println("EntityBeanFullLifeCycle destroy from DisposableBean interface");
        System.out.println("===========================");
    }

    @PreDestroy
    public void annotationPreDestroyMethod() {
        System.out.println("EntityBeanFullLifeCycle annotationPreDestroyMethod");
        System.out.println("===========================");
    }

    public void appConfigDestroyMethod() {
        System.out.println("EntityBeanFullLifeCycle appConfigDestroyMethod");
        System.out.println("===========================");
    }

}
