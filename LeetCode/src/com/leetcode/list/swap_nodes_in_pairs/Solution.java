package com.leetcode.list.swap_nodes_in_pairs;

import java.util.ArrayList;

/**
 * @author BlueStar
 * @date 2021/6/12 8:48
 * @Description: swap nodes in pairs at single list
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 1 -> 2 -> 3 -> 4
 * 2 -> 1 -> 4 -> 3
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 */
public class Solution {
    public static void main(String[] args) {

        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        ListNode root = new ListNode();
        ListNode res = swapPairs(root);
        System.out.println(res.val);
        System.out.println(res.next.val);
        System.out.println(res.next.next.val);
        System.out.println(res.next.next.next.val);

    }
    public static ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        if (head != null && head.next != null){
            head = head.next;
        } else {
            return head;
        }
        while (cur != null && cur.next != null){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            if (pre != null){
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

