package org.avlasov.springexamples.aop.example.aoppackage;

import org.apache.logging.log4j.Level;
import org.avlasov.springexamples.aop.AOPTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created By artemvlasov on 23/08/2018
 **/
public class PackagePointcutEntityTest extends AOPTestCase {

    @Autowired
    private PackagePointcutEntity packagePointcutEntity;

    @Test
    public void first() {
        assertEquals("first", packagePointcutEntity.first());
        validateLogData(new LogData(Level.INFO, "Pointcut for methods inside package 'String org.avlasov.springexamples.aop.example.aoppackage.PackagePointcutEntity.first\\(\\)'"));
    }

    @Test
    public void second() {
        assertEquals("second", packagePointcutEntity.second());
        validateLogData(new LogData(Level.INFO, "Pointcut for methods inside package 'String org.avlasov.springexamples.aop.example.aoppackage.PackagePointcutEntity.second\\(\\)'"));
    }

    @Test
    public void third() {
        assertEquals("third", packagePointcutEntity.third());
        validateLogData(new LogData(Level.INFO, "Pointcut for methods inside package 'String org.avlasov.springexamples.aop.example.aoppackage.PackagePointcutEntity.third\\(\\)'"));
    }

}