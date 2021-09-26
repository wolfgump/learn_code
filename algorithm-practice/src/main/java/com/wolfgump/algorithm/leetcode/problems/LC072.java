package com.wolfgump.algorithm.leetcode.problems;

import java.util.Arrays;

/**
 * @author ShiTao.Gan
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 **/
public class LC072 {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo=new int[word1.length()][word2.length()];
        for(int i=0;i<memo.length;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    private int helper(String word1, int i, String word2, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j]= helper(word1, i - 1, word2, j - 1);
            return memo[i][j];
        } else {
            //插入 dp(i,j-1)
            //删除 dp(i-1,j)
            //替换 dp(i-1,j-1)
            int res = Math.min(helper(word1, i, word2, j - 1) + 1,
                    helper(word1, i - 1, word2, j) + 1);
            memo[i][j]= Math.min(res, helper(word1, i - 1, word2, j - 1) + 1);
            return memo[i][j];
        }
    }

    public static void main(String[] args) {
        LC072 lc072=new LC072();
        int res=lc072.minDistance("horse","ros");
        System.out.println(res);
    }
}
