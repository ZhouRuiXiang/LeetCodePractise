package com.leetcode.array.remove_duplicate_num;

/**
 * @author BlueStar
 * @date 2021/5/21 18:38
 * @Description: Remove duplicates in an ordered array
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        // 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
        //不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

        // 双指针标记法
        // i指针在前标记不重复num j指针++寻找重复元素
        int length = nums.length;
        // 数组为空时 返回0
        if (length == 0){
            return 0;
        }

        int i = 1; // i指针表示数组下一个不重复元素的索引
        for (int j = 1; j < nums.length; j++) { // j指针表示数组遍历的索引
            if (nums[j] != nums[j - 1]){
                nums[i] = nums[j];
                i++;
            }
        }

        return i;


    }
}
