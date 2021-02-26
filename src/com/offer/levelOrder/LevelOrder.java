package com.offer.levelOrder;

import com.sun.media.sound.RIFFInvalidDataException;
import sun.reflect.generics.tree.Tree;

import java.util.*;


public class LevelOrder {
    /*
   @author: xiaohan2021
   @description: 剑指offer32：从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
   @create: 2021-02-25-17:31
    */
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

    /*
   @author: xiaohan2021
   @description: 剑指offer32：从上到下打印出二叉树的每个节点，
                        同一层的节点按照从左到右的顺序打印，并打印到一行。
   @create: 2021-02-26-14:31
    */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) { // 先求队列长度，避免了出队列后队列长度的变化。
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    /*
   @author: xiaohan2021
   @description: 剑指offer32：从上到下打印出二叉树的每个节点，同一层的节点打印到一行。
                        偶数层按照从左到右的顺序打印 奇数层按照从右往左打印。

   @create: 2021-02-26-14:31
    */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) { // 先求队列长度，避免了出队列后队列长度的变化。
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            if (res.size() % 2 == 1) Collections.reverse(list);
            res.add(list);
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
