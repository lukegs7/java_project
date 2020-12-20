package com.example.demo.exception;

import org.springframework.http.HttpStatus;

/**
 * 异常
 */
public enum ErrorCode {
    /* 资源未找到 */
    RESOURCE_NOT_FOUND(1001, HttpStatus.NOT_FOUND, "未找到该资源"),
    /* 请求数据格式验证失败 */
    REQUEST_VALIDATION_FAILED(1002, HttpStatus.BAD_REQUEST, "请求数据格式验证失败");
    private final int code;
    private final HttpStatus status;
    private final String message;

    ErrorCode(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.status = httpStatus;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorCode{" + "code=" + code + ", status=" + status + ", message=" + message + "}";
    }
}
