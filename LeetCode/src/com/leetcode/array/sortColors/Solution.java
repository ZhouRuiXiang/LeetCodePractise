package com.leetcode.array.sortColors;

import java.util.Arrays;

/**
 * @author BlueStar
 * @date 2021/5/30 8:25
 * @Description: 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2};
        sortColors2(nums);
        String s = Arrays.toString(nums);
        System.out.println(s);
    }


    public static void sortColors2(int[] nums) {
        // 循环不变量
        // all in [0, p0)
        // all in [p0, i)
        // all in (p2, len - 1]

        // 定义边界
        if (nums.length <= 1){
            return;
        }

        // 定义三个指针变量
        int p0 = 0, i = 0, p2 = nums.length - 1;

        while (i <= p2) {
            if (nums[i] == 0) {
                // 交换
                swap(nums, i, p0);
                i++;
                p0++;
            } else if (nums[i] == 1) {
                i++;
            } else { // nums[i] == 2
                swap(nums, i, p2);
                p2--;
                // 这里i不再自增，因为从后面换回来的数不知道是几，这里继续查看这个数，如果是2还要继续swap，直到这个数不是2 i自增
            }
        }

    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    /*
     * 快排
     * */
    public static void sortColors(int[] nums) {
        sortColors(nums, 0, nums.length - 1);

    }

    public static void sortColors(int[] nums, int left, int right) {
        // 递归出口
        if (left >= right) {
            return;
        }

        // 定义i、j两个哨兵
        int i = left, j = right;
        // 定义基准数 以数组中的第一个元素作为基准数
        int baseNum = nums[left];
        // i j 哨兵 为确保基准数正确归位（i先出动则最后找到的数可能是大的，则和基准数swap后，大的在基准数的左边，不满足条件了）
        // 所以j先出动
        while (i < j) {
            // j哨兵找比基准数小的 找到停下来
            while (nums[j] >= baseNum && i < j) {
                j--;
            }
            // i哨兵找比基准数大的，找到停下来
            while (nums[i] <= baseNum && j > i) {
                i++;
            }
            // 交换i、j哨兵对应的元素 i==j时，不交换 否则异或交换i j 会都变为0
            if (i != j) {
                nums[i] = nums[i] ^ nums[j];
                nums[j] = nums[i] ^ nums[j];
                nums[i] = nums[i] ^ nums[j];
            }

        }
        //基准数归位
        nums[left] = nums[j];
        nums[j] = baseNum;

        // 左边快排
        sortColors(nums, left, j - 1);
        // 右边快排
        sortColors(nums, j + 1, right);

    }
}
