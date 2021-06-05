package com.leetcode.array.check_if_exists;

import java.util.HashSet;

/**
 * @author BlueStar
 * @date 2021/6/5 8:23
 * @Description: Check the existence of integers and their multiples
 *
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 *
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {14};
        boolean b = checkIfExist(arr);
        System.out.println(b);
    }
    public static boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int value : arr) {
            if (set.contains(value / 2) && value % 2 == 0
                    || set.contains(2 * value)) {
                return true;
            }
            set.add(value);
        }

        return false;
    }
}
