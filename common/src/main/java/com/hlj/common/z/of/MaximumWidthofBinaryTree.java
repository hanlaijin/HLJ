package com.hlj.common.z.of;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlaijin@xiaomi.com on 18-8-3.
 */
public class MaximumWidthofBinaryTree {
    public static void main(String[] args) {
    //1,3,2,5,3,null,9
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = null;
        node2.right = node5;
        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        int count = 0;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (true) {
            int length = list.size();
            List<TreeNode> o = new ArrayList<>();
            int start = 0, end = 0;
            boolean first = true;
            for (int i = 0; i < length; i++) {
                TreeNode node = list.get(i);
                if (node != null) {
                    if (first) {
                        start = i + 1;
                        first = false;
                    }
                    end = i + 1;
                }
                o.add(node != null ? node.left : null);
                o.add(node != null ? node.right : null);
            }
            System.out.println(start + " " + end);
            int temp = end - start + 1;
            if (temp > count) {
                count = temp;
            }
            if (end == 0 && start ==0) {
                break;
            }
            list = o;
        }
        return count;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
