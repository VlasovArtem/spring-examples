package org.avlasov.springexamples.beanqualifying.qualifier.config;

import org.avlasov.springexamples.beanqualifying.entity.QualifierEntity;
import org.avlasov.springexamples.beanqualifying.entity.SecondBean;
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
@ContextConfiguration(classes = QualifierAppConfig.class)
public class QualifierAppConfigTest {

    @Autowired
    private QualifierEntity qualifierEntity;

    @Test
    public void qualifierEntity() throws Exception {
        assertEquals(qualifierEntity.getQualifiedEntity().getClass(), SecondBean.class);
    }

}