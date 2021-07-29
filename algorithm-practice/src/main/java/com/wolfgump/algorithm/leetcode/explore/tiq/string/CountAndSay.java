package com.wolfgump.algorithm.leetcode.explore.tiq.string;

/**
 * @author ShiTao.Gan
 * <p>
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 * <p>
 * For example, the saying and conversion for digit string "3322251":
 * <p>
 * <p>
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 * <p>
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 30
 **/
public class CountAndSay {

    public static String countAndSay(Integer n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = build(result);
        }
        return result;
    }

    private static String build(String result) {
        StringBuilder stringBuilder = new StringBuilder();
        int p = 0;
        while (p < result.length()) {
            int count = 0;
            char val = result.charAt(p);
            while (p < result.length() && val == result.charAt(p)) {
                p++;
                count++;
            }
            stringBuilder.append(count);
            stringBuilder.append(val);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            String result = countAndSay(i);
            System.out.println(result);
        }
    }
}
