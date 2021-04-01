package com.wolfgump.algorithm.struct.dp;

/**
 * 莱文斯特法求两个字符串的编辑距离
 */
public class Lwst {
	private char[] source;

	private char[] dest;

	public int getMinDist() {
		return minDist;
	}

	private int minDist = Integer.MAX_VALUE; // 存储结果

	public Lwst(char[] source, char[] dest) {
		this.source = source;
		this.dest = dest;
	}

	/**
	 * 回溯法解决
	 * case 1:a[i]与b[j]相等  递归去比较a[i+1]与b[j+1]
	 * case 2:a[i]与b[j]不相等
	 *  case2.1:a[i]删除一个字符或者b[j]前面添加一个字符 递归去比较 a[i+1] 与b[j]
	 *  case2.2:a[i]前面添加一个字符或者b[j]前面删除一个字符 递归去比较a[i]与b[j+1]
	 *  case2.3:a[i] b[j] 前面同时添加一个或删除一个字符 递归去比较a[i+1]与b[j+1]
	 * @return
	 */
	public void fBT(int i, int j, int editDest) {
		//有一个字符串比较的尾部
		if (i == source.length || j == dest.length) {
			if (i == source.length) editDest += dest.length - j;
			if (j == dest.length) editDest += source.length - i;
			if (editDest < minDist) {
				minDist = editDest;
			}
			return;
		}
		if (source[i] == dest[j]) {
			fBT(i + 1, j + 1, editDest);
		}
		else {
			fBT(i + 1, j, editDest + 1);
			fBT(j, j + 1, editDest + 1);
			fBT(i + 1, j + 1, editDest + 1);
		}
	}

	/**
	 * 状态转移方程
	 *
	 如果：a[i]!=b[j]，那么：min_edist(i, j)就等于：
	 min(min_edist(i-1,j)+1, min_edist(i,j-1)+1, min_edist(i-1,j-1)+1)

	 如果：a[i]==b[j]，那么：min_edist(i, j)就等于：
	 min(min_edist(i-1,j)+1, min_edist(i,j-1)+1，min_edist(i-1,j-1))

	 其中，min表示求三数中的最小值。

	 min_edist(i-1,j)+1 可以理解为 source新增一个字符  距离肯定加1
	 min_edist(i,j-1)+1 可以理解为 dest新增一个字符  距离肯定加1
	 min_edist(i-1,j-1) 可以理解为 source和dest 同时后移

	 */
	public int fDp() {
		//纵轴表示source的下标，横轴表示dest的下标 值表示从source[i] 到dest[j]的最小编辑距离
		int[][] minDist = new int[source.length][dest.length];
		for (int i = 0; i < source.length; i++) {
			if (dest[0] == source[i]) minDist[i][0] = i;
			else if (i != 0) minDist[i][0] = minDist[i - 1][0] + 1;
			else minDist[i][0] = 1;
		}

		for (int j = 0; j < dest.length; j++) {
			if (source[0] == dest[j]) minDist[0][j] = j;
			else if (j != 0) minDist[0][j] = minDist[0][j - 1] + 1;
			else minDist[0][j] = 1;
		}
		for (int i = 1; i < source.length; i++) {
			for (int j = 1; j < dest.length; j++) {
				if (source[i] == dest[j]) {
					minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
				}
				else {
					minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j-1] + 1, minDist[i - 1][j - 1]+1);
				}
			}
		}
		return minDist[source.length - 1][dest.length - 1];

	}

	private int min(int x, int y, int z) {
		int minv = Integer.MAX_VALUE;
		if (x < minv) minv = x;
		if (y < minv) minv = y;
		if (z < minv) minv = z;
		return minv;
	}

	public static void main(String[] args) {
		char[] source = "abcaaaa".toCharArray();
		char[] dest = "aac".toCharArray();
		Lwst lwst = new Lwst(source, dest);
		lwst.fBT(0, 0, 0);
		System.out.println("bt:"+lwst.getMinDist());
		System.out.println("bp:"+lwst.fDp());
	}
}
