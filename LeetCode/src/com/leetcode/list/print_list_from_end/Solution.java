package com.leetcode.list.print_list_from_end;

import java.util.Arrays;

/**
 * @author BlueStar
 * @date 2021/6/15 8:51
 * @Description: 将链表中的元素从后往前放入一个数组中,从尾到头打印一个链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Solution {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
//        ListNode root = null;
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        root.next = a;
        a.next = b;

        int[] result = reversePrint(root);
        System.out.println(Arrays.toString(result));

    }


    public static int[] reversePrint(ListNode head) {
        int length = 0;  // 数组长度,
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            length++;
        }
        int[] result = new int[length];
        int i = length - 1;
        cur = head;
        while (cur != null){
            result[i] = cur.val;
            cur = cur.next;
            i--;
        }
        return result;
    }
}


class ListNode {
    //Definition for singly-linked list.
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
