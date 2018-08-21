package org.avlasov.springexamples.lifecycle.withrecursiveentity.postconstruct.config;

import org.avlasov.springexamples.lifecycle.MainLifeCycleTestCase;
import org.avlasov.springexamples.lifecycle.utils.MessageUtils;
import org.avlasov.springexamples.lifecycle.withrecursiveentity.postconstruct.entity.PostConstructFirstEntity;
import org.avlasov.springexamples.lifecycle.withrecursiveentity.postconstruct.entity.WithPostConstructAutowiredEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created By artemvlasov on 21/08/2018
 **/
@ContextConfiguration(classes = PostConstructRecursiveEntityConfig.class)
public class PostConstructRecursiveEntityConfigTest extends MainLifeCycleTestCase {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        getDataList("postConstructFirstEntity").add(1, MessageUtils.withEntityConstructorMessage(PostConstructFirstEntity.class.getSimpleName()));
        getDataList("postConstructFirstEntity").set(6, MessageUtils.annotationPostConstructMethodMessage(PostConstructFirstEntity.class.getSimpleName()));
    }

    @Test
    public void test_entity() {
        WithPostConstructAutowiredEntity withPostConstructAutowiredEntity = (WithPostConstructAutowiredEntity) beansMap.get("withPostConstructAutowiredEntity");
        assertNotNull(withPostConstructAutowiredEntity);
        assertNotNull(withPostConstructAutowiredEntity.getPostConstructFirstEntity());
        assertEquals("postConstructFirstEntity", withPostConstructAutowiredEntity.getPostConstructFirstEntity().getBeanNameData());
    }
}