package com.hlj.master_worker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-7.
 */
public class Worker implements Runnable {

    public ConcurrentLinkedDeque<Task> tasks;

    public ConcurrentHashMap<String, Object> rets;


    public Worker(ConcurrentLinkedDeque<Task> tasks, ConcurrentHashMap<String, Object> rets) {
        this.tasks = tasks;
        this.rets = rets;
    }

    @Override
    public void run() {
        while (true) {
            Task task = tasks.poll();
            if (task == null) {
                break;
            }
            Object ret = handle(task);
            rets.put(Integer.toString(task.getId()), ret);
        }
    }

    private Object handle(Task task) {
        try {
            System.out.println(task.getId() + "---开始执行");
            Thread.sleep(1000);
            System.out.println(task.getId() + "---执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task.getPrice();
    }
}
