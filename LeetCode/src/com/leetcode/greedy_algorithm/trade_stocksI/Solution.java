package com.leetcode.greedy_algorithm.trade_stocksI;

/**
 * @author BlueStar
 * @date 2021/6/5 9:22
 * @Description: trade stocks at the suitable chance
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个  算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：5
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices){
        int length = prices.length;
        if (length < 2){
            return 0;
        }
        // 股票的最低点
        int minPrice = Integer.MAX_VALUE;

        int result = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > result) {
                result = price - minPrice;
            }
        }
        return result;
    }

}
