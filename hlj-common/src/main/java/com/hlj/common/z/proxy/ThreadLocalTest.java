package com.hlj.common.z.proxy;


/**
 * Created by hanlaijin@xiaomi.com on 18-4-26.
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal;

    public void set(Integer integer) {
        threadLocal.set(integer);
    }

    public Integer get() {
        return threadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalTest test = new ThreadLocalTest();
        System.out.println(test.get());
    }
}
