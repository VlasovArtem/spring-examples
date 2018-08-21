package org.avlasov.springexamples.controller.controller;

import org.avlasov.springexamples.controller.config.ControllerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created By artemvlasov on 21/08/2018
 **/
@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = ControllerConfig.class)
public class SecondTestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testControllerExceptionHandler() throws Exception {
        mockMvc.perform(get("/test/second/exception/controllerException"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Controller Exception handler test from second controller"));
    }

}