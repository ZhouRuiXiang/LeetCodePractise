package com.leetcode.array.climb_statirs;

/**
 * @author BlueStar
 * @date 2021/5/25 8:56
 * @Description: Climb stairs
 */
public class Solution {
    public static void main(String[] args) {
        int nums = climbStairs2(6);
        System.out.println(nums);
    }


    public static int climbStairs(int n) {
        // 第一层楼梯 f(1) = 1
        // 第二层楼梯 f(2) = 2
        if (n == 1){
            return 1;
        }
        if (n <= 0){
            return -1;
        }
        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;

        for (int i = 2; i < stairs.length; i++) {
            stairs[i] = stairs[i -1 ] + stairs[i - 2];
        }
        return stairs[n - 1];

    }

    public static int climbStairs2(int n){
        // 空间优化 数组 -> 滚动数组
        if (n == 1){
            return 1;
        }
        if (n <= 0){
            return -1;
        }
//        int pre = 1, cur = 2;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            //滚动数组

            int third = first + second;
            first = second;
            second = third;
//            int temp = cur;
//            cur = pre + cur;
//            pre = temp;
        }
//        return cur;
        return second;


    }
}
