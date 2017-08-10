package org.avlasov.springexamples.scope.singleton.entity;

import org.avlasov.springexamples.scope.prototype.entity.nested.NestedPrototype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 09/08/2017
 **/
@Component
public class SingletonWithPrototypeBean {

    private final NestedPrototype nestedPrototype;

    @Autowired
    public SingletonWithPrototypeBean(NestedPrototype nestedPrototype) {
        this.nestedPrototype = nestedPrototype;
    }

    public NestedPrototype getNestedPrototype() {
        return nestedPrototype;
    }
}
