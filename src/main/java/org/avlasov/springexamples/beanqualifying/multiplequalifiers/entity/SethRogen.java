package org.avlasov.springexamples.beanqualifying.multiplequalifiers.entity;

import org.avlasov.springexamples.beanqualifying.multiplequalifiers.qualifiers.Comedy;
import org.avlasov.springexamples.beanqualifying.multiplequalifiers.qualifiers.Drama;
import org.springframework.stereotype.Component;

@Component
@Drama
@Comedy
public class SethRogen extends Actor {
}
