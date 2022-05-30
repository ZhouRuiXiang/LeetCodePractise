package com.leetcode.double_pointer.container_with_most_water;

/**
 * @author zhouruixiang
 * @date 2022/5/30 15:31
 * @Description: 盛放最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 */
public class Solution {

    public static void main(String[] args) {
        int[] height1 = new int[]{1,8,6,2,5,4,8,3,7};
        int[] height0 = new int[]{1,2};
        int result = maxArea(height0);
        System.out.println("最大储水量为: " + result);
    }

    public static int maxArea(int[] height) {
        /*
            双指针
         */
        if (height == null || height.length <= 1){
            return 0;
        }

        int begin = 0, end = height.length - 1, result = 0;
        while (begin < end) {
            int beginHeight = height[begin];
            int endHeight = height[end];
            int area = Math.min(beginHeight, endHeight) * (end - begin);
            if (beginHeight > endHeight){
                end--;
            }
            else{
                begin++;
            }
            result = Math.max(result, area);
        }

        return result;
    }
}
