package com.hlj.common.z.test;

import lombok.Data;
import org.apache.commons.lang3.Validate;

/**
 * Created by hanlaijin@xiaomi.com on 18-6-1.
 */
public class MyList {
    Node head;

    MyList() {
        head = new Node(0);
    }

    public void addToHead(int data) {
        Node node = new Node(data);
        node.next = head.next;
        head.next = node;
    }

    public void addToTail(int data) {
        Node node = new Node(data);
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public static void print(Node head) {
        Validate.notNull(head, "list is null");
        Node next = head;
        while (next != null) {
            System.out.println(next.data);
            next = next.next;
        }
    }

    public static Node reverse(Node node) {
        Validate.notNull(node, "list is null");
        if (node.next == null) {
            return node;
        }
        Node current = reverse(node);
        node.next.next = node;
        node.next = null;
        return current;
    }


    public static void main(String[] args) {
        MyList list = new MyList();
        list.addToHead(2);
        list.addToHead(1);
        list.addToTail(3);
        list.addToTail(4);
        print(list.head);
        print(reverse(list.head));
    }
}

@Data
class Node {
    public Node next;
    public int data;

    Node(int data) {
        this.data = data;
    }
}