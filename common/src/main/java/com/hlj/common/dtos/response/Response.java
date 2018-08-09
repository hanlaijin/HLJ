package com.hlj.common.dtos.response;

import lombok.Data;

@Data
public class Response<T> {
    private int code;
    private String msg;
    private T data;
    private Page page;

    public Response() {
        this.code = 200;
        this.msg = "success";
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    public Response(T data, Page page) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
        this.page = page;
    }
}