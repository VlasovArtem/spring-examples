package org.avlasov.springexamples.controller.handler;

import org.avlasov.springexamples.controller.exception.ControllerExceptionHandlerResolverException;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created By artemvlasov on 21/08/2018
 **/
public class ControllerExceptionHandlerResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof ControllerExceptionHandlerResolverException) {
            modelAndView.setStatus(HttpStatus.TOO_MANY_REQUESTS);
            modelAndView.setViewName(ex.getMessage());
            return modelAndView;
        }
        return modelAndView;
    }

}
