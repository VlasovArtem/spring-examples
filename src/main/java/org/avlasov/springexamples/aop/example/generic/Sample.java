package org.avlasov.springexamples.aop.example.generic;

import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 23/08/2018
 **/
@Component
public interface Sample<T> {

    void testGenericSample(T sample);

}
