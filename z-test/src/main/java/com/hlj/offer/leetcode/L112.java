package com.hlj.offer.leetcode;

/**
 * Created by hanlaijin@xiaomi.com on 18-11-12.
 */
public class L112 {

    /**
     * 给定一个二叉树和一个目标和
     * 判断该树中是否存在根节点到叶子节点的路径
     * 这条路径上所有节点值相加等于目标和
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSumCore(root, sum, 0);
    }

    private boolean hasPathSumCore(TreeNode node, int sum, int val) {
        int cv = val + node.val;
        if (node.left == null && node.right == null) {
            return sum == cv ? true : false;
        }
        boolean left = node.left != null ? hasPathSumCore(node.left, sum, cv) : false;
        boolean right = node.right != null ? hasPathSumCore(node.right, sum, cv) : false;
        return left || right;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        System.out.println(new L112().hasPathSum(treeNode, 2));
    }
}
