package com.leetcode.array.max_sub_array;

import java.util.Arrays;

/**
 * @author BlueStar
 * @date 2021/6/7 9:22
 * @Description: Get the max sub array
 *
 * 面试题 16.17. 连续数列
 *
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int maxSum = Status.maxSubArray3(arr);
        System.out.println(maxSum);
    }

    /*
        动态规划
     */
    public static int maxSubArray(int[] nums) {
        // 维护一个保存 nums[i] + nums[i - 1]的变量
        if (nums.length == 0){
            return 0;
        }
        int pre = 0, maxSum = nums[0];
        for (int num : nums) {
            pre = Math.max(num, num + pre); // 当前值 compare 当前值+前一个值 大的留 小的丢弃 即要么从当前num开始 要么从 num + pre 开始
            maxSum = Math.max(maxSum, pre); // maxSum 只保留历史最大值

        }
        return maxSum;
    }

    /*
        贪心
     */

    public static int maxSubArray2(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            // 前一个数为正数才相加，否则丢弃
            if (nums[ i - 1] > 0){
                nums[i] += nums[i - 1];
            }
        }
        Arrays.sort(nums);
        return nums[nums.length - 1];

    }
    /*
        分治思想（线段树）
     */
    static class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }

        public static int maxSubArray3(int[] nums) {
            return getInfo(nums, 0, nums.length - 1).mSum;
        }

        public static Status getInfo(int[] a, int l, int r) {
            if (l == r) {
                return new Status(a[l], a[l], a[l], a[l]);
            }
            int m = (l + r) >> 1;
            Status lSub = getInfo(a, l, m);
            Status rSub = getInfo(a, m + 1, r);
            return pushUp(lSub, rSub);
        }

        public static Status pushUp(Status l, Status r) {
            int iSum = l.iSum + r.iSum;
            int lSum = Math.max(l.lSum, l.iSum + r.lSum);
            int rSum = Math.max(r.rSum, r.iSum + l.rSum);
            int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
            return new Status(lSum, rSum, mSum, iSum);
        }



    }
}
