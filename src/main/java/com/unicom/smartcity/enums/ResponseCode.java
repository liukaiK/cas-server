package com.unicom.smartcity.enums;

/**
 * 响应状态码
 *
 * @author liukai
 */
public enum ResponseCode {

    /**
     * 成功
     */
    SUCCESS(1, "成功"),

    /**
     * 参数错误 10001-19999
     */
    REQUEST_VALIDATOR_FAIL(10001, "请求参数校验失败"),


    /**
     * 认证错误 40001-49999
     */
    AUTHENTICATION_FAIL(40001, "用户名或密码错误"),
    SMS_CODE_ERROR(40002, "验证码错误"),
    UNSUPPORTED_GRANT_TYPE(40003, "无效的grant_type"),
    INVALID_SCOPE(40004, "无效的scope"),
    REQUIRE_TOKEN(40005, "请携带token访问资源"),
    INVALID_TOKEN(40006, "无效的token"),
    REST_AUTHENTICATION_FAIL(40007, "请求登录接口失败"),


    /**
     * 权限错误 50001-59999
     */
    ACCESS_DENIED(50001, "没有权限"),

    METHOD_NOT_ALLOWED(40005, "方法不允许"),


    SERVER_ERROR(50000, "服务器运行出现异常");

    private final int code;

    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
