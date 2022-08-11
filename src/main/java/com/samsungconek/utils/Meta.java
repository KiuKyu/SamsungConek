package com.samsungconek.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {
    public static final Meta SUCCESS = new Meta(1);
    public static final Meta FAILURE = new Meta(2);

    @JsonProperty("code")
    int code;

    public Meta() {
        super();
    }

    public Meta(int code) {
        super();
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
