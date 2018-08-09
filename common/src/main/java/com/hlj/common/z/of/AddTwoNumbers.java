package com.hlj.common.z.of;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-1.
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);
        l1.addToTail(8);
        ListNode l2 = new ListNode(0);
        System.out.println(l1 + "," + l2);
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int count = 0;
        ListNode p = l1, q = l2, c = result;
        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = count + x + y;
            count = sum / 10;
            ListNode node = new ListNode(sum % 10);
            c.next = node;
            c = c.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (count == 1) {
            c.next = new ListNode(count);
        }
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode addToTail(int x) {
        ListNode node = new ListNode(x);
        if (next == null) {
            next = node;
            return node;
        }
        ListNode c = next;
        while (c.next != null) {
            c = c.next;
        }
        c.next = node;
        return c;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}