package edu.utn.frsr.csi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({Exception.class})
    public ModelAndView handleException(Exception ex){
        Logger logger = LoggerFactory.getLogger(SpringApplication.class);
        String error = ex.getLocalizedMessage();
        logger.error(error, ex);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", error);
        return modelAndView;
    }
}
