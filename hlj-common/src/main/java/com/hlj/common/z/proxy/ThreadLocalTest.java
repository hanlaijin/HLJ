package com.hlj.common.z.proxy;


import java.net.InetAddress;

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

    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }
}
