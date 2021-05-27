package com.leetcode.str.indexOf;

/**
 * @author BlueStar
 * @date 2021/5/26 8:34
 * @Description: Implement string method, indexOf
 */
public class Solution {
    public static void main(String[] args) {
        String haystack = "aaaabba", needle = "abb";

        int index = strStr(haystack, needle);
        System.out.println(index);
    }






    public static int strStr(String haystack, String needle) {
        // 空串返回-1
        if ("".equals(needle)) return 0;

        int strLen = needle.length();
        if (haystack.length() >= needle.length()){
            for (int i = 0; i < haystack.length() - strLen + 1; i++) {
                if (needle.charAt(0) == haystack.charAt(i) &&
                        needle.equals(haystack.substring(i, i + strLen))){
                    return i;

                }
            }
        }

        return -1;
    }
}
