package org.avlasov.springexamples.conditionbean.entity;

import org.avlasov.springexamples.conditionbean.config.ConditionBeanConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * Created By artemvlasov on 09/08/2017
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ConditionBeanConfig.class)
public class BeanFactoryConditionEntityTest {

    @Autowired
    private BeanFactoryConditionEntity beanFactoryConditionEntity;

    @Test
    public void entity() throws Exception {
        assertNotNull(beanFactoryConditionEntity);
    }
}