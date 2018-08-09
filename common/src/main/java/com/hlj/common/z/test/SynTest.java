package com.hlj.common.z.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-4.
 */
public class SynTest {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            syncAdd(i);
        }
        System.out.println("synchronized cost = " + (System.currentTimeMillis() - s)); //17s

        long r = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            reentrantAdd(i);
        }
        System.out.println("reentrantLock cost = " + (System.currentTimeMillis() - r)); //15s

        long j = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            atomicAdd(i);
        }
        System.out.println("j cost = " + (System.currentTimeMillis() - j)); //14s
    }

    public static synchronized int syncAdd(int i) {
        return i++;
    }

    public static int reentrantAdd(int i) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            i++;

        } finally {
            lock.unlock();
        }
        return i;
    }

    public static int atomicAdd(int i) {
        AtomicInteger integer = new AtomicInteger(i);
        return integer.incrementAndGet();
    }
}
