package org.avlasov.springexamples.controller.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created By artemvlasov on 22/08/2018
 **/
public class ControllerHandlerInterceptor implements HandlerInterceptor {

    private final static Logger LOGGER = LogManager.getLogger(ControllerHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getPathInfo().equals("/test/second/interceptor")) {
            LOGGER.info("PreHandle for the request " + request.getMethod() + " and URI " + request.getRequestURI());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (request.getPathInfo().equals("/test/second/interceptor")) {
            LOGGER.info("PostHandle for the request " + request.getMethod() + " and URI " + request.getRequestURI());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (request.getPathInfo().equals("/test/second/interceptor")) {
            LOGGER.info("AfterCompletion for the request " + request.getMethod() + " and URI " + request.getRequestURI());
        }
    }
}
