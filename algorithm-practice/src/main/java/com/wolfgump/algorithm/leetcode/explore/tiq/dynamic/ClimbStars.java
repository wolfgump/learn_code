package com.wolfgump.algorithm.leetcode.explore.tiq.dynamic;

/**
 * @author ShiTao.Gan
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 45
 **/
public class ClimbStars {
    public static int climbStairsRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }

    public static int climStair(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int result = 0;
        int before_one = 2;
        int before_two = 1;
        for (int i = 2; i < n; i++) {
            result = before_two + before_one;
            before_two = before_one;
            before_one = result;
        }
        return result;
    }

    public static void main(String[] args) {
//        int result = climbStairsRecursive(100);
        int result1=climStair(45);
        System.out.println(result1);
    }
}
