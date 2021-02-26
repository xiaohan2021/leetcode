package com.offer.kthLargest;

/*
   @author: xiaohan2021
   @description: 
   @create: 2021-02-26-17:35 
*/

public class KthLargest {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k-- == 0) return;
        if (k == 0) res = root.val;
        dfs(root.left);
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
