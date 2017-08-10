package org.avlasov.springexamples.value.properties.entity;

import org.avlasov.springexamples.MainLoggerTestCase;
import org.avlasov.springexamples.value.properties.config.PropertiesConfig;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created By artemvlasov on 09/08/2017
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PropertiesConfig.class)
public class ValuePropertyEntityTest extends MainLoggerTestCase {

    @Autowired
    private ValuePropertyEntity valuePropertyEntity;

    @BeforeClass
    public static void beforeClass() {
        LOGGER.info("Value Property Entity Test");
    }

    @Test
    public void getFieldProperty() throws Exception {
        LOGGER.info("Validate Field Property");
        assertEquals(valuePropertyEntity.getFieldProperty(), "test");
    }

    @Test
    public void getDefaultProperty() throws Exception {
        LOGGER.info("Validate Default Property");
        assertEquals(valuePropertyEntity.getDefaultProperty(), "default_value");
    }

    @Test
    public void getConfigProperty() throws Exception {
        LOGGER.info("Validate Config Property");
        assertEquals(valuePropertyEntity.getConfigProperty(), "yes");
    }

}