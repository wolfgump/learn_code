package com.wolfgump.algorithm.leetcode.explore.tiq.array;

/**
 * @author ShiTao.Gan
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 * Example 3:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * Each element in the array appears twice except for one element which appears only once.
 * <p>
 * 解题思路：
 * 消消乐，一样的消掉，最后剩余的就是我们想要的
 * 一样的消掉在计算机里 异或
 **/
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 4, 6, 6};
        int result = singleNumber(nums);
        assert result == 1;
        System.out.println(result);
    }
}
