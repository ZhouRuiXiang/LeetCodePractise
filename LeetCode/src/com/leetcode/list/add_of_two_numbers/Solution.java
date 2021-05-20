package com.leetcode.list.add_of_two_numbers;

import com.leetcode.list.reverseList.ReverseList;

/**
 * @author BlueStar
 * @date 2021/5/20 8:35
 * @Description: Add of two numbers
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(2, new ListNode(3, null)));
        ListNode l2 = new ListNode(1, new ListNode(2, new ListNode(1, null)));


        ListNode newL = addTwoNumbers(l1, l2);
        printList(newL);

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

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 防止当前节点赋值产生空指针异常 定义一个伪的头节点(前驱节点)
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        // 维护一个进位变量
        int t = 0;
        // 两个链表的都为空 且 t != 0 循环结束
        while (l1 != null || l2 != null || t != 0){

            if (l1 != null){
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                t += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t /= 10;

        }
        return dummyHead.next;

    }


}
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

