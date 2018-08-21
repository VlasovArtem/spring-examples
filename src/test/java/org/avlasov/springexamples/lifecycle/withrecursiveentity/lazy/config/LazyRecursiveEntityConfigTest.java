package org.avlasov.springexamples.lifecycle.withrecursiveentity.lazy.config;

import org.avlasov.springexamples.lifecycle.MainLifeCycleTestCase;
import org.avlasov.springexamples.lifecycle.utils.MessageUtils;
import org.avlasov.springexamples.lifecycle.withrecursiveentity.lazy.entity.LazyFirstEntity;
import org.avlasov.springexamples.lifecycle.withrecursiveentity.lazy.entity.WithLazyAutowiredEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created By artemvlasov on 21/08/2018
 **/
@ContextConfiguration(classes = LazyRecursiveEntityConfig.class)
public class LazyRecursiveEntityConfigTest extends MainLifeCycleTestCase {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        getDataList("lazyFirstEntity").add(1, MessageUtils.withEntityConstructorMessage(LazyFirstEntity.class.getSimpleName()));
        getDataList("withLazyAutowiredEntity").add(1, MessageUtils.withEntityConstructorMessage(WithLazyAutowiredEntity.class.getSimpleName()));
    }

    @Test
    public void testLazy() {
        WithLazyAutowiredEntity withLazyAutowiredEntity = (WithLazyAutowiredEntity) beansMap.get("withLazyAutowiredEntity");
        assertNotNull(withLazyAutowiredEntity);
        assertNotNull(withLazyAutowiredEntity.getLazyFirstEntity());
        assertEquals("lazyFirstEntity", withLazyAutowiredEntity.getLazyFirstEntity().getBeanNameData());
    }
}