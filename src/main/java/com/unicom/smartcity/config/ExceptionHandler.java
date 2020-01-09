package com.unicom.smartcity.config;

//import com.king.common.SimpleResponse;
//import com.king.framework.constant.ResponseCode;
//import org.springframework.validation.BindException;
//import org.springframework.validation.FieldError;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author liukai
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandler {

//    @ExceptionHandler(RuntimeException.class)
//    public SimpleResponse runtimeException(RuntimeException exception) {
//        log.error("运行时异常:", exception);
//        return SimpleResponse.failure(ResponseCode.SERVER_ERROR, exception.getMessage());
//    }
//
//
//    @ExceptionHandler(BindException.class)
//    public SimpleResponse bindException(BindException exception) {
//        FieldError fieldError = exception.getBindingResult().getFieldError();
//        if (fieldError == null) {
//            throw new RuntimeException("校验参数出现异常");
//        }
//        log.debug("{} : {}", fieldError.getField(), fieldError.getDefaultMessage());
//        return SimpleResponse.failure(ResponseCode.REQUEST_VALIDATOR_FAIL, fieldError.getField() + " " + fieldError.getDefaultMessage());
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public SimpleResponse methodArgumentNotValidException(MethodArgumentNotValidException exception) {
//        FieldError fieldError = exception.getBindingResult().getFieldError();
//        if (fieldError == null) {
//            throw new RuntimeException("校验参数出现异常");
//        }
//        log.debug("{} : {}", fieldError.getField(), fieldError.getDefaultMessage());
//        return SimpleResponse.failure(ResponseCode.REQUEST_VALIDATOR_FAIL, fieldError.getField() + " " + fieldError.getDefaultMessage());
//    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public SimpleResponse httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
//        log.debug("不支持{}请求", exception.getMethod());
//        return SimpleResponse.failure(ResponseCode.METHOD_NOT_ALLOWED, "不支持':" + exception.getMethod() + "'请求");
//    }

}
