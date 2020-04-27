package com.unicom.smartcity.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.unicom.smartcity.enums.ResponseCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author liukai
 */
@Setter
@Getter
@ToString
public class SimpleResponse {

    /**
     * 返回状态码
     */
    private String code;

    /**
     * 返回信息描述
     */
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;


    private SimpleResponse() {

    }

    public SimpleResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static SimpleResponse success(Object object) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setResponseCode(ResponseCode.SUCCESS);
        simpleResponse.setData(object);
        return simpleResponse;
    }

    public static SimpleResponse success() {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setResponseCode(ResponseCode.SUCCESS);
        return simpleResponse;
    }

    public static SimpleResponse failure(ResponseCode responseCode) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setResponseCode(responseCode);
        return simpleResponse;
    }

    public static SimpleResponse failure(ResponseCode responseCode, Object data) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setResponseCode(responseCode);
        simpleResponse.setData(data);
        return simpleResponse;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

}
