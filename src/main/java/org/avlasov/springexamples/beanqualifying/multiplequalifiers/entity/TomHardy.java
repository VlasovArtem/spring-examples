package org.avlasov.springexamples.beanqualifying.multiplequalifiers.entity;

import org.avlasov.springexamples.beanqualifying.multiplequalifiers.qualifiers.Crime;
import org.avlasov.springexamples.beanqualifying.multiplequalifiers.qualifiers.Drama;
import org.springframework.stereotype.Component;

@Component
@Drama
@Crime
public class TomHardy extends Actor {
}

