package com.leetcode.array.sum_of_two_numbers;

import java.util.Arrays;

import java.util.Hashtable;


public class SumOfTwoNums {

    public static void main(String[] args) {
        int[] arr = {1, 9, 2, 6, 9};
        int target = 8;
        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }
    /*
    private static int[] twoSum(int[] nums, int target) {
//        给定一个整数数组 nums 和一个整数目标值 target，
//        请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//        你可以按任意顺序返回答案。


        // 遍历数组 用target 减去 数组中的每一个数, 拿到的这个数存在另一个数组中
        int[] newNums = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (target - nums[i] == nums[j]){
                    newNums[0] = j;
                    newNums[1] = i;
                    break;
                }
            }
        }
        // 从遍历的第二个数开始


        return newNums;

     */

    //使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(N) 降低到 O(1)。
    //我们创建一个哈希表，对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
    public static int[] twoSum(int[] nums, int target) {
        // 初始化hashtable
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])){
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    



}
