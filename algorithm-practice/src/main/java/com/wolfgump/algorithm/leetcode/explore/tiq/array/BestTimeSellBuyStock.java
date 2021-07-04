package com.wolfgump.algorithm.leetcode.explore.tiq.array;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e., max profit = 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 * <p>
 * <p>
 * 解题思路：
 * 1.给你一段历史的股票价格曲线图，怎么操作最多的收益
 * 2.历史的股票价格曲线图最明显的特点是知道波谷和波峰，每次波谷买入，波峰卖出，就能赚取最多的收益。
 * 3.怎么找到波谷和波峰，下降趋势中最低的点 上升趋势中最高的点
 */
public class BestTimeSellBuyStock {

    public static int maxProfit(int[] prices) {
        int i = 0;
        int buy = 0;
        int sell = 0;
        int profit = 0;
        while (i < prices.length-1) {
            while (i < prices.length-1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            buy = prices[i];
            while (i < prices.length-1 && prices[i + 1] > prices[i]) {
                i++;
            }
            sell = prices[i];
            profit += sell - buy;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices={7,2,3,4,5,6};
        int profit=maxProfit(prices);
        assert profit==4;
        System.out.println("success");
    }

}
