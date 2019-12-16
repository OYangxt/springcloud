package com.neoway.springcloud.util;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * <pre>
 *     统一请求响应体
 * </pre>
 * @author 20190712713
 * @date 2019/12/16 19:00
 */
public class HttpResult<T> implements Serializable {
    private static final long serialVersionUID = 6258706481109222930L;
    /**
     * HTTP响应码，200：成功，500：失败
     */
    private String code;
    /**
     * HTTP响应描述
     */
    private String message;
    /**
     * HTTP响应数据体
     */
    private T data;

    private HttpResult(T data) {
        this(ResponseCode.success, data);
    }
    private HttpResult(ResponseCode responseCode, T data) {
        this.code = responseCode.code;
        this.message = responseCode.message;
        this.data = data;
    }
    private HttpResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> HttpResult<T> returnSuccess() {
        return new HttpResult<>(null);
    }

    public static <T> HttpResult<T> returnSuccess(T data) {
        return new HttpResult<>(data);
    }

    public static <T> HttpResult<T> returnSuccess(String message, T data) {
        return new HttpResult<>(ResponseCode.success.code,message,data);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
