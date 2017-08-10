package org.avlasov.springexamples.lifecycle.config;

import org.avlasov.springexamples.MainLoggerTestCase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created By artemvlasov on 09/08/2017
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = LifecycleAppConfig.class)
public class LifecycleAppConfigTest extends MainLoggerTestCase {

    @Autowired
    private ApplicationContext applicationContext;

    @BeforeClass
    public static void before() {
        LOGGER.info("Bean Lifecycle Verification");
    }

    @Test
    public void name() throws Exception {
        assertTrue(true);
    }


}