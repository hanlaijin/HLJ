package com.hlj.common.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by hanlaijin@xiaomi.com on 18-5-25.
 */
public class RequestUtil {
    public static <T> T getRequestDto(HttpServletRequest request, Class<T> clazz) throws Exception {
        T t = clazz.newInstance();
        for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            BeanUtils.setProperty(t, entry.getKey(), entry.getValue()[0]);
        }
        return t;
    }
}
