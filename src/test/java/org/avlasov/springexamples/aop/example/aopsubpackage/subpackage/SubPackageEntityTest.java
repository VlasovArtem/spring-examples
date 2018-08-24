package org.avlasov.springexamples.aop.example.aopsubpackage.subpackage;

import org.apache.logging.log4j.Level;
import org.avlasov.springexamples.aop.AOPTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created By artemvlasov on 23/08/2018
 **/
public class SubPackageEntityTest extends AOPTestCase {

    @Autowired
    private SubPackageEntity subPackageEntity;

    @Test
    public void subPackage() {
        assertEquals("sub-package", subPackageEntity.subPackage());
        validateLogData(new LogData(Level.INFO, "Pointcut for methods inside package and sub package 'String org.avlasov.springexamples.aop.example.aopsubpackage.subpackage.SubPackageEntity.subPackage\\(\\)'"));
    }

}