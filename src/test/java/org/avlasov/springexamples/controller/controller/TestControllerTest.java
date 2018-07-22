package org.avlasov.springexamples.controller.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.avlasov.springexamples.controller.config.ControllerConfig;
import org.avlasov.springexamples.controller.entity.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created By artemvlasov on 22/07/2018
 **/
@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = ControllerConfig.class)
public class TestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private List<String> testControllerData;
    private ObjectMapper objectMapper;

    public TestControllerTest() {
        testControllerData = new TestController().getTestData();
        objectMapper = Jackson2ObjectMapperBuilder
                .json()
                .autoDetectFields(true)
                .build();
    }

    @Test
    public void getString_WithValidData_ReturnString() throws Exception {
        mockMvc.perform(get("/test/get/string"))
                .andExpect(status().isOk())
                .andExpect(content().string(testControllerData.get(1)));
    }

    @Test
    public void getString_WithRequestParam_ReturnOkResponseEntity() throws Exception {
        mockMvc.perform(get("/test/get/string/message?number=3"))
                .andExpect(status().isOk())
                .andExpect(content().string(testControllerData.get(2)));
    }

    @Test
    public void getString_WithZeroRequestParam_ReturnErrorResponseEntity() throws Exception {
        String message = String.format("Number '%d' is not valid. Number is negative, zero or greater than number of records (%d).", 0, testControllerData.size());
        mockMvc.perform(get("/test/get/string/message?number=0"))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().string(message));
    }

    @Test
    public void getString_WithNegativeNumberRequestParam_ReturnErrorResponseEntity() throws Exception {
        String message = String.format("Number '%d' is not valid. Number is negative, zero or greater than number of records (%d).", -1, testControllerData.size());
        mockMvc.perform(get("/test/get/string/message?number=-1"))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().string(message));
    }

    @Test
    public void getString_WithNumberGreaterThenDataSizeRequestParam_ReturnErrorResponseEntity() throws Exception {
        String message = String.format("Number '%d' is not valid. Number is negative, zero or greater than number of records (%d).", testControllerData.size() + 5, testControllerData.size());
        mockMvc.perform(get("/test/get/string/message?number=" + (testControllerData.size() + 5)))
                .andExpect(status().isNotAcceptable())
                .andExpect(content().string(message));
    }

    @Test
    public void getHelloMessage_WithName_ReturnResponseEntity() throws Exception {
        mockMvc.perform(get("/test/get/hello/Jonny"))
                .andExpect(status().isOk())
                .andExpect(content().string("Say hello to Jonny"));
    }

    @Test
    public void getMessageFromData_WithData_ReturnResponseEntity() throws Exception {
        Data data = new Data("first text", "second text");
        String message = String.format("Here is the first data text '%s' and second data text '%s'", data.getFirstText(), data.getSecondText());
        mockMvc.perform(get("/test/get/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(data)))
                .andExpect(status().isOk())
                .andExpect(content().string(message));
    }

    @Test
    public void getMessageFromData_WithMissingBody_ReturnErrorResponseEntity() throws Exception {
        mockMvc.perform(get("/test/get/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andExpect(status().isNotAcceptable());
    }

    @Test
    public void updateData_WithData_ReturnResponseEntity() throws Exception {
        Data data = new Data("first text", "second text");
        String message = String.format("Data with the first data text '%s' and second data text '%s' have been updated", data.getFirstText(), data.getSecondText());
        mockMvc.perform(put("/test/update/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(data)))
                .andExpect(status().isOk())
                .andExpect(content().string(message));
    }

    @Test
    public void updateData_WithEmptyData_ReturnErrorResponseEntity() throws Exception {
        mockMvc.perform(put("/test/update/data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotAcceptable());
    }

    @Test
    public void addData_WithData_ReturnResponseEntity() throws Exception {
        Data data = new Data("first text", "second text");
        String message = String.format("Data with the first data text '%s' and second data text '%s' have been added", data.getFirstText(), data.getSecondText());
        mockMvc.perform(post("/test/add/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(data)))
                .andExpect(status().isOk())
                .andExpect(content().string(message));
    }

    @Test
    public void addData_WithNullData_ReturnErrorResponseEntity() throws Exception {
        mockMvc.perform(post("/test/add/data")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotAcceptable());
    }

}