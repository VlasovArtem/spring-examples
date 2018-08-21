package org.avlasov.springexamples.lifecycle.withautowiredentity.config;

import org.avlasov.springexamples.lifecycle.MainLifeCycleTestCase;
import org.avlasov.springexamples.lifecycle.utils.MessageUtils;
import org.avlasov.springexamples.lifecycle.withautowiredentity.entity.EntityBeanFullLifeCycleWithAutowired;
import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * Created By artemvlasov on 21/08/2018
 **/
@ContextConfiguration(classes = WithAutowiredEntityConfig.class)
public class WithAutowiredEntityConfigTest extends MainLifeCycleTestCase {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        List<String> dataList = getDataList("entityBeanFullLifeCycleWithAutowired");
        dataList.add(1, MessageUtils.withEntityConstructorMessage(EntityBeanFullLifeCycleWithAutowired.class.getSimpleName()));
    }

}