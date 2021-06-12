package com.leetcode.list.get_Kth_from_end;

import java.util.List;

/**
 * @author BlueStar
 * @date 2021/6/12 8:19
 * @Description: 获取链表中倒数第K个元素的值
 * 注意:从1开始计数, 即倒数第1个节点是尾结点
 */
public class Solution {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third =  new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        root.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        ListNode kthFromEnd = getKthFromEnd(root, 2);
        System.out.println(kthFromEnd.val);
        System.out.println(kthFromEnd.next.val);
    }


    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode i = head, j = head;      // i 指向头节点 j指向 头节点的后k个节点
        if (head == null){
            return null;
        }
        while (k != 0){
            j = j.next;
            k--;
        }
        while (j != null){
            j = j.next;
            i = i.next;
        }
        return i;
    }


}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}