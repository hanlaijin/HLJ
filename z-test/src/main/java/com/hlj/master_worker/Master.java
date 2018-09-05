package com.hlj.master_worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-7.
 */
public class Master {
    private ConcurrentLinkedDeque<Task> tasks = new ConcurrentLinkedDeque<>();

    private HashMap<String, Thread> workers = new HashMap();

    private ConcurrentHashMap<String, Object> rets = new ConcurrentHashMap<>();

    public Master(int size) {
        for (int i = 0; i < size; i++) {
            Worker worker = new Worker(tasks, rets);
            workers.put("worker" + i, new Thread(worker));
        }
    }

    public void submit(Task task) {
        tasks.add(task);
    }

    public void execute() {
        for (Map.Entry<String, Thread> entry : workers.entrySet()) {
            entry.getValue().start();
        }
    }

    public boolean isComplete() {
        for (Map.Entry<String, Thread> me : workers.entrySet()) {
            if (me.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    public Integer getResult() {
        Integer ret = 0;
        for (Map.Entry<String, Object> entry : rets.entrySet()) {
            ret += (int) entry.getValue();
        }
        return ret;
    }
}
