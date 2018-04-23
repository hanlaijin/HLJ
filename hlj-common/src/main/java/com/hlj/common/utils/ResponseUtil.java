package com.hlj.common.utils;

import com.hlj.common.dto.ResponseDto;

public class ResponseUtil {
    public static ResponseDto success() {
        return new ResponseDto();
    }

    public static ResponseDto success(Object o) {
        return new ResponseDto(o);
    }
}