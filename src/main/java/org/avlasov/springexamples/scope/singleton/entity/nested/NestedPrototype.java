package org.avlasov.springexamples.scope.singleton.entity.nested;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 04/08/2017
 **/
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NestedPrototype {
    
}
