package com.wolfgump.algorithm.other;

import java.util.Arrays;

/**
 * @author ShiTao.Gan
 * 动态规划问题
 * 凑零钱
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。算法的函数签名如下：
 * 比如说 k = 3，面值分别为 1，2，5，总金额 amount = 11。那么最少需要 3 枚硬币凑出，即 11 = 5 + 5 + 1。
 *
 * 思路： 完全背包问题
 * base  amount==0 return 0; amount<0; return -1;
 * 状态：有硬币和总金额两个状态；每选一个硬币，总金额减少，但是硬币不减少。
 *
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
    int[] memo;
    public int minMoney (int[] arr, int aim) {
        // write code here
        memo=new int[aim+1];
        Arrays.fill(memo,Integer.MAX_VALUE);
        return help(arr,aim);
    }
    private int help(int[] arr, int aim){
        if(aim==0){
            return 0;
        }
        if(aim<0){
            return -1;
        }
        if(memo[aim]!=Integer.MAX_VALUE){
            return memo[aim];
        }
        for(int coin:arr){
            if(aim-coin<0){
                continue;
            }
            memo[aim-coin]=help(arr,aim-coin);
            if(memo[aim-coin]==-1){
                continue;
            }
            memo[aim]=Math.min(memo[aim],memo[aim-coin]+1);
        }
        return memo[aim]==Integer.MAX_VALUE?-1:memo[aim];
    }

    public static void main(String[] args) {
        CoinChange coinChange=new CoinChange();
        int[] coins = {5, 2, 3};
        int count = coinChange.minMoney(coins, 20);
        System.out.println(count);
    }

}
