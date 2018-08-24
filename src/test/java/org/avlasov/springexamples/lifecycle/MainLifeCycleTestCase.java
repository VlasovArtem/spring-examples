package org.avlasov.springexamples.lifecycle;

import org.avlasov.springexamples.LoggerTestCase;
import org.avlasov.springexamples.lifecycle.entity.AbstractLifecycleEntity;
import org.avlasov.springexamples.lifecycle.utils.MessageUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created By artemvlasov on 21/08/2018
 **/
@RunWith(SpringRunner.class)
public abstract class MainLifeCycleTestCase extends LoggerTestCase {

    @Autowired
    private ApplicationContext applicationContext;
    private Map<String, List<String>> data;
    protected Map<String, AbstractLifecycleEntity> beansMap;

    @Before
    public void setUp() throws Exception {
        beansMap = applicationContext.getBeansOfType(AbstractLifecycleEntity.class);
        this.data = generateDefaultLifeCycleStart();
    }

    @Test
    public void testBeanNames() {
        assertTrue(beansMap
                .entrySet()
                .stream()
                .allMatch(entry -> entry.getKey().equals(entry.getValue().getBeanNameData())));
    }

    @Test
    public void testLifeCycle() {
        assertTrue(beansMap
                .entrySet()
                .stream()
                .allMatch(entry -> {
                    List<String> strings = data.get(entry.getKey());
                    if (strings == null) return false;
                    return strings.equals(entry.getValue().getLifeCycle());
                }));
    }

    protected void addData(String beanName, List<String> lifeCycleData) {
        data.put(beanName, lifeCycleData);
    }

    protected List<String> getDataList(String beanName) {
        return data.get(beanName);
    }

    private Map<String, List<String>> generateDefaultLifeCycleStart() {
        Map<String, List<String>> data = new HashMap<>();
        for (Map.Entry<String, AbstractLifecycleEntity> entry : beansMap.entrySet()) {
            data.put(entry.getKey(), generateDefaultLifeCycleStartList(entry.getKey(), entry.getValue().getClass().getSimpleName()));
        }
        return data;
    }

    private List<String> generateDefaultLifeCycleStartList(String beanName, String className) {
        List<String> lifeCycle = new ArrayList<>();
        lifeCycle.add(MessageUtils.defaultConstructorMessage(className));
        lifeCycle.add(MessageUtils.beanNameAwareMessage(className));
        lifeCycle.add(MessageUtils.beanFactoryAwareMessage(className));
        lifeCycle.add(MessageUtils.applicationContextAwareMessage(className));
        lifeCycle.add(MessageUtils.postProcessBeforeInitializationMessage(beanName, className));
        lifeCycle.add(MessageUtils.annotationPostConstructMethodMessage(className));
        lifeCycle.add(MessageUtils.afterPropertiesSetMessage(className));
        lifeCycle.add(MessageUtils.postProcessAfterInitializationMessage(beanName, className));
        return lifeCycle;
    }

}
