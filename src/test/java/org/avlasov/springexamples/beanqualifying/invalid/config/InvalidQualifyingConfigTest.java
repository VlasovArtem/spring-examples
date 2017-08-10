package org.avlasov.springexamples.beanqualifying.invalid.config;

import org.junit.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created By artemvlasov on 10/08/2017
 **/
public class InvalidQualifyingConfigTest {

    @Test(expected = UnsatisfiedDependencyException.class)
    public void invalidQualifier() throws Exception {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(InvalidQualifyingConfig.class);
    }
}