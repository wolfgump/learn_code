package com.wolfgump.algorithm.leetcode.recursion;

/**
 * LeetCode 91
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 */
public class NumberDecode {
	/**
	 * 解题思路：
	 * 对于长度为n的字符，假设前n-1个字符解码方法为f(n-1)个
	 *  往后添加第n个字符时，解法由下面两部分组成
	 *  1）对于给定的前n-1个字符 往后看，新增一个字符，无非就是在前n-1个字符的解码后面都加一个字符 解法还是f(n-1)
	 *     说明：新增最后一个字符不能是0；像130，140，150这些无法解码
	 *  2) 对于最后一个字符，往前看，如果第n-1是1，则第n可以是0，9；如果第n-1是2，第n可以是0到6；这几种情况，加法许需再加上f(n-2)的结果
	 *
	 *
	 */
	public static int recursionNumberDecode(String s) {
		if (s.charAt(0) == '0') return 0;
		return recursionNumberDecode1(s.toCharArray(), s.length() - 1);
	}

	private static int recursionNumberDecode(char[] chars, int index) {
		//只有一个字符，只有一种解法
		if (index <= 0) {
			return 1;
		}
		int count = 0;
		char current = chars[index];
		char pre = chars[index - 1];
		//current=0 且 pre>2时 如130，230，240是无法解码的;
		//current=0,pre<=2的情况，在下面一个if里处理
		if (current > '0') {
			count = recursionNumberDecode(chars, index - 1);
		}
		//如果不满足这个if，f(n)=f(n-1)
		//如果满足这个if,f(n)=f(n-1)+f(n-2)
		if (pre == '1' || (pre == '2' && current <= '6')) {
			//为什么是count+=呢 比如 2226 就是22的解加上222的解
			//f(n)=f(n-1)+f(n-2)
			count += recursionNumberDecode(chars, index - 2);
		}

		return count;
	}

	private static int recursionNumberDecode1(char[] chars, int index) {
		//只有一个字符，只有一种解法
		if (index <= 0) {
			return 1;
		}
		int count = 0;
		char current = chars[index];
		char pre = chars[index - 1];
		//换种写法
		if (pre != '1' && pre != '2' && current > '0') {
			count = recursionNumberDecode1(chars, index - 1);
		}
		else if (pre == '1' || (pre == '2' && current <= '6')) {
			count = recursionNumberDecode1(chars, index - 2);
			if (current > '0') {
				count += recursionNumberDecode1(chars, index - 1);
			}
		}
		else if (pre == '2' && current > '6') {
			count = recursionNumberDecode1(chars, index - 1);
		}
		else {
			count = 0;
		}
		return count;
	}

	public static int dpNumberDecode(String s) {
		int n = s.length();
		//dp[i] 表示长度为i的
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= n; i++) {
			int first=Integer.valueOf(s.substring(i-1,i));
			int second=Integer.valueOf(s.substring(i-2,i));
			if(first >= 1 && first <= 9) {
				dp[i] += dp[i-1];
			}
			if(second >= 10 && second <= 26) {
				dp[i] += dp[i-2];
			}
		}
		return dp[n];

	}

	public static void main(String[] args) {
		int count = dpNumberDecode("33");
		System.out.println(count);
	}
}
