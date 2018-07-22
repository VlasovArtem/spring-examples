package org.avlasov.springexamples.controller.controller;

import org.avlasov.springexamples.controller.entity.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created By artemvlasov on 22/07/2018
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    private List<String> testData;

    public TestController() {
        testData = Arrays.asList("hello", "test", "data", "error", "no", "yes");
    }

    @RequestMapping(value = "/get/string", method = GET)
    public ResponseEntity<String> getString() {
        return ResponseEntity.ok(testData.get(1));
    }

    @RequestMapping(value = "/get/string/message", method = GET)
    public ResponseEntity<String> getString(@RequestParam int number) {
        if (number <= 0 || number > testData.size() - 1)
            throw new IllegalArgumentException(String.format("Number '%d' is not valid. Number is negative, zero or greater than number of records (%d).", number, testData.size()));
        return ResponseEntity.ok(testData.get(number - 1));
    }

    @RequestMapping(value = "/get/hello/{name}", method = GET)
    public ResponseEntity<String> getHelloMessage(@PathVariable String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        return ResponseEntity.ok("Say hello to " + name);
    }

    @RequestMapping(value = "/get/data", method = GET)
    public ResponseEntity<String> getMessageFromData(@RequestBody Data data) {
        return ResponseEntity.ok(String.format("Here is the first data text '%s' and second data text '%s'", data.getFirstText(), data.getSecondText()));
    }

    @RequestMapping(value = "/update/data", method = PUT)
    public ResponseEntity<String> updateData(@RequestBody Data data) {
        return ResponseEntity.ok(String.format("Data with the first data text '%s' and second data text '%s' have been updated", data.getFirstText(), data.getSecondText()));
    }

    @RequestMapping(value = "/add/data", method = POST)
    public ResponseEntity<String> addData(@RequestBody Data data) {
        return ResponseEntity.ok(String.format("Data with the first data text '%s' and second data text '%s' have been added", data.getFirstText(), data.getSecondText()));
    }

    public List<String> getTestData() {
        return Collections.unmodifiableList(testData);
    }
}
