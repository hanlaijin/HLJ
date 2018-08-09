package com.hlj.common.z.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-4.
 */
public class QueueTest {
    public static void main(String[] args) throws Exception {
        testArrayBlockingQueue();
    }

    public static void testArrayBlockingQueue() throws Exception {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        new Thread(() -> {
            T t = new T(queue);
            try {
                t.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            T t = new T(queue);
            try {
                t.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    static class T {
        ArrayBlockingQueue<Integer> queue;

        T(ArrayBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        public void put() throws InterruptedException {
            while (queue.isEmpty()) {
                queue.put(1);
                System.out.println("put one now size = " + queue.size());
            }
        }

        public void take() throws InterruptedException {
            while (!queue.isEmpty()){
                queue.take();
                System.out.println("take one now size = " + queue.size());
            }
        }
    }
}
