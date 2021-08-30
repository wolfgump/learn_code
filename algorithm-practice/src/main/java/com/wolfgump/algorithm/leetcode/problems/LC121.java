package com.wolfgump.algorithm.leetcode.problems;

/**
 * @author ShiTao.Gan
 * 121.买卖股票的最佳时机
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 * <p>
 * 动态规划问题
 * 动态转移方程：
 * k=1 固定的值
 * dp[i][k][0]=Max(dp[i-1][k][0],dp[i-1][k][1]+price[i]); dp[i][k][0] 今天未持有股票，dp[i-1][k][0] 昨天未持有股票  ,dp[i-1][k][1]+price[i] 昨天持有了股票今天卖掉了
 * dp[i][k][1]=Max(dp[i-1][k][1],dp[i-1][k][0]-price[i])；dp[i][k][1] 今天持有股票，dp[i-1][k][1] 昨天持有股票  ,dp[i-1][k][0]-price[i] 昨天未持有了股票今天买入了
 * dp[i][0][0]=0; k=0不允许买卖 利润是0 所以dp[i][k][1]=Max(dp[i-1][k][1],-price[i]);
 * 返回结果：dp[n-1][1][0]
 * base case：
 * dp[-1][0] = dp[i][0][0] = 0
 * dp[-1][1] = dp[i][0][1] = -infinity
 **/
public class LC121 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < prices.length; i++) {
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //                                k=0 dp[i-1][0]=0
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    public static int maxProfit1(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int max = maxProfit1(prices);
        System.out.println(max);
    }
}
