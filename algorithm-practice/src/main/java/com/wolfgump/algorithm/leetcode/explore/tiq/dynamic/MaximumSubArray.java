package com.wolfgump.algorithm.leetcode.explore.tiq.dynamic;

/**
 * @author ShiTao.Gan
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 * <p>
 * dp问题 如何找出n和n-1之间的关系
 * maxSubArray(int[] A,int i)
 * 状态转移方程：maxSubArray(int[] A,int i)=A[i]+ maxSubArray;这个状态转移方程的限制是subArray最后一个数组必须是A[i],
 * 实际上不一定要包含A[i],所有必须有一个额外变量记录之前已经计算出来的最大值，这个最大值可能是maxSubArray(int[] A,int i-1)、maxSubArray(int[] A,int i-2)....
 **/
public class MaximumSubArray {

    public static int maxSubArray(int[] A) {
        int[] dp = new int[A.length];
        dp[0] = A[0];
        int max = dp[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            //max可能是dp[i-1]、dp[i-2]、dp[i-3]、dp[i-4].....
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println(result);
    }
}
