package com.hlj.offer.queue;

import java.util.Stack;

/**
 * Created by hanlaijin@xiaomi.com on 18-11-9.
 */
public class StackToQueue {
    private static Stack s1 = new Stack();
    private static Stack s2 = new Stack();

    public void push(Object o) {
        s1.push(o);
    }

    public Object pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            System.out.println("error");
            return null;
        }
        return s2.pop();
    }
}
