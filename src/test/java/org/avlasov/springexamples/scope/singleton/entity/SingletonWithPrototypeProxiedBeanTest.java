package org.avlasov.springexamples.scope.singleton.entity;

import org.avlasov.springexamples.scope.singleton.config.SingletonAppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created By artemvlasov on 09/08/2017
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SingletonAppConfig.class)
public class SingletonWithPrototypeProxiedBeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void SingletonWithPrototypeProxiedBean() throws Exception {
        SingletonWithPrototypeProxiedBean bean = applicationContext.getBean(SingletonWithPrototypeProxiedBean.class);
        SingletonWithPrototypeProxiedBean bean1 = applicationContext.getBean(SingletonWithPrototypeProxiedBean.class);
        assertEquals(bean, bean1);
    }

    @Test
    public void NestedProxiedPrototype() throws Exception {
        SingletonWithPrototypeProxiedBean bean = applicationContext.getBean(SingletonWithPrototypeProxiedBean.class);
        SingletonWithPrototypeProxiedBean bean1 = applicationContext.getBean(SingletonWithPrototypeProxiedBean.class);
//        nestedProxiedPrototype1.setTestName("test"); will not change value of the bean above - Spring will create new prototype every time
        // Every call to the Proxied Prototype will create new item and manipulate with new object
        assertNotEquals(bean.getNestedProxiedPrototype().toString(), bean1.getNestedProxiedPrototype().toString());
        assertNotEquals(bean.getNestedProxiedPrototype().getTestName(), bean1.getNestedProxiedPrototype().getTestName());
    }

}