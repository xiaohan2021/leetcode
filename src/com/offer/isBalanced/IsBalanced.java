package com.offer.isBalanced;

import java.util.LinkedList;
import java.util.Queue;

/*
   @author: xiaohan2021
   @description: 剑指offer55-Ⅱ：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
               如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
   @create: 2021-02-26-21:09 
*/public class IsBalanced {
    Queue<TreeNode> queue = new LinkedList<>();
    public boolean isBalanced(TreeNode root) {
        boolean flag = true;
        if (root == null) {
            return flag;
        }
        dfs(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Math.abs(maxDepth(node.left) - maxDepth(node.right)) > 1) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        queue.add(root);
        dfs(root.left);
        dfs(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
