package org.avlasov.springexamples.other.required.config;

import org.avlasov.springexamples.lifecycle.MainLifeCycleTestCase;
import org.avlasov.springexamples.other.required.entity.EntityWithRequiredField;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created By artemvlasov on 22/08/2018
 *
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration
@Ignore
public class WithoutExistingRequiredConfigTest {

    @Autowired
    private EntityWithRequiredField entityWithRequiredField;

    @Test
    public void test() {
        assertTrue(true);
    }
}