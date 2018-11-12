package com.hlj.common.aop;

import com.hlj.common.dtos.response.Response;
import com.hlj.common.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hanlaijin@xiaomi.com on 18-9-29.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response exception(HttpServletRequest request, Exception e) {
        String uri = request.getRequestURI();
        log.error("--------------cat exception . uri={}", uri, e);
        return ResponseUtil.error(-1, e.getMessage());
    }
}
