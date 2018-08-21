package org.avlasov.springexamples.lifecycle.defaultentity.entity;

import org.avlasov.springexamples.lifecycle.entity.AbstractLifecycleEntity;
import org.springframework.stereotype.Component;

/**
 * Created by artemvlasov on 25/06/2017.
 * List of methods goes in orders how they runs with Spring
 */
@Component
public class EntityBeanFullLifeCycle extends AbstractLifecycleEntity {}
