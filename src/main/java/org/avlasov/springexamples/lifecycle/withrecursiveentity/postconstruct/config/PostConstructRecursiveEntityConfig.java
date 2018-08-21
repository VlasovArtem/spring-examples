package org.avlasov.springexamples.lifecycle.withrecursiveentity.postconstruct.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created By artemvlasov on 20/08/2018
 **/
@Configuration
@ComponentScan(basePackages = {"org.avlasov.springexamples.lifecycle.withrecursiveentity.postconstruct", "org.avlasov.springexamples.lifecycle.postprocessor"})
public class PostConstructRecursiveEntityConfig {}
