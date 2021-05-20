package com.leetcode.array.xor;

/**
 * @author BlueStar
 * @date 2021/5/18 19:04
 * @Description:
 */
public class ArrayXor {
    public static void main(String[] args) {
        int result = xorOperation(10, 5);
        System.out.println(result);
    }

    public static int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = start + 2*i;
            result ^= nums[i];
        }
        return result;

    }
}
