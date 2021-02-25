package com.offer.levelOrder;

import com.sun.media.sound.RIFFInvalidDataException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
   @author: xiaohan2021
   @description: 剑指offer32：从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
   @create: 2021-02-25-17:31 
*/public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if (root == null ) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (! queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) { queue.add(node.left); }
            if (node.right != null) { queue.add(node.right); }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
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
