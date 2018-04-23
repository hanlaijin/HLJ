package com.hlj.common.utils;

import com.hlj.dto.WebResponse;

/**
 * Created by hanlaijin@xiaomi.com on 17-9-25.
 */
public class WebResponseUtil {
    public static <T> WebResponse<T> success(){
        return new WebResponse<T>();
    }

    public static <T> WebResponse<T> success(T data){
        return new WebResponse<T>(data);
    }

    public static <T> WebResponse<T> error(long errorCode, String msg){
        return new WebResponse<T>(errorCode,msg);
    }
}
