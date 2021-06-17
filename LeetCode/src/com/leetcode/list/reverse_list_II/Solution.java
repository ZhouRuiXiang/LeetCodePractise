package com.leetcode.list.reverse_list_II;

/**
 * @author BlueStar
 * @date 2021/6/16 8:32
 * @Description: reverse single list and assign the scope
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class Solution {

    public static void main(String[] args) {

//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode head = new ListNode(1, new ListNode(2, null));

        ListNode newHead = reverseBetween(head, 1, 2);
        printList(newHead);


    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置一个假的头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 假的头结点当作前驱节点 pre
        ListNode pre = dummyNode;
        // 把前驱节点指向待反转区域的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 从待反转区域开始遍历 当前节点 = 第一个待反转节点
        ListNode cur = pre.next;
        ListNode next;
        // 这个过程中 与以往 while(cur != null)的遍历方式不同
        // 循环次数固定 反转区域固定 即 right - left
        // cur的 随着头插 自然向后移动
        // cur一开始为pre.next 随后 cur.next不断插入到pre.next
        // cur 不断指向 cur.next.next
        for (int i = 0; i < right - left; i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;


    }
}


//Definition for singly-linked list.
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
