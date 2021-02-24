package com.offer.isSubStructure;
/*
   @author: xiaohan2021
   @description: 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
                B是A的子结构， 即 A中有出现和B相同的结构和节点值
   @思路：
    1、首先是DFS找到A中值跟B根节点值一样的结点C
    2、找到后判断B是否为C的子树（必须包含C的根节点），此时由于B与C的根节点一样，我们就很好判断
    3、如果满足子子树的条件，我们就立刻返回
    4、不满足的话，因为A中值与B根节点值相等的结点可能有多个，所以继续dfsA中的其他结点
   @create: 2021-02-24-16:16 
*/

public class IsSubStructure {
    boolean res = false;
    public boolean isSubStructure(TreeNode A, TreeNode B){
        // 规定：空树不是任何一个树的子结构，返回false
        if (A == null || B == null ){
            return false;
        }
        // 遍历A树, 寻找与B树根结点相同的结点
        dfs(A, B);
        return res;
    }

    /**
     * dfs遍历 A 树结点， 寻找与 B 根结点值相同的结点
     * @param a
     * @param b
     */
    private void dfs(TreeNode a, TreeNode b) {
        if (a == null) {
            return;
        }
        if (a.val == b.val) {
            /**
             * 找到相同的结点后，判断以该结点为子树的树结构与B树结构是否一致
             */
            if(isSubTree(a, b)){
                res = true;
                return;
            }
        }
        // 未找到相同结点，继续dfs遍历
        dfs(a.left, b);
        dfs(a.right, b);
    }

    /**
     * 判断B树是否为A的子树
     * @param a
     * @param b
     * @return
     */
    public boolean isSubTree(TreeNode a, TreeNode b) {
        if (a == null && b != null){
            return false;
        }
        if (a != null && b == null){
            return true;
        }
        if (a == null && b == null){
            return true;
        }
        return a.val == b.val && isSubTree(a.left, b.left) && isSubTree(a.right, b.right);
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
