package com.samsungconek.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessExceptionCode {
    public static final String INVALID_PARAM = "3";
    public static final String PERMISSION_DENIED = "5";
    public static final String EMPTY_LIST = "4";
    public static final String NOT_EXIST = "6";
}
