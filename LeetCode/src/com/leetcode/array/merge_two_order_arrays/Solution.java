package com.leetcode.array.merge_two_order_arrays;

import java.util.Arrays;

/**
 * @author BlueStar
 * @date 2021/5/24 13:40
 * @Description: Merge two order arrays
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3, 7, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {2, 5, 6, 6, 7, 9};
        merge3(nums1, 5, nums2, 6);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {


        /*
            两个有序数组 从左至右 遍历 小的放在新数组
         */

        int[] nums = new int[m + n];
        int i = 0, j = 0; // i j分别遍历两个有序数组
        for (int k = 0; k < nums.length; k++) {
            if (i < m || j < n) {
                if (i == m) {
                    nums[k] = nums2[j];
                    j++;
                    continue;
                }
                if (j == n) {
                    nums[k] = nums1[i];
                    i++;
                    continue;
                }
                if (nums1[i] < nums2[j]) {
                    nums[k] = nums1[i];
                    i++;
                } else {
                    nums[k] = nums2[j];
                    j++;
                }
            }

        }
        nums1 = Arrays.copyOf(nums, nums.length);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m++] = nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m-- + --n; // i: 合并排序数组的指针 m: 表示遍历nums1的指针 n: 表示遍历nums2的指针

        // 遍历nums2数组
        while (n >= 0){
            // 这里必须从后往前遍历  (如果从前往后遍历 会覆盖掉nums1中的元素)
            nums1[i--] = m >= 0 && nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        System.out.println(Arrays.toString(nums1));


    }

}
