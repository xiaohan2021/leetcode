package com.offer.isSymmetric;

/*
   @author: xiaohan2021
   @description: 请实现一个函数，用来判断一棵二叉树是不是对称的。
                如果一棵二叉树和它的镜像一样，那么它是对称的
   @create: 2021-02-25-15:07 
*/

import com.sun.deploy.net.proxy.RemoveCommentReader;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recursion(root.left, root.right);
    }

    public boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recursion(left.left, right.right) && recursion(left.right, right.left);
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
