package com.hlj.common.aop;

import com.hlj.common.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-15.
 */
@Slf4j
@Aspect
@Component
public class TestAop {

    @Pointcut("execution(@com.hlj.common.annotation.NeedAOP * *(..))")
    public void aop() {
    }

    @Around("aop()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("----------------------------[aop in {}]", DateUtil.dateToStr(DateUtil.FORMAT, new Date(System.currentTimeMillis())));
        Object object = joinPoint.proceed();
        log.info("----------------------------[aop out {}]", DateUtil.dateToStr(DateUtil.FORMAT, new Date(System.currentTimeMillis())));
        return object;
    }
}
