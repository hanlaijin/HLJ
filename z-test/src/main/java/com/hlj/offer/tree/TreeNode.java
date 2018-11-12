package com.hlj.offer.tree;

/**
 * Created by hanlaijin@xiaomi.com on 18-10-19.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val + "}";
    }
}
