package com.wolfgump.algorithm.leetcode.explore.tiq.string;

/**
 * @author ShiTao.Gan
 * <p>
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * <p>
 * <p>
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 **/
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] countChar = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countChar[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            countChar[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < countChar.length; i++) {
            if (countChar[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = isAnagram("anagram", "nagaram");
        assert result;
        System.out.println(result);
    }
}
