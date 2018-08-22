package org.avlasov.springexamples.other.required.config;

import org.avlasov.springexamples.other.required.entity.EntityWithRequiredField;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created By artemvlasov on 22/08/2018
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration
public class WithExistingRequiredConfigTest {

    @Autowired
    private EntityWithRequiredField entityWithRequiredField;

    @Test
    public void test() {
        assertEquals("test", entityWithRequiredField.getName());
    }
}