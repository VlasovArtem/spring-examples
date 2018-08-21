package org.avlasov.springexamples.lifecycle.utils;

/**
 * Created By artemvlasov on 21/08/2018
 **/
public class MessageUtils {

    public static String defaultConstructorMessage(String className) {
        return className + " default constructor";
    }

    public static String withEntityConstructorMessage(String className) {
        return className + " constructor with autowired entity";
    }

    public static String beanNameAwareMessage(String className) {
        return className + " setBeanName from BeanNameAware";
    }

    public static String beanFactoryAwareMessage(String className) {
        return className + " setBeanFactory from BeanFactoryAware";
    }

    public static String applicationContextAwareMessage(String className) {
        return className + " setApplicationContext from ApplicationContextAware";
    }

    public static String postProcessBeforeInitializationMessage(String beanName, String className) {
        return "EntityBeanPostProcessor Post Process Before Initialization for bean " + beanName + " (" + className + ")";
    }

    public static String postProcessAfterInitializationMessage(String beanName, String className) {
        return "EntityBeanPostProcessor Post Process After Initialization for bean " + beanName + " (" + className + ")";
    }

    public static String annotationPostConstructMethodMessage(String className) {
        return className + " annotationPostConstructMethod";
    }

    public static String afterPropertiesSetMessage(String className) {
        return className + " afterPropertiesSet from InitializingBean interface";
    }

    public static String destroyMessage(String className) {
        return className + " destroy from DisposableBean interface";
    }

    public static String annotationPreDestroyMethodMessage(String className) {
        return className + " annotationPreDestroyMethod";
    }

}
