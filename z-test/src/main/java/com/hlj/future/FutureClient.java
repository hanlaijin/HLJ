package com.hlj.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-5.
 */
public class FutureClient {
    public Data getDataClient() {
        FutureData data = new FutureData();
        new Thread(() -> {
            RealData realData = new RealData();
            data.set(realData);
        }).start();
        return data;
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            pool.submit(() -> System.out.println(new FutureClient().getDataClient().getData()));
        }
    }
}
