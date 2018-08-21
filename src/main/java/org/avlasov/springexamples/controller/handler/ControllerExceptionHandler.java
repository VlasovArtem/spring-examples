package org.avlasov.springexamples.controller.handler;

import org.avlasov.springexamples.controller.exception.ControllerAdviceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created By artemvlasov on 22/07/2018
 **/
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ControllerAdviceException.class)
    private ResponseEntity controllerAdviceExceptionHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity exceptionHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity illegalArgumentExceptionHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }

}
