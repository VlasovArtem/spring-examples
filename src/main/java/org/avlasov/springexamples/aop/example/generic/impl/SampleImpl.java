package org.avlasov.springexamples.aop.example.generic.impl;

import org.avlasov.springexamples.aop.example.generic.Sample;

/**
 * Created By artemvlasov on 23/08/2018
 **/
public class SampleImpl<T> implements Sample<T> {

    @Override
    public void testGenericSample(T sample) {}

}
