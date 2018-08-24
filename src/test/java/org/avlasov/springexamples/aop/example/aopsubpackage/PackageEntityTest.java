package org.avlasov.springexamples.aop.example.aopsubpackage;

import org.apache.logging.log4j.Level;
import org.avlasov.springexamples.aop.AOPTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created By artemvlasov on 23/08/2018
 **/
public class PackageEntityTest extends AOPTestCase {

    @Autowired
    private PackageEntity packageEntity;

    @Test
    public void packageMethod() {
        assertEquals("package", packageEntity.packageMethod());
        validateLogData(new LogData(Level.INFO, "Pointcut for methods inside package and sub package 'String org.avlasov.springexamples.aop.example.aopsubpackage.PackageEntity.packageMethod\\(\\)'"));
    }
}