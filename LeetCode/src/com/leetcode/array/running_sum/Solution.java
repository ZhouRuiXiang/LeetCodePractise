package com.leetcode.array.running_sum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author BlueStar
 * @date 2021/5/17 17:56
 * @Description: Get running sum of one dimentional array
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 10, 1};
        runningSum(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sum += nums[i];
        }


        return nums;
    }

}
