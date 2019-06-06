package com.example.demo.utils;

/**
 * @Auther: sunmingyao
 * @Date: 2018/11/23 09 55
 * @Description:
 */
public class ApiCommonResult<T> {
    public String code;
    public Boolean success = true;
    public String Message;
    public T Data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
