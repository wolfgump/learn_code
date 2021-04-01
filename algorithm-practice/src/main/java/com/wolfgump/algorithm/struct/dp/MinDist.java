package com.wolfgump.algorithm.struct.dp;

public class MinDist {
	public int getMinDist() {
		return minDist;
	}

	private int minDist = Integer.MAX_VALUE;

	private int[][] matrix;

	private int n;

	public MinDist(int[][] matrix, int n) {
		this.n = n;
		this.matrix = matrix;
	}

	/**
	 * 回溯算法
	 * @param i
	 * @param j
	 * @param dist
	 */
	public void minDistBT(int i, int j, int dist) {
		if (i == n - 1 && j == n - 1) {
			if (dist < minDist) {
				minDist = dist;
				return;
			}
		}
		dist = dist + matrix[i][j];
		if (i < n - 1) {
			minDistBT(i + 1, j, dist);
		}
		if (j < n - 1) {
			minDistBT(i, j + 1, dist);
		}
	}

	//动态规划-状态表
	public int minDistDP() {
		int[][] states = new int[n][n];
		int sum = 0;
		for (int j = 0; j < n; ++j) { // 初始化states的第一行数据
			sum += matrix[0][j];
			states[0][j] = sum;
		}
		sum = 0;
		for (int i = 0; i < n; ++i) { // 初始化states的第一列数据
			sum += matrix[i][0];
			states[i][0] = sum;
		}
		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < n; ++j) {
				states[i][j] =
						matrix[i][j] + Math.min(states[i][j-1], states[i-1][j]);
			}
		}
		return states[n-1][n-1];
	}
	//动态规划--方程式
	public int minDistDPFC(int i, int j) {
		int[][] mem = new int[4][4];
		if (i == 0 && j == 0)
			return matrix[0][0];
		if (mem[i][j] > 0) return mem[i][j];
		int minLeft = Integer.MAX_VALUE;
		if (j - 1 >= 0) {
			minLeft = minDistDPFC(i, j - 1);
		}
		int minUp = Integer.MAX_VALUE;
		if (i - 1 >= 0) {
			minUp = minDistDPFC(i - 1, j);
		}
		int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
		mem[i][j] = currMinDist; return currMinDist;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		matrix[0] = new int[] { 1, 3, 5, 9 };
		matrix[1] = new int[] { 2, 1, 3, 4 };
		matrix[2] = new int[] { 5, 2, 6, 7 };
		matrix[3] = new int[] { 6, 8, 4, 3 };
		MinDist minDist = new MinDist(matrix, 4);
		System.out.println(minDist.minDistDP());
//		System.out.println(minDist.getMinDist());
	}
}
