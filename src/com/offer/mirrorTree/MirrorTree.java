package com.offer.mirrorTree;

/*
   @author: xiaohan2021
   @description: 剑指offer27：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
   提示：交换左右结点应该从叶子结点开始，而不是从根结点开始。
   根据二叉树镜像的定义，考虑递归遍历（dfs）二叉树，交换每个结点的左 / 右子结点，即可生成二叉树的镜像。
    递归解析：
        终止条件： 当节点 root 为空时（即越过叶结点），则返回 null ；
        递推工作：
            初始化结点 node ，用于暂存 root 的左子结点；
            递归 右子结点 mirrorTree(root.right)，并将返回值作为 root 的左子结点。
            递归 左子结点 mirrorTree(node)，并将返回值作为 root 的右子结点。
            返回值： 返回当前结点 root；
   @create: 2021-02-25-12:41 
*/public class MirrorTree {
    public TreeNode mirrorTree (TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(node);
        return root;
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
