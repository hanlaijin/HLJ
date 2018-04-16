package com.hlj.common.dto;

import lombok.Data;

@Data
public class ResponseDto<T> {
    private int code;
    private String msg;
    private T data;
    private PageDto page;

    public ResponseDto() {
        this.code = 200;
        this.msg = "success";
    }

    public ResponseDto(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseDto(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    public ResponseDto(T data, PageDto pageDto) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
        this.page = pageDto;
    }
}