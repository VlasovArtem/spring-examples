package org.avlasov.springexamples.controller;

import org.avlasov.springexamples.controller.config.ControllerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created By artemvlasov on 22/07/2018
 **/
@SpringBootApplication
@EnableAutoConfiguration
public class ControllerApp {

    public static void main(String[] args) {
        SpringApplication.run(ControllerConfig.class);
    }

}
