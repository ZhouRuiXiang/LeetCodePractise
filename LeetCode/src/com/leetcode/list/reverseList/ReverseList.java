package com.leetcode.list.reverseList;


/**
 * @author BlueStar
 * @date 2021/5/16 20:19
 * @Description: List algorithm
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
//        ListNode head = null;
        printList(head);
        ListNode newHead = reverseListByRecursion(head);
        printList(newHead);


    }


    private static void printList(ListNode head) {
        System.out.print("[ ");
        ListNode curNode = head;
        while (curNode != null){
            System.out.print(curNode.val + " ");
            if (curNode.next == null){
                break;
            }
            curNode = curNode.next;
        }
        System.out.println("]");
    }

    public static class ListNode {
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
    public static ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static ListNode reverseListByRecursion(ListNode head){

        // 递归出口
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;

    }

}
