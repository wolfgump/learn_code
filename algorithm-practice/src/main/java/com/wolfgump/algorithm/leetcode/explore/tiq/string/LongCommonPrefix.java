package com.wolfgump.algorithm.leetcode.explore.tiq.string;

/**
 * @author ShiTao.Gan
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 * <p>
 * <p>
 * class Solution {
 * public String longestCommonPrefix(String[] strs) {
 * if(strs == null || strs.length == 0)    return "";
 * String pre = strs[0];
 * int i = 1;
 * while(i < strs.length){
 * while(strs[i].indexOf(pre) != 0)
 * pre = pre.substring(0,pre.length()-1);
 * i++;
 * }
 * return pre;
 * }
 * }
 **/
public class LongCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            i++;
        }
        return pre;
    }

    public static void main(String[] args) {
//        String[] strs = {"dog", "bacecar", "car"};
//        String result = longestCommonPrefix(strs);
//        System.out.println(result);
        String str="hello";
        String re1=str.substring(0,0);
        int res2=str.indexOf("");
    }
}
