package com.leetcode.binary_tree.the_maximum_depth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author BlueStar
 * @date 2021/5/23 14:09
 * @Description: The maximum depth of a binary tree
 */
@SuppressWarnings("all")
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        TreeNode f2_1 = new TreeNode(50);
        TreeNode f2_2= new TreeNode(200);
        TreeNode f3_1 = new TreeNode(25);
        TreeNode f3_2 = new TreeNode(75);
        TreeNode f3_3 = new TreeNode(150);
        TreeNode f3_4 = new TreeNode(250);
        TreeNode f4_5 = new TreeNode(125);
        TreeNode f5_10 = new TreeNode(145);
        root.left = f2_1;
        root.right = f2_2;
        f2_1.left = f3_1;
        f2_1.right = f3_2;
        f2_2.left = f3_3;
        f2_2.right =f3_4;
        f3_3.left = f4_5;
        f4_5.right = f5_10;

        int depth = maxDepthByRecursion(root);
        System.out.println(depth);

    }





    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
        要求得二叉树的深度 及求二叉树的层数
     */
    public static int maxDepth(TreeNode root) {
        // 迭代BFS
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();// 初始化装载节点的队列

        queue.offer(root);// 将根节点加入队列
        // 每一层的节点入队 遍历完成后出队
        int depth = 0;// 二叉树的深度
        while (!queue.isEmpty()){
            int size = queue.size(); // 队列的长度即每一层的节点个数
            while (size-- != 0){
                TreeNode node = queue.poll(); // 每一层的节点逐个出队
                if (node.left != null){
                    queue.offer(node.left); //下一层的结点队尾(左子节点)
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }

        return depth;
    }
    /*
        递归 BFS
     */
    public static int maxDepthByRecursion(TreeNode root){
        // 递归出口
        if (root == null){
            return 0;
        }
        return 1 + Math.max(maxDepthByRecursion(root.left), maxDepthByRecursion(root.right));

    }
}
