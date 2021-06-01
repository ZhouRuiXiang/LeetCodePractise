package com.leetcode.array.is_one_bit_character;

/**
 * @author BlueStar
 * @date 2021/6/1 10:16
 * @Description: Determine  whether the array is a bit array
 */
public class Solution {
    public static void main(String[] args) {
        int[] bits = {1, 1, 1, 0};
        System.out.println(isOneBitCharacter(bits));
    }
    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1){
            i += ++bits[i];
//            if (bits[i] == 0){
//                i++;
//            } else {
//                i+=2;
//            }
        }
        return i == bits.length - 1;
    }
}
