package com.wolfgump.algorithm.other;

/**
 * @author ShiTao.Gan
 * 动态规划问题
 * 凑零钱
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。算法的函数签名如下：
 * 比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
 **/
public class CoinChange {
    /**
     * coins 中是可选硬币面值，amount 是目标金额; coinChange(int[]coins,amount)代表凑够amount金额至少需要的硬币数量
     */
    static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        //上一次保存的结果,压缩后的dp表
        int dp = Integer.MAX_VALUE;
        for (int coin : coins) {
            //选择了coin
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            //在coins里找选择哪个coin需要的硬币最少
            dp = Math.min(dp, subProblem + 1);
        }
        return dp == Integer.MAX_VALUE ? -1 : dp;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int count = coinChange(coins, 1);
        System.out.println(count);
    }

}
