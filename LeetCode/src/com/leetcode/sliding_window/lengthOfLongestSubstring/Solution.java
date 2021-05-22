package com.leetcode.sliding_window.lengthOfLongestSubstring;

import java.util.HashMap;

/**
 * @author BlueStar
 * @date 2021/5/22 16:53
 * @Description: Get length of the longest and unduplicated substring
 */

@SuppressWarnings("all")
public class Solution {

    public static void main(String[] args) {
        // HashMap key相同会覆盖掉旧值
//        HashMap<Character, Integer> map = new HashMap<>();
//        map.put('a', 97);
//        Integer a = map.put('a', 99);
//        System.out.println(a);
//        System.out.println(map);


        String str = "abcdaefghdcd";
        int length = lengthOfLongestSubstring(str);
        System.out.println(length);

    }

    // 求出字符串中最长的不重复元素的子串
    public static int lengthOfLongestSubstring(String s) {
        // 滑动窗口法 (队列不段的移动，从左向右，直到找到满足题意的队列)

        int max = 0; // 定义一个最大值变量 记录最长的不重复元素子串的长度
        int left = 0; // 定义一个指针指向出现重复元素后的下一个字符

        // 字符串为空串的情况
        if (s.length() == 0) {
            return 0;
        }
        // hashMap 存放（字符，索引）对象
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            // 上一个子串和这个子串进行比较
            max = Math.max(max, i - left + 1); // i - left + 1 表示当前不重复子串的长度
        }


        return max;

    }



    public static int lengthOfLongestSubstring2(String s) {

        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0; // left表示出现重复元素后 不重复元素的起点（最左边）
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // left的最大值即遍历到下一个不重复元素的起点
                // （索引是从小到大的，Math.max()比较的结果即下一个不重复元素的起点）
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }


}

