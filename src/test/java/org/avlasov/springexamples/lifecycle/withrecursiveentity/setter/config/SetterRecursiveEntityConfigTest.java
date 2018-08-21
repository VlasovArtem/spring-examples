package org.avlasov.springexamples.lifecycle.withrecursiveentity.setter.config;

import org.avlasov.springexamples.lifecycle.MainLifeCycleTestCase;
import org.avlasov.springexamples.lifecycle.withrecursiveentity.setter.entity.SetterFirstEntity;
import org.avlasov.springexamples.lifecycle.withrecursiveentity.setter.entity.SetterSecondEntity;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created By artemvlasov on 21/08/2018
 **/
@ContextConfiguration(classes = SetterRecursiveEntityConfig.class)
public class SetterRecursiveEntityConfigTest extends MainLifeCycleTestCase {

    @Test
    public void testBean() {
        SetterFirstEntity setterFirstEntity = (SetterFirstEntity) beansMap.get("setterFirstEntity");
        SetterSecondEntity setterSecondEntity = (SetterSecondEntity) beansMap.get("setterSecondEntity");
        assertNotNull(setterFirstEntity);
        assertNotNull(setterSecondEntity);
        assertNotNull(setterFirstEntity.getSetterSecondEntity());
        assertNotNull(setterSecondEntity.getSetterFirstEntity());
        assertEquals("setterFirstEntity", setterFirstEntity.getBeanNameData());
        assertEquals("setterSecondEntity", setterSecondEntity.getBeanNameData());
    }
}