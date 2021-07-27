package com.wolfgump.algorithm.leetcode.explore.tiq.string;

/**
 * @author ShiTao.Gan
 * <p>
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 * <p>
 * Input: haystack = "", needle = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack and needle consist of only lower-case English characters.
 * <p>
 * <p>
 **/
public class StrStr {
    public static Integer strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (i + j >= haystack.length()) {
                    return -1;
                }
                if (j == needle.length()) {
                    return i;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }

            }
        }
    }

    public static void main(String[] args) {
        Integer result = strStr("", "");
        System.out.println(result);
    }
}
