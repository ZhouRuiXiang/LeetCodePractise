package com.leetcode.array.add_to_array_form;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author BlueStar
 * @date 2021/6/2 8:36
 * @Description: Add to array form
 *
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 */
public class Solution {
    public static void main(String[] args) {
        int[] num = {9,9,9,9,9,9,9,9,9,9};
        List<Integer> list = addToArrayForm(num, 1);
        System.out.println(list);
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        List<Integer> result = new ArrayList<>();
        int i = n - 1; // 数组num从后往前遍历（个位数->十位数->百位数）
        int carry = 0, sum;//carry 进位变量
        while (i >= 0 || k != 0){
            int x = i >= 0 ? num[i--] : 0; // x是数组num的每位
            int y = k != 0 ? k % 10 : 0; // y是k弹出的每位数

            sum = x + y + carry;

            carry = sum / 10; // 进位
            k = k / 10; // 舍去最后一位

            result.add(0, sum % 10); // 每次从头添加（不加索引，默认从尾部添加）

        }
        if (carry != 0){
            result.add(0, 1); // 最后一位加完之后，如果进位变量不为0，则增加一个1
        }
        return result;

    }


}
