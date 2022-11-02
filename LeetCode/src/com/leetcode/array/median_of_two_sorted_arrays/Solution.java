package com.leetcode.array.median_of_two_sorted_arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zrx
 * @date 2022/11/1 17:30
 */
public class Solution {



    public static void main(String[] args) {
        int[] arr1 = {1, 6, 8};
        int[] arr2 = {1, 3, 5};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /** 思路 合并数组 求出中位数(堆) log (m+n)
            数组length:
                偶数 index1 = nums.length / 2 - 1, index2 = nums.length / 2
                奇数 index = nums.length / 2
        */
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(nums1.length + nums2.length, Comparator.comparingInt(o -> o));
        for (int i : nums1) {
            heap.add(i);
        }
        for (int i : nums2) {
            heap.add(i);
        }

//        heap.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toCollection(PriorityQueue::new)));
        double result = 0;
        if (heap.size() % 2 == 0) {
            Integer num1 = 0;
            Integer num2 = 0;
            int index2 = heap.size() / 2 + 1;
            int index1 = heap.size() / 2;
            for (int j = 1; j <= index2; j++) {
                Integer poll = heap.poll();
                if (j == index1) {
                    num1 = poll;
                } else if (j == index2) {
                    num2 = poll;
                }
            }
            result = (double)(num1 + num2) / 2;
        } else {

            int count = heap.size() / 2 + 1;
            for (int j = 0; j < count; j++) {
                Integer poll = heap.poll();
                if (j == count - 1) {
                    result = (double)poll;
                    break;
                }
            }
        }

        return result;
    }
}
