package com.wolfgump.algorithm.leetcode.explore.tiq.sortandsearch;

/**
 * @author ShiTao.Gan
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 * <p>
 * Input: n = 1, bad = 1
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= bad <= n <= 231 - 1
 **/
public class FirstBadVersion {
    public static int firstBadVersion(int n, int bad) {
        int start = 1, end = n, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (!isBadVersion(mid, bad)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    public static boolean isBadVersion(int version, int bad) {
        if (version < bad) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int result = firstBadVersion(1, 1);
        System.out.println(result);
    }
}
