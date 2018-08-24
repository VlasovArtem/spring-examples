package org.avlasov.springexamples.aop.example.generic;

import org.avlasov.springexamples.aop.AOPTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created By artemvlasov on 23/08/2018
 **/
public class SampleTest extends AOPTestCase {

    @Autowired
    @Qualifier("doubleSample")
    private Sample<Double> doubleSample;
    @Autowired
    @Qualifier("stringSample")
    private Sample<String> stringSample;

    @Test
    public void testGenericSample_WithValidType() {
        doubleSample.testGenericSample(25d);
        validateLogData(getInfoLogData("Before with generic and Double type param"));
    }

    @Test
    public void testGenericSample_WithNotMatchingType() {
        stringSample.testGenericSample("test");
        validateEmptyLogData();
    }




}