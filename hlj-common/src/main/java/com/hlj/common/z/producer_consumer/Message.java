package com.hlj.common.z.producer_consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-7.
 */
public class Message {
    private static BlockingQueue<Message> queue = new ArrayBlockingQueue<>(8);
    private String message;
    private static AtomicInteger atomicInteger = new AtomicInteger();

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static Message newMessage() {
        return new Message("消息" + atomicInteger.incrementAndGet());
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Producer producer1 = new Producer(queue);
        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer = new Consumer(queue);
        pool.execute(producer1);
        pool.execute(producer);
        pool.execute(consumer1);
        pool.execute(consumer);
    }
}
