package com.hlj.common.utils;

import com.hlj.common.dtos.response.Response;
import com.hlj.common.enums.ResultEnum;

public class ResponseUtil {
    public static Response success() {
        return new Response();
    }

    public static Response success(Object data) {
        return  new Response(data);
    }

    public static Response error(ResultEnum error) {
        return new Response(error.getCode(), error.getMessage());
    }

    public static Response error(int code, String msg) {
        return new Response(code, msg);
    }


}