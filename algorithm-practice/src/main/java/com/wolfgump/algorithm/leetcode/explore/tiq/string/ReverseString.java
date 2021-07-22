package com.wolfgump.algorithm.leetcode.explore.tiq.string;

import com.wolfgump.algorithm.PrintUtil;

/**
 * @author ShiTao.Gan
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * <p>
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 * <p>
 * <p>
 * Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 **/
public class ReverseString {
    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        reverseString(s);
        PrintUtil.printCharArray(s);
    }
}
