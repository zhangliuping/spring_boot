package com.aug.demo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.aug.demo.common.ErrorInfo;
import com.aug.demo.exception.ServiceException;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView defaultRuntimeExceptionHandler(HttpServletRequest req, RuntimeException e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = ServiceException.class)
    public ErrorInfo<String> serviceExceptionHandler(HttpServletRequest req, RuntimeException e) throws Exception {
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMessage(e.getMessage());
        errorInfo.setCode(HttpStatus.BAD_REQUEST.value());
        errorInfo.setData("Bad request for serviceException. " + e.getMessage());
        errorInfo.setUrl(req.getRequestURL().toString());
        return errorInfo;
    }
}
