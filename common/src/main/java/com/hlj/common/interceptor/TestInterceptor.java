package com.hlj.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-15.
 */
@Slf4j
@Component
public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("--------------[preHandle request type ={}]", request.getDispatcherType().name());
        request.setAttribute("k", "v");
        log.info("--------------[thread={},{}]", Thread.currentThread().getId(), request.getSession().getId());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("--------------[postHandle]");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("--------------[afterCompletion request type ={}]", request.getDispatcherType().name());
        log.info("--------------[thread={},{}]", Thread.currentThread().getId(), request.getSession().getId());
    }
}
