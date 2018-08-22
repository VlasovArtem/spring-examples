package org.avlasov.springexamples.controller.controller;

import org.avlasov.springexamples.controller.exception.ControllerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created By artemvlasov on 21/08/2018
 **/
@RestController
@RequestMapping("/test/second")
public class SecondTestController {

    @RequestMapping(value = "/exception/controllerException", method = GET)
    public void testControllerExceptionHandler() throws ControllerException {
        throw new ControllerException("Controller Exception handler test from second controller");
    }

    @RequestMapping(value = "/interceptor", method = GET)
    public ResponseEntity<String> testInterceptor() {
        return ResponseEntity.ok("Interceptor test");
    }

    @ExceptionHandler(value = ControllerException.class)
    public ResponseEntity<String> controllerExceptionHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
