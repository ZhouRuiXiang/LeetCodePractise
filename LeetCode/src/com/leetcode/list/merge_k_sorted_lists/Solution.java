package com.leetcode.list.merge_k_sorted_lists;

import com.leetcode.array.plus_1.PlusOne;

import java.util.*;

/**
 * @author zhouruixiang
 * @date 2022/5/25 22:14
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {

        ListNode[] listNodes = new ListNode[3];

        ListNode root_1_3 = new ListNode(8, null);
        ListNode root_1_2 = new ListNode(3, root_1_3);
        ListNode root_1 = new ListNode(1, root_1_2);

        ListNode root_2_3 = new ListNode(3, null);
        ListNode root_2_2 = new ListNode(2, root_2_3);
        ListNode root_2 = new ListNode(1, root_2_2);

        ListNode root_3_3 = new ListNode(11, null);
        ListNode root_3_2 = new ListNode(10, root_3_3);
        ListNode root_3 = new ListNode(9, root_3_2);

        listNodes[0] = root_1;
        listNodes[1] = root_2;
        listNodes[2] = root_3;

        ListNode result = mergeKLists(listNodes);

        System.out.println(result);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        ListNode tail = dummyNode;

        // 指定匿名比较器 最小堆
        // 将K个有序链表的头 加入 最小堆
        Queue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));

        //priorityQueue.addAll(Arrays.asList(lists));
        for (ListNode node : lists) {
            if(node != null)
            {
                priorityQueue.add(node);
            }
        }


        // 弹出堆顶元素 加入 上一个堆顶元素的 next节点
        while (priorityQueue.size() > 0) {
            // 弹出堆顶元素
            ListNode minNode = priorityQueue.poll();
            // 结果指针 向后移动
            tail.next = minNode;
            tail = minNode;
            // 任意升序链表中的最小节点的下一个节点 不为空 则继续添加到最小堆中
            if (minNode.next != null) {
                priorityQueue.add(minNode.next);
            }

        }
        return dummyNode.next;

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

    @Override
    public String toString() {
        return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                .add("val=" + val)
                .add("next=" + next)
                .toString();
    }
}