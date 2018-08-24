package org.avlasov.springexamples.aop.example;

import org.avlasov.springexamples.aop.annotation.AdditionalLogging;
import org.avlasov.springexamples.aop.annotation.LogExecutionTime;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 23/08/2018
 **/
@Component
public class SimpleAOP {

    @LogExecutionTime
    public int aroundFactorialWithAnnotation(int number) {
        if (number < 0) throw new IllegalArgumentException("number cannot be less then 0");
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        return sum;
    }

    public int beforeAdd(int a, int b) {
        return a + b;
    }

    public int afterMultiply(int a, int b) {
        if (a == 666 || b == 666)
            throw new RuntimeException("666 is bad number (I am just kidding_");
        return a * b;
    }

    public double addDouble(double a, double b) {
        return a + b;
    }

    public String namedMethod(String text) {
        return text + " named";
    }

    public String argumentMatching(Float aFloat) {
        return "Float argument";
    }

    public String argumentMatching(Double aDouble) {
        return "Double argument";
    }

    public String afterReturning(boolean isThrowExceptionRequired) {
        if (isThrowExceptionRequired)
            throw new RuntimeException();
        return "returning";
    }

    public TestObject afterReturningWithParameter() {
        return new TestObject("returning with parameter");
    }

    public String afterThrowing(boolean isThrowExceptionRequired) {
        if (isThrowExceptionRequired)
            throw new RuntimeException();
        return "exception was not thrown";
    }

    public String afterThrowingWithParameter(boolean isThrowExceptionRequired, String message) {
        if (isThrowExceptionRequired)
            throw new RuntimeException(message);
        return "exception was not thrown";
    }

    public TestObject aroundWithCachedData(String cachedName) {
        return new TestObject("created inside method");
    }

    public TestObject beforeWithArgs(TestObject object) {
        return object;
    }

    @AdditionalLogging(isAdditionalLoggingRequired = true)
    public void beforeWithAdditionalLogging() {}

    @AdditionalLogging(isAdditionalLoggingRequired = false)
    public void beforeWithoutAdditionalLogging() {}

    public void beforeWithBean() {}

    public TestObject aroundWithModifyingArgs(String name) {
        return new TestObject(name);
    }

    protected double protectedMultiplyDouble(double a, double b) {
        return a * b;
    }

    public class TestObject {
        private String name;

        public TestObject(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


}
