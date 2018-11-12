package com.hlj.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloHandler implements InvocationHandler {
    Object target;

    HelloHandler(Object hello) {
        this.target = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = method.invoke(target, args);
        System.out.println("after");
        return result;
    }

    public Object getInstince() {
        Class clazz = target.getClass();
        Object obj = Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
        return obj;
    }

    public static void main(String[] args) {
        HelloHandler handler = new HelloHandler(new HelloImpl());
        Hello hello = (Hello) handler.getInstince();
        hello.hello();
        hello.world();
    }
}