package org.avlasov.springexamples.aop.example;

import org.avlasov.springexamples.aop.AOPTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created By artemvlasov on 23/08/2018
 **/
public class SimpleAOPTest extends AOPTestCase {

    @Autowired
    private SimpleAOP simpleAOP;

    @Test
    public void aroundFactorialWithAnnotation() {
        assertEquals(6, simpleAOP.aroundFactorialWithAnnotation(3));
        validateLogData(
                getInfoLogData("Method int org.avlasov.springexamples.aop.example.SimpleAOP.aroundFactorialWithAnnotation\\(int\\) call start"),
                getInfoLogData( "Method int org.avlasov.springexamples.aop.example.SimpleAOP.aroundFactorialWithAnnotation\\(int\\) call completed in [0-9]+ms"));
    }

    @Test
    public void beforeAdd() {
        assertEquals(10, simpleAOP.beforeAdd(3, 7));
        validateLogData(getInfoLogData( "Before add method 'int org.avlasov.springexamples.aop.example.SimpleAOP.beforeAdd\\(int,int\\)'"));
    }

    @Test
    public void afterMultiply() {
        assertEquals(25, simpleAOP.afterMultiply(5, 5));
        validateLogData(getInfoLogData( "After multiply method"));
    }

    @Test
    public void afterMultiply_WithException() {
        try {
            simpleAOP.afterMultiply(666, 5);
        } catch (Exception ex) {
            validateLogData(getInfoLogData( "After multiply method"));
        }
    }

    @Test
    public void addDouble() {
        assertEquals(5.9, simpleAOP.addDouble(2.3, 3.6), 0);
        validateLogData(getInfoLogData( "Pointcut for any double return methods double org.avlasov.springexamples.aop.example.SimpleAOP.addDouble\\(double,double\\)"));
    }

    @Test
    public void protectedMultiplyDouble() {
        assertEquals(34.98, simpleAOP.protectedMultiplyDouble(3.3, 10.6), 0);
        validateLogData(getInfoLogData( "Pointcut for any double return methods double org.avlasov.springexamples.aop.example.SimpleAOP.protectedMultiplyDouble\\(double,double\\)"));
    }

    @Test
    public void namedMethod() {
        assertEquals("test named", simpleAOP.namedMethod("test"));
        validateLogData(getInfoLogData( "Pointcut for methods names, that starts with 'named' String org.avlasov.springexamples.aop.example.SimpleAOP.namedMethod\\(String\\)"));
    }

    @Test
    public void argumentMatching_WithNotMatchingFloatArgument() {
        assertEquals("Float argument", simpleAOP.argumentMatching(1f));
        validateLogData(Collections.emptyList());
    }

    @Test
    public void argumentMatching_WithMatchingDoubleArgument() {
        assertEquals("Double argument", simpleAOP.argumentMatching(1.2d));
        validateLogData(getInfoLogData( "Pointcut for methods with matching argument type 'String org.avlasov.springexamples.aop.example.SimpleAOP.argumentMatching\\(Double\\)'"));
    }

    @Test
    public void afterReturning() {
        assertEquals("returning", simpleAOP.afterReturning(false));
        validateLogData(getInfoLogData( "After returning pointcut"));
    }

    @Test
    public void afterReturning_WithThrowingException() {
        try {
            simpleAOP.afterReturning(true);
        } catch (Exception ex) {
            validateLogData(Collections.emptyList());
        }
    }

    @Test
    public void afterReturningWithParameter() {
        SimpleAOP.TestObject testObject = simpleAOP.afterReturningWithParameter();
        assertNotNull(testObject);
        assertNotEquals("returning with parameter", testObject.getName());
        validateLogData(getInfoLogData( "After returning with parameter pointcut"));
    }

    @Test
    public void afterThrowing() {
        assertEquals("exception was not thrown", simpleAOP.afterThrowing(false));
        validateLogData(Collections.emptyList());
    }

    @Test
    public void afterThrowing_WithException() {
        try {
            simpleAOP.afterThrowing(true);
        } catch (Exception ex) {
            validateLogData(getInfoLogData( "After throwing pointcut"));
        }

    }

    @Test
    public void afterThrowingWithParameter() {
        assertEquals("exception was not thrown", simpleAOP.afterThrowingWithParameter(false, "test"));
        validateLogData(Collections.emptyList());
    }

    @Test
    public void afterThrowingWithParameter_WithException() {
        try {
            simpleAOP.afterThrowingWithParameter(true, "test message from throwing with parameter");
        } catch (Exception ex) {
            validateLogData(getInfoLogData( "After throwing with parameter pointcut with next message 'test message from throwing with parameter'"));
        }

    }

    @Test
    public void aroundWithCachedData() {
        SimpleAOP.TestObject test = simpleAOP.aroundWithCachedData("cached");
        assertNotNull(test);
        assertEquals("Cached Object", test.getName());
        validateLogData(getInfoLogData( "Around with cached data 'TestObject org.avlasov.springexamples.aop.example.SimpleAOP.aroundWithCachedData\\(String\\)'"),
                getInfoLogData( "Cached data was found"));
    }

    @Test
    public void aroundWithCachedData_WithoutCachedData() {
        SimpleAOP.TestObject test = simpleAOP.aroundWithCachedData("not cached");
        assertNotNull(test);
        assertEquals("created inside method", test.getName());
        validateLogData(getInfoLogData("Around with cached data 'TestObject org.avlasov.springexamples.aop.example.SimpleAOP.aroundWithCachedData\\(String\\)'"));
    }

    @Test
    public void beforeWithArgs() {
        String initString = "from the test";
        SimpleAOP.TestObject from_the_test = new SimpleAOP().new TestObject(initString);
        SimpleAOP.TestObject testObject = simpleAOP.beforeWithArgs(from_the_test);
        assertNotEquals(initString, testObject.getName());
        assertNotEquals(initString, from_the_test.getName());
        validateLogData(getInfoLogData( "Before With args"));
    }

    @Test
    public void beforeWithAdditionalLogging() {
        simpleAOP.beforeWithAdditionalLogging();
        validateLogData(getInfoLogData("Before with additional logging"), getInfoLogData("Additional logging is required"));
    }

    @Test
    public void beforeWithoutAdditionalLogging() {
        simpleAOP.beforeWithoutAdditionalLogging();
        validateLogData(getInfoLogData("Before with additional logging"));
    }

    @Test
    public void beforeWithBean() {
        simpleAOP.beforeWithBean();
        validateLogData(getInfoLogData("Before with bean"), getInfoLogData("Bean name " + SimpleAOP.class.getSimpleName()));
    }

    @Test
    public void aroundWithModifyingArgs() {
        String name = "test name";
        SimpleAOP.TestObject test_name = simpleAOP.aroundWithModifyingArgs(name);
        assertNotNull(test_name);
        assertNotEquals(name, test_name.getName());
        validateLogData(getInfoLogData("Around with modifying args"));
    }
}