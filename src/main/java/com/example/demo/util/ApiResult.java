package com.example.demo.util;

public class ApiResult {
    private int code;
    private String msg;
    private Object data;
    public ApiResult(){

    }
    public ApiResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ApiResult success(int code, String msg, Object data){
        ApiResult apiResult = new ApiResult(code,msg,data);
        return apiResult;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}