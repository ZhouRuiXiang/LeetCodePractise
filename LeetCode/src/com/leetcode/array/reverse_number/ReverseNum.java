package com.leetcode.array.reverse_number;

public class ReverseNum {

    public static void main(String[] args) {
//        给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//        如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
//        假设环境不允许存储 64 位整数（有符号或无符号）。
        // int 4byte = 32bit

//        int x = 2147483412;
        int x = 214748364;
        System.out.println(reverseNum(x));
    }

    private static int reverseNum(int x){
        int result = 0;

        // 让x的值从后往前 逐位弹出 让result接收
        while (x != 0){
            // 判断溢出的问题 判断在最后一次 result计算之前
            // 即214748364 * 10
            if (result > 214748364 || result < -214748364){
                return 0;
            }
            // result 进位 x弹出最后一位数
            result = result * 10 + x % 10;
            // x弹出1位数 x/10
            x /= 10;
        }


        return result;
    }
}
