package com.leetcode.array.majority_element;

import java.util.Arrays;

/**
 * @author BlueStar
 * @date 2021/5/31 8:25
 * @Description: Search the majority element
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        int majE = majorityElement2(nums);
        System.out.println(majE);
    }


    public static int majorityElement(int[] nums) {
        // 排序 找中间元素 majorityE 中间必然是那个元素
        // time: O(n) = nlog(n)
        // space O(n) = n
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public static int majorityElement2(int[] nums) {
        // 摩尔投票算法（阵营拼杀算法 1V1 乱战 活着的就是winner）
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        // 随机找一个当winner
        int winner = nums[0];
        // 抵消阵营 同则加 不同则抵消（减） count = 0 寻找winner
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == winner) {
                count++;
            } else if (count == 0) {
                winner = nums[i];
                count++;
            } else { // 抵消
                count--;
            }
        }
        return winner;
    }


}
