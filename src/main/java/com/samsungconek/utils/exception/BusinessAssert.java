package com.samsungconek.utils.exception;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

public class BusinessAssert {
    public static void isTrue(boolean expression, String code, String message) {
        if (!expression) {
            throw new BusinessException(code, message);
        }
    }

    public static void isTrue(boolean expression, String message) {
        isTrue(expression, BusinessExceptionCode.INVALID_PARAM, message);
    }

    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    public static void notTrue(boolean expression, String code, String message) {
        if (expression) {
            throw new BusinessException(code, message);
        }
    }

    public static void notTrue(boolean expression, String message) {
        notTrue(expression, BusinessExceptionCode.INVALID_PARAM, message);
    }

    public static void notTrue(boolean expression) {
        notTrue(expression, "[Assertion failed] - this expression must not be true");
    }

    public static void notNull(Object object, String code, String message) {
        if (object == null) {
            throw new BusinessException(code, message);
        }
    }

    public static void notNull(Object object, String message) {
        notNull(object, BusinessExceptionCode.INVALID_PARAM, message);
    }

    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] - Object must not be null");
    }
    public static void notEmptyText(Object object, String code, String message) {
        isTrue(!StringUtils.isEmpty(object), code, message);
    }

    public static void notEmptyText(Object object, String message) {
        notEmptyText(object, BusinessExceptionCode.INVALID_PARAM, message);
    }

    public static void notEmptyText(Object object) {
        notEmptyText(object, "[Assertion failed] - String must not be empty");
    }

    public static void notEmpty(Collection<?> collection, String code, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BusinessException(code, message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        notEmpty(collection, BusinessExceptionCode.INVALID_PARAM, message);
    }

    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 entry");
    }

    public static void notEmpty(Map<?, ?> map, String code, String message) {
        if (CollectionUtils.isEmpty(map)) {
            throw new BusinessException(code, message);
        }
    }

    public static void notEmpty(Map<?, ?> map, String message) {
        notEmpty(map, BusinessExceptionCode.INVALID_PARAM, message);
    }

    public static void notEmpty(Map<?, ?> map) {
        notEmpty(map, "[Assertion failed] - this collection must not be empty: it must contain at least 1 entry");
    }

    public static void contain(Collection<?> collection, Object object, String code, String message) {
        if (collection == null || collection.isEmpty() || object == null || !collection.contains(object)) {
            throw new BusinessException(code, message);
        }
    }

    public static void contain(Collection<?> collection, Object object, String message) {
        contain(collection, object, BusinessExceptionCode.INVALID_PARAM, message);
    }

    public static void contain(Collection<?> collection, Object object) {
        contain(collection, object, "[Assertion failed] - this collection must not be empty. It must be given object");
    }

    public static void equals(String expected, String actual, String code, String message) {
        if (expected == null && actual == null)
            return;
        if (expected != null && expected.equals(actual))
            return;
        throw new BusinessException(code, message);
    }

    public static void equals(String expected, String actual, String message) {
        equals(expected, actual, BusinessExceptionCode.INVALID_PARAM, message);
    }

    public static void equals(String expected, String actual) {
        equals(expected, actual, "[Assertion failed] - expected string not equals to actual string");
    }

    public static void equals(Object expected, Object actual, String message, String code) {
        if (expected == null && actual == null)
            return;
        if (expected != null && expected.equals(actual))
            return;
        throw new BusinessException(code, message);
    }

    public static void equals(Object expected, Object actual, String message) {
        equals(expected, actual, BusinessExceptionCode.INVALID_PARAM, message);
    }

    public static void equals(Object expected, Object actual) {
        equals(expected, actual, "[Assertion failed] - expected object not equals to actual object");
    }
}
