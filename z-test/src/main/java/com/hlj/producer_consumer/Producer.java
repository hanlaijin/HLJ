package com.hlj.producer_consumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-7.
 */
public class Producer implements Runnable {
    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Message message = Message.newMessage();
            try {
                queue.put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " offer message" + message.getMessage());

        }
    }
}
