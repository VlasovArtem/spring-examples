package org.avlasov.springexamples.aop.annotation;

import java.lang.annotation.*;

/**
 * Created By artemvlasov on 23/08/2018
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface LogExecutionTime {
}

