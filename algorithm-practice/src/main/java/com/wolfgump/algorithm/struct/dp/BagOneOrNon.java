package com.wolfgump.algorithm.struct.dp;

/**
 * 背包总的承载重量是 Wkg。现在我们有 n 个物品，每个物品的重量不等，并且不可分割。
 * 我们现在期望选择几件物品，装载到背包中。在不超过背包所能装载重量的前提下，如何让背包中物品的总重量最大？
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

	private static int maxV = Integer.MIN_VALUE; //存储背包中物品总价值的最大值

	//每个物品的重量
	private int[] items;

	//每个物品价值
	private int[] value;

	//物品的个数
	private int n;

	//背包可以承受的总重量
	private int w;

	public BagOneOrNon(int[] items, int n, int w,int[] value) {
		this.items = items;
		this.n = n;
		this.w = w;
		this.value=value;
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
	//f(0,0)=max(f(1,0),f(1,2))
	//f(1,0)=max(f(2,0),f(2,2))
	//f(1,2)=max(f(2,2),f(2,4))
	//f(2,2)是重复计算的，使用备忘录模式记录f(2,2)的值
	public void f1(int i, int cw) {
		boolean[][] mem = new boolean[n][w];
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

	/**
	 * 动态规划的方式解决0-1背包问题
	 * 定义个二维数组states 纵列标识物品的序号  横列代表物品的重量 值标识是有有这个中心
	 * 如states[0][95]=true ,states[0][0]=true  就表示第一个物品放入背包后 背包重量有0和95这两种状态
	 * 之后再推导第二个、第三个。。。物品放入背包后背包重量的状态 最终找最接近背包总重量的为true的值
	 *
	 * 这样由前一个结果推导后一个结果的过程就是动态规划
	 */
	public void fDp() {
		boolean[][] states = new boolean[n][w+1];
		//哨兵节点思想，第一行先给上值
		states[0][0] = true;
		if (items[0] <= w) {
			states[0][items[0]] = true;
		}
		//i从一开始，由于需要从上一个物品推导，所以上面首先求出第一个物品的值
		for (int i = 1; i < n; i++) {
			//第i个物品不放入背包
			for (int j = 0; j <= w; j++) {
				if (states[i - 1][j]) states[i][j] = true;
			}
			for (int j = 0; j <= w - items[i]; j++) {
				if (states[i - 1][j])
					states[i][items[i] + j] = true;
			}
		}
		for (int i = w - 1; i >= 0; i--) {
			if (states[n - 1][i]) {
				maxW = i;
				return;
			}
		}
	}

	//优化 states由二维数组改成一位数组，降低空间复杂度
	public void fDp2() {
		//下标背包了物品的重量 值表示是否有这个值
		boolean[] states = new boolean[w + 1];
		states[0] = true;
		for (int i = 0; i < n; i++) {
			//w-item[i] 到w之间不需要循环，这区间即使有值 加上item[i]后超过w了
			for (int j = w - items[i]; j >= 0; j--) {
				//states[j + items[i]]最大值是w 所以states长度要是w+1
				if (states[j]) states[j + items[i]] = true;
			}
		}
		for (int i = w; i >= 0; i++) {
			if (states[i]) {
				maxW = i;
				return;
			}
		}
	}

	//========================
	//背包问题升级
	//背包总的承载重量是 Wkg。现在我们有 n 个物品，每个物品的重量不等，**每个物品的价值不等**，并且不可分割。我们现在期望选择几件物品，装载到背包中。
	// 在不超过背包所能装载重量的前提下，如何让背包中物品的**总价值**最大？
	public void fUpgrade(int i, int cw, int cv) {
		if (cw == w || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
			if (cv > maxV) maxV = cv;
			return;
		}
		//i不放到背包中
		f(i + 1, cw);
		if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
			//i放到背包中
			fUpgrade(i + 1, cw + items[i], cv + value[i]);
		}
	}

	//备忘录模式
	public void f1Upgrade(int i, int cw, int cv) {
		//f(0,0,0)=max(f(1,0,0),f(1,2,3))
		//f(1,0,)=max(f(2,0,0),f(2,2,4))
		//f(1,2,3)=max(f(2,2,3),f(2,4,7))
		//这时候发现无法使用备忘录模式来解决问题
		//我们观察发现 f(2,2,4) 的物品价值肯定比f(2,2,3)价值大，所以f(2,2,3)之后的都不需要再推导了,就适用动态规划来解决
	}

	//
	public void fDpUpgrade() {
		//定义一个二维数组，存储的不再是bool,而是物品的价值
		int[][] states = new int[n][w + 1];
		for (int i = 0; i < n; ++i) { // 初始化states
			for (int j = 0; j < w + 1; ++j) {
				states[i][j] = -1;
			}
		}
		states[0][0] = 0;
		if (items[0] <= w) {
			states[0][items[0]] = value[0];
		}
		for (int i = 1; i < n; ++i) { //动态规划，状态转移
			for (int j = 0; j <= w; ++j) { // 不选择第i个物品
				if (states[i - 1][j] >= 0)
					states[i][j] = states[i - 1][j];
			}
			for (int j = 0; j <= w - items[i]; ++j) { // 选择第i个物品
				if (states[i - 1][j] >= 0) {
					int v = states[i - 1][j] + value[i];
					if (v > states[i][j + items[i]]) {
						states[i][j + items[i]] = v;
					}
				}
			}
		}
		for (int j = 0; j <= w; ++j) {
			if (states[n - 1][j] > maxV) maxV = states[n - 1][j];
		}
	}


	public static void main(String[] args) {
		int[] items = { 2, 2, 4, 6, 3 };
		int[] value = { 3, 4, 8, 9, 6 };
		BagOneOrNon bagOneOrNon = new BagOneOrNon(items, items.length, 10,value);
		bagOneOrNon.fDp();
		System.out.println("maxW:" + maxW);
		bagOneOrNon.fDpUpgrade();
		System.out.println("maxV:" + maxV);
	}
}
