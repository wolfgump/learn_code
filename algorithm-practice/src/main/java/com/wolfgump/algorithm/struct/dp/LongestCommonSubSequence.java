package com.wolfgump.algorithm.struct.dp;

/**
 * 自底向上
 * 动态规划求解最长公共子串
 *For example, the LCS of GGCACCACG and ACGGCGGATACG is GGCAACG, a string of length 7.
 */
public class LongestCommonSubSequence {
	public static String lcs(String x, String y) {
		int m = x.length(); int n = y.length();
		int[][] opt = new int[m + 1][n + 1];
		//opt[i][j] = 0                              if i = m or j = n
		//          = opt[i+1][j+1] + 1              if s[i] = t[j]
		//          = max(opt[i][j+1], opt[i+1][j])  otherwise
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m || j == n) {
					opt[i][j] = 0;
				}
				else if (x.charAt(i) == y.charAt(j)) {
					opt[i][j] = opt[i + 1][j + 1] + 1;
				}
				else {
					opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
				}
			}
		}
		String lcs = "";
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (x.charAt(i) == y.charAt(j)) {
				lcs += x.charAt(i);
				i++;
				j++;
			}
			else if (opt[i + 1][j] > opt[i][j + 1]) {
				i++;
			}
			else {
				j++;
			}

		}
		return lcs;
	}

	public static void main(String[] args) {
		String x="GGCACCACG";
		String y="ACGGCGGATACG";
		String lcs=LongestCommonSubSequence.lcs(x,y);
		System.out.println(lcs);
	}
}
