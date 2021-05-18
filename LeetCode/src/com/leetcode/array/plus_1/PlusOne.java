package com.leetcode.array.plus_1;

import org.junit.Test;

import java.util.Arrays;

public class PlusOne {
    /*
    给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

    最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

    你可以假设除了整数 0 之外，这个整数不会以零开头。
    */
    @Test
    public void test(){
        int[] arr = plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(arr));
    }


    public int[] plusOne(int[] digits){
        /*
            思路: 共有三种情况
                    第一种: 个位数 + 1 即数组最后一个数 + 1               [1,2,3] -> [1,2,4]
                    第二种: 个位数 + 1 导致其他位为9的变0,不为9的 + 1      [1,2,9] -> [1,3,0]  [2,9,9] -> [3,0,0]
                    第三种: 个位数 + 1 导致所有位为0,数组新增一位数1       [9,9,9] -> [1,0,0.0]
            在数组原地操作 逐位+1 变10 则改为0 其他位继续+1 不变10则直接返回原数组
            从后往前遍历数组中每一位数, a. + 1  b. % 10  c. 判断 % 10后是否 == 0, != 0就返回原数组 否则继续遍历
            若遍历结束 则表示 数组中所有位数都进位了 即都为0 则表示出现第三种情况 数组长度 + 1, 数组第一位为1, 其他位为0
         */
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 每一位不是9
            if (digits[i] != 9) {
                // +1 直接返回
                digits[i]++;
                return digits;
            }
            // 是9 变为0
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }
}
