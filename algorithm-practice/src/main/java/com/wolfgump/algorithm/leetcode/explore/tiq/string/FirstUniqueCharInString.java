package com.wolfgump.algorithm.leetcode.explore.tiq.string;

/**
 * @author ShiTao.Gan
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 * <p>
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 * <p>
 * Input: s = "aabb"
 * Output: -1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 **/
public class FirstUniqueCharInString {
    /**
     * n的平方
     *
     * @param s
     * @return
     */
    public static int firstUniqueChar(String s) {
        char[] sc = s.toCharArray();
        for (int i = 0; i <= sc.length - 1; i++) {
            boolean contains = false;
            for (int j = 0; j <= sc.length - 1; j++) {
                if (sc[i] == sc[j] && j != i) {
                    contains = true;
                }
            }
            if (!contains) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 2n
     *
     * @param s
     * @return
     */
    public static int firstUniqueChar1(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;


    }

    public static void main(String[] args) {
        int index = firstUniqueChar1("loveleetcode");
        assert index == 0;
        System.out.println(index);
    }
}
