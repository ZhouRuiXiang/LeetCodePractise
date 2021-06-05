package com.leetcode.array.check_if_exists;

import java.util.HashSet;

/**
 * @author BlueStar
 * @date 2021/6/5 8:23
 * @Description: Check the existence of integers and their multiples
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
