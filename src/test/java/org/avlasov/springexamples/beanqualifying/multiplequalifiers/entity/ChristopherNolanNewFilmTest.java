package org.avlasov.springexamples.beanqualifying.multiplequalifiers.entity;

import org.avlasov.springexamples.beanqualifying.multiplequalifiers.config.MultipleQualifiersConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created By artemvlasov on 09/08/2017
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MultipleQualifiersConfig.class)
public class ChristopherNolanNewFilmTest {

    @Autowired
    private ChristopherNolanNewFilm christopherNolanNewFilm;

    @Test
    public void getActor() throws Exception {
        assertEquals(christopherNolanNewFilm.getActor().getClass(), TomHardy.class);
    }
}