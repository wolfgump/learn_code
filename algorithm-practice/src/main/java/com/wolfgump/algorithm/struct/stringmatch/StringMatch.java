package com.wolfgump.algorithm.struct.stringmatch;

public class StringMatch {
	/**
	 * Brute Force 暴力搜索算法 朴素算法
	 * @return
	 */
	public static boolean bfMatch(char[] haystack, char[] needle) {

		if (haystack == null || needle == null
				|| haystack.length <= 0 || needle.length <= 0
				|| needle.length > haystack.length) {
			return false;
		}
		int n = haystack.length;
		int m = needle.length;
		for (int i = 0; i < n - m + 1; i++) {
			int matchLength = 0;
			for (int j = 0; j < m; j++) {
				if (haystack[j + i] != needle[j]) {
					break;
				}
				else {
					matchLength++;
				}
			}
			if (matchLength == m) {
				return true;
			}
		}
		return false;
	}

	/**
	 * BF基础上增加hash
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static boolean rKMatch(char[] haystack, char[] needle) {
		if (haystack == null || needle == null
				|| haystack.length <= 0 || needle.length <= 0
				|| needle.length > haystack.length) {
			return false;
		}
		int n = haystack.length;
		int m = needle.length;
		//计算26的m次方，存储到数据中，方便后续使用
		int[] fang = new int[m];
		int s = 1;
		for (int i = 0; i < m; i++) {
			fang[i] = s;
			s *= 26;
		}
		//求haystack所有子串的hash
		int[] hash = new int[n - m + 1];
		for (int i = 0; i < n - m + 1; i++) {
			int subHash = 0;
			for (int j = 0; j < m; j++) {
				subHash += (haystack[j + i] - 'a') * fang[m - j - 1];
			}
			hash[i] = subHash;
		}
		int needleHash = 0;
		for (int j = 0; j < m; j++) {
			needleHash += (needle[j] - 'a') * fang[m - j - 1];
		}
		for (int i = 0; i < hash.length; i++) {
			if (needleHash == hash[i]) {
				return true;
			}
		}
		return false;
	}
}
