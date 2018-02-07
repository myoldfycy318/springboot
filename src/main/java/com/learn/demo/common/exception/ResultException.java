package com.learn.demo.common.exception;

public class ResultException extends RuntimeException {

    private Integer code;

    public ResultException(String msg) {
        super(msg);
    }

    public ResultException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
