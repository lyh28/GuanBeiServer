package com.lyh.guanbei;

public class BaseResponse<T> {
    public static final int SUCCESS_CODE=0;
    public static final int FAILED_CODE=1;
    private int code;       //0代表成功  1代表失败
    private String msg;
    private T data;

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public void setSuccessCode(){
        code=SUCCESS_CODE;
    }
    public void setFailedCode(){
        code=FAILED_CODE;
    }
}
