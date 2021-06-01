package com.leetcode.array.repeat_element;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author BlueStar
 * @date 2021/6/1 9:18
 * @Description: Whether the array has duplicate elements
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        boolean flag = containsDuplicate(nums);
        System.out.println(flag);
    }

    public static boolean containsDuplicate(int[] nums) {
        // time: O(n)   space: O(n) 哈希表
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }
        return false;
    }






}
