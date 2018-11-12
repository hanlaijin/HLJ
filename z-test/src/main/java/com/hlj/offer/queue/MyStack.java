package com.hlj.offer.queue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by hanlaijin@xiaomi.com on 18-10-30.
 */
public class MyStack {

    public static void main(String[] args) throws Exception {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.pop());
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }

    public static Queue<Integer> q1 = new LinkedBlockingDeque<>();
    public static Queue<Integer> q2 = new LinkedBlockingDeque<>();

    public void push(int num) {
        if (q1.isEmpty()) {
            q2.add(num);
        } else {
            q1.add(num);
        }
    }

    public int pop() throws Exception {
        if (q1.isEmpty() && q2.isEmpty()) {
            throw new Exception("f");
        }
        if (q1.isEmpty()) {
            while (q2.size()>1) {
                q1.add(q2.poll());
            }
            return q2.poll();
        } else {
            while (q1.size()>1){
                q2.add(q1.poll());
            }
            return q1.poll();
        }
    }
}
