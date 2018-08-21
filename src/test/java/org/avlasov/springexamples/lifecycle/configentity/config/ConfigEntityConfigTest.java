package org.avlasov.springexamples.lifecycle.configentity.config;

import org.avlasov.springexamples.lifecycle.MainLifeCycleTestCase;
import org.avlasov.springexamples.lifecycle.configentity.entity.ConfigEntityBeanFullLifeCycle;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

/**
 * Created By artemvlasov on 21/08/2018
 **/
@ContextConfiguration(classes = ConfigEntityConfig.class)
public class ConfigEntityConfigTest extends MainLifeCycleTestCase {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        List<String> configEntityBeanFullLifeCycle = getDataList("configEntityBeanFullLifeCycle");
        configEntityBeanFullLifeCycle.add(configEntityBeanFullLifeCycle.size() - 1, ConfigEntityBeanFullLifeCycle.class.getSimpleName() + " appConfigInitMethod");
    }

    @BeforeClass
    public static void before() {
        LOGGER.info("Config Entity bean Lifecycle Verification");
    }

}