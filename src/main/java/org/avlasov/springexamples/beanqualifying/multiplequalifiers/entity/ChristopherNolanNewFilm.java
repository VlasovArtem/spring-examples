package org.avlasov.springexamples.beanqualifying.multiplequalifiers.entity;

import org.avlasov.springexamples.beanqualifying.multiplequalifiers.qualifiers.Crime;
import org.avlasov.springexamples.beanqualifying.multiplequalifiers.qualifiers.Drama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created By artemvlasov on 22/07/2017
 **/
@Component
public class ChristopherNolanNewFilm {

    private final Actor actor;

    @Autowired
    public ChristopherNolanNewFilm(@Crime @Drama Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }
}
