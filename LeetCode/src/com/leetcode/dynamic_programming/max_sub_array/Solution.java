package com.leetcode.dynamic_programming.max_sub_array;

/**
 * @author BlueStar
 * @date 2021/5/27 8:44
 * @Description: Get the max sub array
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2};
        int subSum = maxSubArray(nums);
        System.out.println(subSum);

    }

    public static int maxSubArray(int[] nums) {
        // 状态转移方程 dp[i] = Math.max(dp[i-1] + nums[i], nums[i])
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < length; i++) { // dp[i-1] 防止下标越界 下标从1开始
            // 当前值+上一个值之后比较当前值,查看是否产生负增益
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return Math.max(dp[0], result);

    }
}
