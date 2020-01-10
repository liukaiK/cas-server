package com.unicom.smartcity.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author liukai
 */
public class HttpErrorException extends AuthenticationException {

    public HttpErrorException(String msg) {
        super(msg);
    }

}
