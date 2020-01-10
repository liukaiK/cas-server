package com.unicom.smartcity.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * clientId错误 数据库中没有该client
 *
 * @author liukai
 */
public class BadClientIdException extends AuthenticationException {

    public BadClientIdException(String msg) {
        super(msg);
    }

}
