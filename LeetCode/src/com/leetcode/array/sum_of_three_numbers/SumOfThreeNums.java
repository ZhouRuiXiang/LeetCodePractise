package com.leetcode.array.sum_of_three_numbers;

import java.util.*;

/**
 * @author BlueStar
 * @date 2021/5/17 8:47
 * @Description: Find the sum of the three numbers in the array to be 0
 */
public class SumOfThreeNums {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {};
//        int[] nums = {0, 2, 1};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);

    }

    /**
     *
     * @param nums 传入的数组
     * @return List<List<Integer>> 列表集合 例子: [[-1, -1, 2], [-1, 0, 1]]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        /*
           给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c，
           使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
            注意：答案中不可以包含重复的三元组。
        */

        List<List<Integer>> twoDimensionalList = null;
        HashSet<List<Integer>> integerSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int zSum = -nums[i]; // zSum = -nums[i]; zSum = nums[j] + nums[k]
            for (int j = i + 1; j < nums.length; j++){
                if (map.containsKey(zSum - nums[j])){
                    ArrayList<Integer> innerList = new ArrayList<>(List.of(nums[i], zSum - nums[j], nums[j]));
                    Collections.sort(innerList);

                    integerSet.add(innerList);
                    twoDimensionalList = new ArrayList<>(integerSet);

                }
                map.put(nums[j], null);

            }
        }
        if (twoDimensionalList == null){
            return new ArrayList<>();
        }
        return twoDimensionalList;

    }
    /*
        示例 1：
            输入：nums = [-1,0,1,2,-1,-4]
            输出：[[-1,-1,2],[-1,0,1]]

            示例 2：
            输入：nums = []
            输出：[]

            示例 3：
            输入：nums = [0]
            输出：[]

            提示：
            0 <= nums.length <= 3000
            -10^5 <= nums[i] <= 10^5
     */
}


