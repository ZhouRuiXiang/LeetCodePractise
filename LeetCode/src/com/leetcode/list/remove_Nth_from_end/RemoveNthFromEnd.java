package com.leetcode.list.remove_Nth_from_end;

/**
 * @author BlueStar
 * @date 2021/5/13 15:05
 * @Description: remove Nth from the end;
 */
public class RemoveNthFromEnd {

    public static void main(String[] args) {

        // [5, 4, 3, 2]
        ListNode head = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, null))));

        printList(head);
        ListNode newHead = removeNthFromEnd(head, 0);
        printList(newHead);


    }

    private static void printList(ListNode head) {
        System.out.print("[ ");
        ListNode curNode = head;
        while (true) {
            System.out.print(curNode.val + " ");
            if (curNode.next == null) {
                break;
            }
            curNode = curNode.next;
        }
        System.out.println("]");
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义两个计数器指针 p指向头 q指向0 + n
        int p = 0;
        int q = 0;
        // 定义一个当前结点 指向正数n个结点
        ListNode qNode = head;
        ListNode pNode = head;
        if (n == 0){
            throw new IllegalArgumentException("请输入一个正整数");
        }

        while (q != n) {
            if (qNode.next != null) {
                qNode = qNode.next;
                q++;
            } else {
                ListNode newHead = pNode.next;
                pNode.next = null;
                return newHead;
            }
        }
        while (qNode.next != null) {
            pNode = pNode.next;
            qNode = qNode.next;
            p++;
            q++;
        }
        ListNode nextNode = pNode.next.next;
        pNode.next.next = null;
        pNode.next = nextNode;

        return head;

    }


}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
