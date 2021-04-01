package com.wolfgump.algorithm.struct.dp;

/**
 * 最长公共子串
 *
 * 我们先来看回溯的处理思路。
 * 我们从 a[0]和 b[0]开始，依次考察两个字符串中的字符是否匹配。
 * 如果 a[i]与 b[j]互相匹配，我们将最大公共子串长度加一，并且继续考察 a[i+1]和 b[j+1]。
 * 如果 a[i]与 b[j]不匹配，最长公共子串长度不变，这个时候，有两个不同的决策路线：
 * 删除 a[i]，或者在 b[j]前面加上一个字符 a[i]，然后继续考察 a[i+1]和 b[j]；
 * 删除 b[j]，或者在 a[i]前面加上一个字符 b[j]，然后继续考察 a[i]和 b[j+1]。
 *
 *
 如果：a[i]==b[j]，那么：max_lcs(i, j)就等于：
 max(max_lcs(i-1,j-1)+1, max_lcs(i-1, j), max_lcs(i, j-1))；

 如果：a[i]!=b[j]，那么：max_lcs(i, j)就等于：
 max(max_lcs(i-1,j-1), max_lcs(i-1, j), max_lcs(i, j-1))；

 其中max表示求三数中的最大值。

 从i-1 或j-1过来，代表进行了删除和增加操作，不能+1
 */
public class LongCommonString {

	public int lcs(char[] a, int n, char[] b, int m) {
		int[][] maxlcs = new int[n][m];
		for (int j = 0; j < m; ++j) {//初始化第0行：a[0..0]与b[0..j]的maxlcs
			if (a[0] == b[j]) maxlcs[0][j] = 1;
			else if (j != 0) maxlcs[0][j] = maxlcs[0][j - 1];
			else maxlcs[0][j] = 0;
		}
		for (int i = 0; i < n; ++i) {//初始化第0列：a[0..i]与b[0..0]的maxlcs
			if (a[i] == b[0]) maxlcs[i][0] = 1;
			else if (i != 0) maxlcs[i][0] = maxlcs[i - 1][0];
			else maxlcs[i][0] = 0;
		}
		for (int i = 1; i < n; ++i) { // 填表
			for (int j = 1; j < m; ++j) {
				if (a[i] == b[j]) maxlcs[i][j] = max(
						maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1] + 1);
				else maxlcs[i][j] = max(
						maxlcs[i - 1][j], maxlcs[i][j - 1], maxlcs[i - 1][j - 1]);
			}
		}
		return maxlcs[n - 1][m - 1];
	}

	private int max(int x, int y, int z) {
		int maxv = Integer.MIN_VALUE;
		if (x > maxv) maxv = x;
		if (y > maxv) maxv = y;
		if (z > maxv) maxv = z;
		return maxv;
	}

	public static void main(String[] args) {
		LongCommonString longCommonString = new LongCommonString();
		char[] source = "abcaaaa".toCharArray();
		char[] dest = "aac".toCharArray();
		int result = longCommonString.lcs(source, source.length, dest, dest.length);
		System.out.println(result);
	}
}
