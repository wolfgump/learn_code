package com.wolfgump.algorithm.leetcode.explore.tiq.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShiTao.Gan
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * Example 4:
 * <p>
 * Input: x = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 **/
public class ReverseInteger {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            result = result * 10 + tail;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = reverse(-120);
        assert result == 0;
        System.out.println(result);
    }
}
