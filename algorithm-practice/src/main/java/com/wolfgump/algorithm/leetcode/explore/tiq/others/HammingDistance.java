package com.wolfgump.algorithm.leetcode.explore.tiq.others;

/**
 * @author ShiTao.Gan
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, return the Hamming distance between them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * The above arrows point to positions where the corresponding bits are different.
 * Example 2:
 * <p>
 * Input: x = 3, y = 1
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= x, y <= 231 - 1
 **/
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
