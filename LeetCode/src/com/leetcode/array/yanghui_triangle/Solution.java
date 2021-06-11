package com.leetcode.array.yanghui_triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author BlueStar
 * @date 2021/6/11 8:54
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        int rows = 5;
        System.out.println(generate(rows));
    }

    public static List<List<Integer>> generate(int numRows) {
        // 存储 每一行的集合
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            // 每一行元素的集合
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 上一行中第j -1 个元素 + 上一行 第 j 个元素
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

}
