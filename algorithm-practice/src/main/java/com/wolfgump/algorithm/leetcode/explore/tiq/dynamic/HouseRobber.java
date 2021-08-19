package com.wolfgump.algorithm.leetcode.explore.tiq.dynamic;

import java.util.Arrays;

/**
 * @author ShiTao.Gan
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 偷第i-2家和第i家，或者偷第i-1家
 * rob(int[] nums,i)=max(rob(int[] nums,i-2)+currentValue,rob(int[] nums,i-1)+0)
 **/
public class HouseRobber {
    //递归 top->down
    public static int rob(int[] nums) {
        return robHelp(nums, nums.length - 1);
    }

    public static int robHelp(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(robHelp(nums, i - 2) + nums[i], robHelp(nums, i - 1));
    }

    static int[] memo;

    //备忘录模式，降低时间复杂度 top->down
    public static int robMemo(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robMemoHelp(nums, nums.length - 1);
    }

    public static int robMemoHelp(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int max = Math.max(robMemoHelp(nums, i - 2) + nums[i], robMemoHelp(nums, i - 1));
        memo[i] = max;
        return max;
    }

    //动态规划 down->top
    public static int robDp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
    //动态规划 down->top 用更少的空间
    public static int robDp2(int[] nums) {

        int pre2 = nums[0];
        int pre1= Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int tmp=pre1;
            pre1 = Math.max(pre2 + nums[i], pre1);
            pre2=tmp;

        }
        return pre1;
    }



    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int result1 = rob(nums);
        int result2 = robMemo(nums);
        int result3 = robDp(nums);
        int result4 = robDp2(nums);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
