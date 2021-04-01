package com.wolfgump.algorithm.struct.recursion;

public class Recursion {
	/**
	 * 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
	 * f(1)=1;
	 * f(2)=2;
	 */
	public static int step(int n) {
		if (n == 1) return 1;
		if (n == 2) return 2;
		return step(n - 1) + step(n - 2);

	}

	/**
	 *  斐波那契数列的排列是：0，1，1，2，3，5，8，13，21，34，55，89，144…
	 *  n<=1 f(n)=n
	 *  其他 f(n)=f(n-1)+f(n-2)
	 *  递归算法
	 */

	public static int Fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	/**
	 * 斐波那契数列动态规划方式解决
	 * 递归算法的问题是同一个f(a)会被递归求解多次
	 * @return
	 */
	public static int[] f = new int[100];

	public static int DynamicFibonacci_TopDown(int n) {
		if (n <= 1) {
			return n;
		}
		if (f[n] > 0) return f[n];
		f[n] = DynamicFibonacci_TopDown(n - 1) + DynamicFibonacci_TopDown(n - 2);
		return f[n];
	}

	/**
	 * 斐波那契数列动态规划 从下往上解法
	 * @param n
	 * @return
	 */
	public static int DynamicFibonacci_BottomUp(int n) {
		if (n <= 1) {
			return n;
		}
		int[] f = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f[n];
	}

	/**
	 * 阶乘 n!=n*(n-1)!
	 * n<1 非法
	 * n=1 1
	 * n>1 f(n)=n*f(n)
	 * @param n
	 * @return
	 */
	public static int factorial(int n) {
		if (n < 1) {
			return -1;
		}
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	/**
	 * 123456
	 * 654321
	 * @param value
	 */
	public static void printDigitReverse(int value) {
		System.out.print(value % 10);
		if (value > 10) {
			printDigitReverse(value / 10);
		}
	}

	/**
	 * 汉诺塔问题
	 * 如果n=1,直接将盘子从A移动到C
	 * 如果n>1,分为下面散步
	 *
	 * @param n
	 * @param a
	 * @param b
	 * @param c
	 */
	public static void hanoi(int n, char a, char b, char c) {
		if (n == 1) {
			System.out.println("将盘子" + n + "从" + a + "移动到" + c);
			return;
		}
		hanoi(n - 1, a, c, b);
		System.out.println("将盘子" + n + "从" + a + "移动到" + c);
		hanoi(n - 1, b, a, c);
	}

	/**
	 * 最大公约数
	 * 公式：gcd(a,b) = gcd(b,a mod b)。
	 * @param p
	 * @param q
	 * @return
	 */
	public static int euclid(int p, int q) {
		if (q == 0) return p;
		return euclid(q, p % q);
	}
}
