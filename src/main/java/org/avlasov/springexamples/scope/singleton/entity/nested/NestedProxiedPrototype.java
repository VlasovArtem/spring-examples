package org.avlasov.springexamples.scope.singleton.entity.nested;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created By artemvlasov on 04/08/2017
 **/
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NestedProxiedPrototype {

    private String testName;

    public NestedProxiedPrototype() {
        testName = LocalDateTime.now().toString();
    }

    public String setTestName(String testName) {
        this.testName = testName;
        return testName;
    }

    public String getTestName() {
        return testName;
    }
}
