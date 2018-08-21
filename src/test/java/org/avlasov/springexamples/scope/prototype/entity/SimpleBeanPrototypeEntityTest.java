package org.avlasov.springexamples.scope.prototype.entity;

import org.avlasov.springexamples.scope.prototype.config.PrototypeAppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created By artemvlasov on 04/08/2017
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PrototypeAppConfig.class)
public class SimpleBeanPrototypeEntityTest {

    @Autowired
    private SimpleBeanPrototypeEntity first;
    @Autowired
    private SimpleBeanPrototypeEntity second;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void prototypeBeanLinksNotEquals() throws Exception {
        assertNotSame(first, second);
    }

    @Test
    public void prototypeBeanContentAreEquals() throws Exception {
        assertEquals(first, second);
    }

    @Test
    public void validatePrototypeBeanWithChangedValue() throws Exception {
        SimpleBeanPrototypeEntity third = applicationContext.getBean(SimpleBeanPrototypeEntity.class);
        first.setInitValue(10);
        assertNotEquals(first, third);
    }

}