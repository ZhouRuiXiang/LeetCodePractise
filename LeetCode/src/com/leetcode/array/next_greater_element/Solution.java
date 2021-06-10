package com.leetcode.array.next_greater_element;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author BlueStar
 * @date 2021/6/10 12:45
 * @Description:
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        Deque<Integer> stack = new ArrayDeque<>();          // 利用栈的单调特性
        HashMap<Integer, Integer> map = new HashMap<>();    // 返回结果 key:nums1[i] value: nums2中第一个比nums[i]大的数

        for (int value : nums2) {
            while (!stack.isEmpty() && stack.peekLast() < value) { // 栈不为空 且 栈的最后一个元素 < 当前数组中的值
                map.put(stack.removeLast(), value);                // 满足条件的结果（栈顶的元素即key）
            }
            stack.addLast(value);                                  // 入栈
        }
        int[] result = new int[len1];
        for (int i = 0; i < len1; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;

    }
}
