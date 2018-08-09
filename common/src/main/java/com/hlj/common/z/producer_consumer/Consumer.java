package com.hlj.common.z.producer_consumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-7.
 */
public class Consumer implements Runnable {
    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Message message = null;
            try {
                message = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " take message" + message.getMessage());
        }
    }
}
