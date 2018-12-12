package com.hlj.offer.list;

/**
 * Created by hanlaijin@xiaomi.com on 18-11-9.
 */
public class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        MyList list = new MyList();
        for (int i = 1; i <= 10; i++) {
            list.addToTail(head, i);
        }
        System.out.println(head);
        System.out.println(list.getLastKNode(head,3));
    }
}
