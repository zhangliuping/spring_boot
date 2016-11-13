package com.aug.demo.common;

import org.springframework.http.HttpStatus;

public class ErrorInfo<T> {

    public static final int OK = HttpStatus.OK.value();

    private int code;
    private String message;
    private String url;
    private T data;

    public ErrorInfo() {
        code = HttpStatus.NO_CONTENT.value();
        message = HttpStatus.NO_CONTENT.getReasonPhrase();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
