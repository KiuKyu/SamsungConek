package com.samsungconek.utils.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -6127762932224120122L;

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessException.class);

    private String code;

    public BusinessException() {
    }

    public BusinessException(String code) {
        this(code, null);
    }

    public BusinessException(String code, String message) {
        this(code, message, null);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        LOGGER.debug(String.format("BusinessException(code=[%s], message=[%s])", code, message), cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
