package com.hlj.test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hanlaijin@xiaomi.com on 18-11-26.
 */
public class ThreadLocalTest {
    public static void main(String[] args) {

        String s1 = "a";
        String s2 = "a";
        System.out.println(s1==s2);
    }
}
