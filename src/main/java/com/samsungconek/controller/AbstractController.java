package com.samsungconek.controller;

import com.samsungconek.config.security.SecurityContextHelper;
import com.samsungconek.utils.Envelope;
import com.samsungconek.utils.UserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final UserLogin getUserLogin() {
        return SecurityContextHelper.getCurrentUser();
    }

    protected final ResponseEntity<?> getResponseEntity(Object data) {
        return new Envelope(data).toResponseEntity(HttpStatus.OK);
    }
}
