package com.wolfgump.algorithm.leetcode.recursion;

public class Hano {
	public static  void move(int n, char A, char B, char C) {
		if (n <= 0) {
			return;
		}
		move(n - 1, A, C, B);
		System.out.println("第" + n + "个盘子从" + A + "移动到" + C);
		move(n - 1, B, A, C);
	}

	public static void main(String[] args) {
		move(2,'A','B','C');
	}
}
