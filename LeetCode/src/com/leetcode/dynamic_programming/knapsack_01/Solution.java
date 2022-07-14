package com.leetcode.dynamic_programming.knapsack_01;

/**
 * @author zrx
 * @date 2022/7/11 11:01 AM
 * 01背包问题
 * 已知有N个物品，容量为V的背包，每件物品有且仅有1件，每件物品的质量为w[i-1]，价值为c[i-1]
 * 请问背包在容量范围内，如何装才能达到最大价值
 */
public class Solution {
    private static final int N = 6;
    private static final int V = 9;

    public static void main(String[] args) {
        System.out.println(knapsack(5, 8, new int[]{3, 5, 1, 2, 2}, new int[]{4, 5, 2, 1, 3}));
    }

    /**
     * 思路：状态转移方程
     * 1. max(c[i-1] + dp[i-1][v-w[i-1]], dp[i-1][v]) 容量够（装或者不装）
     * 2. dp[i-1][v]                              容量不够（不装）
     * @param n 物品数
     * @param v 背包容量
     * @param w 物品质量 数组
     * @param c 物品价值 数组
     */
    private static int knapsack(int n, int v, int[] w, int[] c){
        if (n <= 0 || v <= 0) {
            return -1;
        }
        int[][] dp = new int[N][V];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= v; j++) {
                if (j >= w[i-1]) {
                    dp[i][j] = Math.max(c[i-1] + dp[i-1][j-w[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][v];
    }

}
