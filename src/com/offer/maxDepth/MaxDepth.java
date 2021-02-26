package com.offer.maxDepth;

import sun.reflect.LangReflectAccess;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
   @author: xiaohan2021
   @description: 剑指offer55-Ⅰ:输入一棵二叉树的根节点，求该树的深度。
            从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
   @create: 2021-02-26-20:27 
*/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        } else {
            return 0;
        }
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth++;
        }
        return depth;
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
