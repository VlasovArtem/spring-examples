package org.avlasov.springexamples.beanqualifying.primary.entity;

import org.avlasov.springexamples.beanqualifying.entity.QualifierEntity;
import org.avlasov.springexamples.beanqualifying.primary.config.PrimaryAppConfig;
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
@ContextConfiguration(classes = PrimaryAppConfig.class)
public class PrimaryBeanTest {

    @Autowired
    private QualifierEntity qualifierEntity;

    @Test
    public void name() throws Exception {
        assertEquals(qualifierEntity.getQualifiedEntity().getClass(), PrimaryBean.class);
    }
}