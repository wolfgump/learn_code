package com.wolfgump.algorithm.base.recursion;

/**
 * @author ganshitao
 * Recursion provides just the plan that we need: First we move the top n−1 discs to an empty pole,
 * then we move the largest disc to the other empty pole, then complete the job by moving the n−1 discs onto the largest disc
 */
public class TowerOfHanoi {
	public static  void move(int n, char A, char B, char C) {
		if (n <= 0) {
			return;
		}
		move(n - 1, A, C, B);
		System.out.println("第" + n + "个盘子从" + A + "移动到" + C);
		move(n - 1, B, A, C);
	}

	public static void main(String[] args) {
		move(4,'A','B','C');
	}
}
