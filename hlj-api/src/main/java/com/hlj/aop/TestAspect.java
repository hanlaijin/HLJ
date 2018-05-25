package com.hlj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by hanlaijin@xiaomi.com on 18-5-24.
 */
@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(@com.hlj.aop.AN * *(..))")
    public void aop() {
    }

    @Around("aop()")
    public Object performanceTrace(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        before(args);
        return joinPoint.proceed(args);
    }

    private void before(Object[] args) {
        System.out.println("=========================== aop replace arg[0]");
        args[0] = "hah";
    }
}
