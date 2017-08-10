package org.avlasov.springexamples.scope.singleton.entity;

import org.avlasov.springexamples.scope.singleton.entity.nested.NestedProxiedPrototype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 09/08/2017
 **/
@Component
public class SingletonWithPrototypeProxiedBean {

    private final NestedProxiedPrototype nestedProxiedPrototype;

    @Autowired
    public SingletonWithPrototypeProxiedBean(NestedProxiedPrototype nestedProxiedPrototype) {
        this.nestedProxiedPrototype = nestedProxiedPrototype;
    }

    public NestedProxiedPrototype getNestedProxiedPrototype() {
        return nestedProxiedPrototype;
    }
}
