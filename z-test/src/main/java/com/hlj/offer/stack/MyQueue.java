package com.hlj.offer.stack;

import java.util.Stack;

/**
 * Created by hanlaijin@xiaomi.com on 18-10-30.
 */
public class MyQueue {
    public static void main(String[] args) throws Exception {
        MyQueue queue = new MyQueue();
        for (int i=0;i<10;i++) {
            queue.push(i);
        }
        for (int i=0;i<5;i++) {
            System.out.println(queue.pop());
        }
        for (int i=10;i<15;i++) {
            queue.push(i);
        }
        for (int i=0;i<10;i++) {
            System.out.println(queue.pop());
        }
    }

    public static Stack<Integer> s1 = new Stack();
    public static Stack<Integer> s2 = new Stack();

    public void push(int num) {
        s1.push(num);
    }

    public int pop() throws Exception {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            throw new Exception("f");
        }
        return s2.pop();
    }
}
