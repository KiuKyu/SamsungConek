package com.samsungconek.utils;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class ResponseHandler {
    private String message;
    private int code;
    private Object data;

    public ResponseHandler(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public ResponseHandler(String message, int code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setIterable(Iterable<Object> iteratedData) {
        this.data = iteratedData;
    }
}
