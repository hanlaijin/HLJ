package com.hlj.common.z.thread;

import java.util.concurrent.Callable;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-8.
 */
public class CallableTest {
    public static void main(String[] args) throws Exception {
        Callable callable = () -> {
            System.out.println("begin "+ Thread.currentThread().getName());
            Thread.sleep(2000);
            return "over";
        };
        Object result = callable.call();
        System.out.println(result);
    }
}
