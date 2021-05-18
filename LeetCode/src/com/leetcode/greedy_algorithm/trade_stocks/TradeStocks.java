package com.leetcode.greedy_algorithm.trade_stocks;

public class TradeStocks {

    public static void main(String[] args) {
        /*

        122. 买卖股票的最佳时机 II
        给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。

        设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

        注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

         */
        int[] arr = {100 , 200 , 300, 200, 100, 50, 500};
        int maxProfit = maxProfit(arr);
        System.out.println(maxProfit);

    }


    // 贪心算法

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
}