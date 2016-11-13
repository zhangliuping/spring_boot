package com.aug.demo.exception;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 6909563135767767421L;

    public ServiceException(String message) {
        super(message);
    }
}
