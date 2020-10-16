package org.avlasov.springexamples.lifecycle.entity;

import org.avlasov.springexamples.lifecycle.utils.MessageUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created By artemvlasov on 21/08/2018
 **/
public abstract class AbstractLifecycleEntity implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String beanNameData;
    private List<String> lifeCycle;

    public AbstractLifecycleEntity() {
        lifeCycle = new ArrayList<>();
        printMessage(MessageUtils::defaultConstructorMessage);
    }

    @Override
    public void setBeanName(String s) {
        this.beanNameData = s;
        printMessage(MessageUtils::beanNameAwareMessage, s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        printMessage(MessageUtils::beanFactoryAwareMessage, beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        printMessage(MessageUtils::applicationContextAwareMessage);
    }

    @PostConstruct
    public void annotationPostConstructMethod() {
        printMessage(MessageUtils::annotationPostConstructMethodMessage);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        printMessage(MessageUtils::afterPropertiesSetMessage);
    }

    @Override
    public void destroy() throws Exception {
        printMessage(MessageUtils::destroyMessage);
    }

    @PreDestroy
    public void annotationPreDestroyMethod() {
        printMessage(MessageUtils::annotationPreDestroyMethodMessage);
    }

    protected void printMessage(Function<String, String> messageFunction, Object... additionalData) {
        System.out.println(addLifeCycle(messageFunction.apply(this.getClass().getSimpleName())));
        for (Object additionalDatum : additionalData) {
            System.out.println(additionalDatum);
        }
        System.out.println("===========================");
    }

    public String getBeanNameData() {
        return beanNameData;
    }

    public List<String> getLifeCycle() {
        return lifeCycle;
    }

    public String addLifeCycle(String data) {
        lifeCycle.add(data);
        return data;
    }

}
