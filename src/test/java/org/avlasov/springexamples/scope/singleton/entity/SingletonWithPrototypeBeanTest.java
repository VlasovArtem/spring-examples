package org.avlasov.springexamples.scope.singleton.entity;

import org.avlasov.springexamples.scope.singleton.config.SingletonAppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created By artemvlasov on 09/08/2017
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SingletonAppConfig.class)
public class SingletonWithPrototypeBeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void SingletonWithPrototypeBean() throws Exception {
        SingletonWithPrototypeBean bean = applicationContext.getBean(SingletonWithPrototypeBean.class);
        SingletonWithPrototypeBean bean1 = applicationContext.getBean(SingletonWithPrototypeBean.class);
        assertEquals(bean, bean1);
    }

    @Test
    public void NestedPrototype() throws Exception {
        SingletonWithPrototypeBean bean = applicationContext.getBean(SingletonWithPrototypeBean.class);
        SingletonWithPrototypeBean bean1 = applicationContext.getBean(SingletonWithPrototypeBean.class);
        assertEquals(bean.getNestedPrototype(), bean1.getNestedPrototype());
    }
}