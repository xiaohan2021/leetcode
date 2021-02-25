package com.offer.buildTree;
/*
   @author: xiaohan2021
   @description: 剑指offer07：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
                 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
   @知识点复习：
    前序遍历性质： 节点按照 [ 根节点 | 左子树 | 右子树 ] 排序。
    中序遍历性质： 节点按照 [ 左子树 | 根节点 | 右子树 ] 排序。
    根据以上性质，可得出以下推论：
        ①前序遍历的首元素 为 树的根节点 node 的值。
        ②在中序遍历中搜索根节点 node 的索引 ，可将 中序遍历 划分为 [ 左子树 | 根节点 | 右子树 ] 。
        ③根据中序遍历中的左 / 右子树的节点数量，可将 前序遍历 划分为 [ 根节点 | 左子树 | 右子树 ] 。

    以上子树的递推性质是 分治算法 的体现，考虑通过递归对所有子树进行划分。
    分治算法解析：
    1、递推参数：根节点在前序遍历的索引 root 、子树在中序遍历的左边界 left 、子树在中序遍历的右边界 right ；
    2、终止条件： 当 left > right ，代表已经越过叶节点，此时返回 nullnull ；
    3、递推工作：
        ①建立根节点 node ： 节点值为 preorder[root] ；
        ②划分左右子树： 查找根节点在中序遍历 inorder 中的索引 i ；
        ③为了提升效率，使用哈希表 map 存储中序遍历的值与索引的映射，查找操作的时间复杂度为 O(1)
    4、构建左右子树： 开启左右子树递归；
                    根节点索引	         中序遍历左边界	中序遍历右边界
     左子树	     root + 1	                left	        i - 1
     右子树	    i - left + root + 1	        i + 1	        right
      注解：i - left + root + 1含义为 根节点索引 + 左子树长度 + 1
    5、返回值： 回溯返回 node ，作为上一层递归中根节点的左 / 右子节点；

   @create: 2021-02-24-14:13 
*/

import java.util.HashMap;

public class BuildTree {
    int[] preOrder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        this.preOrder = preOrder;
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return recursion(0, 0, inOrder.length - 1);
    }

    public TreeNode recursion(int root, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preOrder[root]);
        int i = map.get(preOrder[root]);
        node.left = recursion(root + 1, left, i - 1);
        node.right = recursion(root + i - left + 1, i + 1, right);
        return node;
    }


    public static void main(String[] args) {
        int[] preOrder = {3, 9, 20, 15, 7};
        int[] inOrder = {9, 3, 15, 20, 7};

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
