package com.cloudfly.springboot.crud.utils;

import lombok.Data;

/**
 * @Author: CloudFly
 */
@Data
public class Result {

    private Integer code;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String msg, Object data) {
        this.code = 200;
        this.msg = msg;
        this.data = data;
    }

    public Result(String msg) {
        this.code = 200;
        this.msg = msg;
    }

    public Result(Object data) {
        this.code = 200;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
