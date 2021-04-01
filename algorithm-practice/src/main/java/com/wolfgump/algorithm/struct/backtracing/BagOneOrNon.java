package com.wolfgump.algorithm.struct.backtracing;

/**
 * 背包总的承载重量是 Wkg。现在我们有 n 个物品，每个物品的重量不等，并且不可分割。我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
 */

/**
 * 思想是：n个物品按序排列，每个物品有放或者不放背包中两种情况
 * 枚举出n个物品放或不放 得到一个物品价值之和
 * 最终取枚举出来情况物品价值之和的最大值
 * 三个物品遍历过程如下：
 * 0 0 0 update maxW
 * 0 0 1 update maxW
 * 0 1 0 update maxW
 * 0 1 1 update maxW
 * 1 0 0 update maxW
 * 1 0 1 update maxW
 * 1 1 0 update maxW
 * 1 1 1 update maxW
 */
public class BagOneOrNon {

	private static int maxW = Integer.MIN_VALUE; //存储背包中物品总重量的最大值

	//每个物品的重量
	private int[] items;

	//物品的个数
	private int n;

	//背包可以承受的总重量
	private int w;

	public BagOneOrNon(int[] items, int n, int w) {
		this.items = items;
		this.n = n;
		this.w = w;
		this.mem = new boolean[n][w];
	}

	// cw表示当前已经装进去的物品的重量和；i表示考察到哪个物品了；
	// w背包重量；items表示每个物品的重量；n表示物品个数
	// 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，那可以这样调用函数：
	// f(0, 0, a, 10, 100)
	//递推公式 f(i)=max{f(i-1)+0,f(i-1)+W[i]}
	public void f(int i, int cw) {
		if (cw == w || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
			if (cw > maxW) maxW = cw;
			return;
		}
		//i不放到背包中
		f(i + 1, cw);
		if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
			//i放到背包中
			f(i + 1, cw + items[i]);
		}
	}

	//备忘录模式 记录已经计算过的函数值
	private boolean[][] mem;

	public void f1(int i, int cw) {
		if (cw == w || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
			if (cw > maxW) maxW = cw;
			return;
		}
		if (mem[i][cw]) return;
		//i不放到背包中
		f(i + 1, cw);
		if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
			//i放到背包中
			f(i + 1, cw + items[i]);
		}
	}

	public static void main(String[] args) {
		int[] items = { 95, 95, 95, 95, 95, 95, 95, 95, 95, 95 };
		BagOneOrNon bagOneOrNon = new BagOneOrNon(items, items.length, 100);
		bagOneOrNon.f1(0, 0);
		System.out.println(maxW);
	}
}
