package com.hlj.offer.list;

/**
 * Created by hanlaijin@xiaomi.com on 18-10-25.
 */
public class MyList {

    public void addToTail(Node head, int val) {
        Node cur = new Node(val);
        if (head == null) {
            head = cur;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = cur;
        }
    }

    public Node removeByVal(Node head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            head = head.next;
        }
        Node cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null && cur.next.val == val) {
            cur.next = cur.next.next;
        }
        return head;
    }

    public Node removeByNode(Node head, Node toDelete) {
        if (head == null || toDelete == null) {
            return head;
        }
        if (toDelete.next != null) {
            toDelete.val = toDelete.next.val;
            toDelete.next = toDelete.next.next;
        } else if (toDelete == head) {
            head = null;
            return head;
        } else {
            Node temp = head;
            while (temp.next != toDelete) {
                temp = temp.next;
            }
            temp.next = null;
        }
        return head;
    }

    public int getLastKNode(Node head, int k) {
        if (head == null || k < 0) {
            return -1;
        }
        Node temp = head;
        for (int i = 0; i < k - 1; i++) {
            if (temp != null) {
                temp = temp.next;
            } else {
                return -1;
            }
        }
        Node result = head;
        while (temp.next != null) {
            temp = temp.next;
            result = result.next;
        }
        return result.val;
    }

    public void printReverse(Node head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.val + " ");
    }

    public Node reverze(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = head;
        pre.next = null;
        Node cur = head.next;
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head = pre;
        return head;
    }
}

