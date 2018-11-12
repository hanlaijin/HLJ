package com.hlj.offer.tree;

import javafx.scene.transform.Rotate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringJoiner;

/**
 * Created by hanlaijin@xiaomi.com on 18-10-11.
 */
public class Tree {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        node3.left = node7;
        node7.right = node8;
        Tree tree = new Tree();
//        System.out.println(tree.FindAllPath(root, new ArrayList<Integer>(), new ArrayList<ArrayList<Integer>>()));
        int[] p = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] m = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
//        System.out.println(tn);
    }

    // 从根到叶子节点生成的所有数字之和
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        sumNumbersCore(root, list, 0);
        int count = 0;
        for (Integer i : list) {
            count += i;
        }
        return count;
    }

    private void sumNumbersCore(TreeNode root, List<Integer> list, int num) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(num);
            return;
        }
        if (root.left != null) {
            sumNumbersCore(root.left, list, num * 10 + root.left.val);
        }
        if (root.right != null) {
            sumNumbersCore(root.right, list, num * 10 + root.right.val);
        }
    }

    // 平衡树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 树高
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return (left > right ? left : right) + 1;
    }

    // 所有叶子节点
    public void printLeaf(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        if (root.left != null) {
            printLeaf(root.left, list);
        }
        if (root.right != null) {
            printLeaf(root.right, list);
        }
    }

    // 非递归中序遍历 TODO: 18-10-22
    public void printWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() > 0 || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root);
                root = root.right;
            }
        }
    }

    // 返回所有的路径
    public ArrayList<ArrayList<Integer>> FindAllPath(TreeNode root, ArrayList<Integer> onePath, ArrayList<ArrayList<Integer>> allPaths) {
        if (root == null)
            return allPaths;
        onePath.add(root.val);
        // 如果为叶子结点，则把onePath加入到allPaths当中
        if (root.left == null && root.right == null) {
            allPaths.add(new ArrayList<Integer>(onePath));
        }
        FindAllPath(root.left, onePath, allPaths);
        FindAllPath(root.right, onePath, allPaths);
        // 这个地方可以通过画递归树来理解，无论叶子结点是左结点还是右结点，都会经过下面这一步，而且至关重要
        onePath.remove(onePath.size() - 1);
        return allPaths;
    }

    // 合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val;
        if (t1 == null) {
            val = t2.val;
        } else if (t2 == null) {
            val = t1.val;
        } else {
            val = t1.val + t2.val;
        }
        TreeNode node = new TreeNode(val);
        TreeNode left;
        TreeNode right;
        if (t1 == null) {
            left = mergeTrees(null, t2.left);
            right = mergeTrees(null, t2.right);
        } else if (t2 == null) {
            left = mergeTrees(t1.left, null);
            right = mergeTrees(t1.right, null);
        } else {
            left = mergeTrees(t1.left, t2.left);
            right = mergeTrees(t1.right, t2.right);
        }
        node.left = left;
        node.right = right;
        return node;
    }
}

