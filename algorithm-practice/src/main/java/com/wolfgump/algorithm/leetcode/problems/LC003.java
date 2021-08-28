package com.wolfgump.algorithm.leetcode.problems;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author: gan
 * @date: 2020/6/9
 */
public class LC003 {
    /**
     * 给定一个字符串，找出不含重复字符的最长子串
     * 示例：
     * 1.输入：abcabcbb
     *   输出：3
     * 2.输入：bbbbbb
     *   输出：1
     * 3.输入：pwwkew
     *   输出：3
     */

    /**
     * 最简单的思路：暴力法
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubString1(String s) {
        char[] chars = s.toCharArray();
        int[] maxLengths = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String start = chars[i] + "";
            for (int j = i + 1; j < s.length(); j++) {
                if (start.contains(chars[j] + "")) {
                    maxLengths[i] = start.length();
                    break;
                } else {
                    start += chars[j];
                }
            }
        }
        int max = maxLengths[0];
        for (int i = 0; i < maxLengths.length; i++) {
            if (maxLengths[i] >= max) {
                max = maxLengths[i];
            }
        }
        return max;
    }

    /**
     * hashset  快慢指针
     *
     * @param s
     */
    public static int lengthOfLongestSubString2(String s) {
        HashSet hashSet = new HashSet(s.length());
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            while (hashSet.contains(s.charAt(j))) {
                hashSet.remove(s.charAt(i));
                i++;
            }
            hashSet.add(s.charAt(j));
            max = Math.max(max, hashSet.size());
        }
        return max;
    }

    /**
     * 在2的基础上，让慢指针不是一步一步的移动
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubString3(String s) {
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        int max = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubString4(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int right = 0, left = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.toCharArray()[right];
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char d = s.toCharArray()[left];
                window.put(d, window.get(d) - 1);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        int result = lengthOfLongestSubString4("abcabcbb");
        System.out.println(result);
    }
}
