package org.avlasov.springexamples.aop.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.avlasov.springexamples.aop.annotation.AdditionalLogging;
import org.avlasov.springexamples.aop.example.SimpleAOP;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By artemvlasov on 23/08/2018
 **/
@Aspect
@Component
public class ExampleAspect {

    private final static Logger LOGGER = LogManager.getLogger(ExampleAspect.class);
    private final Map<String, SimpleAOP.TestObject> cache;

    public ExampleAspect() {
        this.cache = new HashMap<>();
        cache.put("cached", new SimpleAOP().new TestObject("Cached Object"));
    }

    @Pointcut("execution(double org.avlasov.springexamples.aop.example.SimpleAOP.*(..))")
    public void anySimpleAOPReturnDoubleMethod() {}

    @Pointcut("execution(* org.avlasov.springexamples.aop.example.SimpleAOP.afterReturningWithParameter(..))")
    public void afterReturningWithParameterPointcut() {}

    @Pointcut("execution(* org.avlasov.springexamples.aop.example.SimpleAOP.afterThrowingWithParameter(..))")
    public void afterThrowingWithParameterPointcut() {}

    @Pointcut("execution(* org.avlasov.springexamples.aop.example.SimpleAOP.beforeWithArgs(..)) && args(testObject, ..)")
    public void beforeWithArgsPointcut(SimpleAOP.TestObject testObject) {}

    @Pointcut("execution(public * *(..))")
    public void anyPublicMethod(){}

    @Around("@annotation(org.avlasov.springexamples.aop.annotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Method "  + proceedingJoinPoint.getSignature() + " call start");
        long start = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("Method " + proceedingJoinPoint.getSignature() + " call completed in " + (end - start) + "ms");
        return proceed;
    }

    @Before("execution(public int org.avlasov.springexamples.aop.example.SimpleAOP.beforeAdd(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        LOGGER.info("Before add method '" + joinPoint.getSignature() + "'");
    }

    @After("execution(public int org.avlasov.springexamples.aop.example.SimpleAOP.afterMultiply(..))")
    public void afterMethod() {
        LOGGER.info("After multiply method");
    }

    @Around("anySimpleAOPReturnDoubleMethod()")
    public Object anySimpleAOPDoubleReturnMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Pointcut for any double return methods " + proceedingJoinPoint.getSignature());
        return proceedingJoinPoint.proceed();
    }

    @Around("execution(* named*(..))")
    public Object namedMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Pointcut for methods names, that starts with 'named' " + proceedingJoinPoint.getSignature());
        return proceedingJoinPoint.proceed();
    }

    @Around("execution(* org.avlasov.springexamples.aop.example.aoppackage.*.*(..))")
    public Object packageMethodsPointcut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Pointcut for methods inside package '" + proceedingJoinPoint.getSignature() + "'");
        return proceedingJoinPoint.proceed();
    }

    @Around("execution(* org.avlasov.springexamples.aop.example.aopsubpackage..*.*(..))")
    public Object subPackageMethodsPointcut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Pointcut for methods inside package and sub package '" + proceedingJoinPoint.getSignature() + "'");
        return proceedingJoinPoint.proceed();
    }

    @Around("execution(* org.avlasov.springexamples.aop.example.SimpleAOP.*(Double))")
    public Object argumentMatchingPointcut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Pointcut for methods with matching argument type '" + proceedingJoinPoint.getSignature() + "'");
        return proceedingJoinPoint.proceed();
    }

    @AfterReturning("execution(* org.avlasov.springexamples.aop.example.SimpleAOP.afterReturning(..))")
    public void afterReturning() {
        LOGGER.info("After returning pointcut");
    }

    @AfterReturning(pointcut = "afterReturningWithParameterPointcut()", returning = "testObject")
    public void afterReturningWithParameter(Object testObject) {
        LOGGER.info("After returning with parameter pointcut");
        if (testObject instanceof SimpleAOP.TestObject) {
            SimpleAOP.TestObject to = (SimpleAOP.TestObject) testObject;
            to.setName(to.getName() + " modified");
        }
    }

    @AfterThrowing("execution(* org.avlasov.springexamples.aop.example.SimpleAOP.afterThrowing(..))")
    public void afterThrowing() {
        LOGGER.info("After throwing pointcut");
    }

    @AfterThrowing(pointcut = "afterThrowingWithParameterPointcut()", throwing = "ex")
    public void afterThrowingWithParameter(RuntimeException ex) {
        LOGGER.info("After throwing with parameter pointcut with next message '" + ex.getMessage() + "'");
    }

    @Around("execution(* org.avlasov.springexamples.aop.example.SimpleAOP.aroundWithCachedData(..))")
    public Object aroundWithCachedData(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("Around with cached data '" + proceedingJoinPoint.getSignature() + "'");
        String arg = (String) proceedingJoinPoint.getArgs()[0];
        if (cache.containsKey(arg)) {
            LOGGER.info("Cached data was found");
            return cache.get(arg);
        }
        return proceedingJoinPoint.proceed();
    }

    @Before(value = "beforeWithArgsPointcut(testObject)", argNames = "testObject")
    public void beforeWithArgs(SimpleAOP.TestObject testObject) {
        LOGGER.info("Before With args");
        testObject.setName("with help of Aspect");
    }

    @Before("anyPublicMethod() && @annotation(additionalLogging)")
    public void beforeWithAdditionalLogging(AdditionalLogging additionalLogging) {
        LOGGER.info("Before with additional logging");
        if (additionalLogging.isAdditionalLoggingRequired()) {
            LOGGER.info("Additional logging is required");
        }
    }

    @Before("execution(* org.avlasov.springexamples.aop.example.generic.Sample+.testGenericSample(*)) && args(param)")
    public void beforeWithGeneric(Double param) {
        LOGGER.info("Before with generic and Double type param");
    }

    @Before("execution(* org.avlasov.springexamples.aop.example.SimpleAOP.beforeWithBean()) && target(bean)")
    public void beforeWithBean(Object bean) {
        LOGGER.info("Before with bean");
        LOGGER.info("Bean name " + bean.getClass().getSimpleName());
    }

    @Around("execution(* org.avlasov.springexamples.aop.example.SimpleAOP.aroundWithModifyingArgs(..)) && args(name)")
    public Object aroundWithModifyingArgs(ProceedingJoinPoint proceedingJoinPoint, String name) throws Throwable {
        LOGGER.info("Around with modifying args");
        return proceedingJoinPoint.proceed(new Object[]{name + " (modified)"});
    }


}
