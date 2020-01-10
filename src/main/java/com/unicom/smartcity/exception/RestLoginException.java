package com.unicom.smartcity.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author liukai
 */
public class RestLoginException extends AuthenticationException {

    public RestLoginException(String msg) {
        super(msg);
    }

}
