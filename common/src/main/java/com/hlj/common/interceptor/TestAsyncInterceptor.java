package com.hlj.common.interceptor;

import com.hlj.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-15.
 */
@Slf4j
@Component
public class TestAsyncInterceptor implements AsyncHandlerInterceptor {
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("--------------[start {} request={}]", DateUtil.dateToStr(DateUtil.FORMAT, new Date(System.currentTimeMillis())), request.hashCode());
        log.info("--------------[thread={},{}]",Thread.currentThread().getId(),request.getSession().getId());
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("--------------[pre {} request={}]", DateUtil.dateToStr(DateUtil.FORMAT, new Date(System.currentTimeMillis())), request.hashCode());
        log.info("--------------[thread={},{}]",Thread.currentThread().getId(),request.getSession().getId());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("--------------[post {} request={}]", DateUtil.dateToStr(DateUtil.FORMAT, new Date(System.currentTimeMillis())), request.hashCode());
        log.info("--------------[thread={},{}]",Thread.currentThread().getId(),request.getSession().getId());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("--------------[after {} request={}]", DateUtil.dateToStr(DateUtil.FORMAT, new Date(System.currentTimeMillis())), request.hashCode());
        log.info("--------------[thread={},{}]",Thread.currentThread().getId(),request.getSession().getId());
    }
}
