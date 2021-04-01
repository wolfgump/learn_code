package com.wolfgump.algorithm.struct.backtracing;

/**
 * N皇后
 */
public class NQueens {
	private int n;

	public int[] getQueen() {
		return queen;
	}

	//用一维数组存储皇后拜放的位置,数组下标存放行号，值存储列号
	//因为一行只会存储一个值，用二维数组比较浪费空间
	private int[] queen;

	public NQueens(int n) {
		this.n = n;
		this.queen = new int[n];

	}

	public void putQueen(int row) {
		if (row == n) {
			return;
		}
		for (int column = 0; column < n; column++) {
			if (isOk(row, column)) {
				queen[row] = column;
				putQueen(++row);
			}
		}
	}

	private boolean isOk(int row, int column) {
		int leftUp = column - 1;
		int rightUp = column + 1;
		for (int i = row - 1; i >= 0; i--) {
			if (queen[i] == column) return false;
			if (leftUp >= 0) {
				if (queen[i] == leftUp) return false;
			}
			if (rightUp < 8) {
				if (queen[i] == rightUp) return false;
			}
			leftUp--;
			rightUp++;
		}
		return true;
	}

	private void printQueue(int[] queen) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (queen[i] == j) {
					System.out.print("Q  ");
				}
				else {
					System.out.print("*  ");
				}
			}
			System.out.println("");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		NQueens nQueens = new NQueens(20);
		nQueens.putQueen(0);
		nQueens.printQueue(nQueens.getQueen());
	}
}
