package com.leetcode.array.remove_element;

import java.util.Arrays;

/**
 * @author BlueStar
 * @date 2021/6/9 8:52
 * @Description: Deletes an element in an array equal to the given value（删除数组中等于给定值的元素）
 * 注意：返回值顺序不限制，返回的只是引用，并不需要移动数组
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class Solution {
    public static void main(String[] args) {
//        int[] arr = {4, 2, 2, 2, 3, 1, 5, 8};
        int[] arr = {0,1,2,2,3,0,4,2};
        int count = removeElement(arr, 2);
        System.out.println(count);
        System.out.println(Arrays.toString(arr));

    }


    public static int removeElement(int[] nums, int val){
        // 返回的数组有效长度
        int count = nums.length;
        // 数组尾部定义一个指针
        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {
            if (nums[i] == val){
                swap(nums, i, j);
                j--;
                i--;
                count--;
            }
        }
        return count;
}
    // 交换数组中的两个值
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
