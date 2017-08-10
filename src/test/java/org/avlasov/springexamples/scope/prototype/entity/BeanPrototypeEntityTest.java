package org.avlasov.springexamples.scope.prototype.entity;

import org.avlasov.springexamples.scope.entity.ComponentEntityBean;
import org.avlasov.springexamples.scope.prototype.config.PrototypeAppConfig;
import org.avlasov.springexamples.scope.prototype.entity.nested.NestedPrototype;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created By artemvlasov on 04/08/2017
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PrototypeAppConfig.class)
public class BeanPrototypeEntityTest {

    @Autowired
    private BeanPrototypeEntity beanPrototypeEntity;
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void beanPrototypeEntity_ValidateSingletonComponentEntityBean() throws Exception {
        ComponentEntityBean componentEntityBean = beanPrototypeEntity.getComponentEntityBean();
        BeanPrototypeEntity bean = applicationContext.getBean(BeanPrototypeEntity.class);
        assertEquals(componentEntityBean, bean.getComponentEntityBean());
    }

    @Test
    public void beanPrototypeEntity_ValidatePrototypeNestedEntityBean() throws Exception {
        NestedPrototype nestedPrototype = beanPrototypeEntity.getNestedPrototype();
        BeanPrototypeEntity bean = applicationContext.getBean(BeanPrototypeEntity.class);
        assertNotEquals(nestedPrototype, bean.getNestedPrototype());
    }

}