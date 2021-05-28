package com.leetcode.binary_tree.inorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BlueStar
 * @date 2021/5/28 8:33
 * @Description: Binary Tree inorder traversal
 */
public class Solution {

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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        TreeNode l1_1 = new TreeNode(50);
        TreeNode l1_2 = new TreeNode(150);
        TreeNode l2_1 = new TreeNode(25);
        TreeNode l2_2 = new TreeNode(75);
        TreeNode l2_3 = new TreeNode(125);
        TreeNode l2_4 = new TreeNode(175);
        root.left = l1_1;
        l1_1.left = l2_1;
        l1_1.right = l2_2;
        root.right = l1_2;
        l1_2.left = l2_3;
        l1_2.right = l2_4;
        List<Integer> list = inorderTraversal(root);
        System.out.println(list);



    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        // list用来存储新的节点值
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res){
        // 递归出口
        if (root == null){
            return;
        }
        // 左 左(此左即为中) 右
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }




}
