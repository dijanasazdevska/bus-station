package com.example.station.model.exceptions.handler;

import org.postgresql.util.PSQLException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class StationExceptionHandler {

    @ExceptionHandler({PSQLException.class})
    public RedirectView handleSQLError(HttpServletRequest request, PSQLException ex, RedirectAttributes redirectAttributes){
       String url = request.getRequestURI();
       redirectAttributes.addAttribute("error", ex.getMessage().split(":", 4)[1].replaceAll("Where",""));
       return new RedirectView(url);
    }

}
