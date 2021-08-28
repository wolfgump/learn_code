package com.wolfgump.algorithm.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShiTao.Gan
 * 给你两个字符s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 * <p>
 * <p>
 * 滑动窗口  固定大小窗口
 **/
public class LC567 {
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        char[] s1C = s1.toCharArray();
        char[] s2C = s2.toCharArray();
        for (char c : s1C) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int valid = 0;
        int left = 0, right = 0;
        while (right < s2C.length) {
            char c = s2C[right];
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right-left>=s1.length()) {
                if (valid==need.size()) {
                    return true;
                }
                char d = s2C[left];
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = checkInclusion("ab", "eidboaoo");
        System.out.println(result);
    }
}
