package com.wolfgump.algorithm.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 247 中心对称数
 * 找到所有长度为 n 的中心对称数。
 * 示例
 * 输入:  n = 2
 * 输出: ["11","69","88","96"]
 */
public class CenterSymmetricNumber {
	//通过找规律发现，当n>2时，f(n)就是在f(n-2)的所有结果上添加11、69、88、96
	public static List<String> cal(int n){
		if(n<=0){
			return new ArrayList<>();
		}
		if(n==1){
			return new ArrayList<String>(Arrays.asList("0","1","8"));
		}
		if(n==2){
			return new ArrayList<>(Arrays.asList("11","69","88","96"));
		}
		List<String> result=cal(n-2);
		List<String> newResult=new ArrayList<>();
		for(int i=0;i<result.size();i++){
			newResult.add("1"+result.get(i)+"1");
			newResult.add("6"+result.get(i)+"9");
			newResult.add("8"+result.get(i)+"8");
			newResult.add("9"+result.get(i)+"6");
		}
		return newResult;
	}

	public static void main(String[] args) {
		List<String> result=cal(4);
		for(int i=0;i<result.size();i++){
			if(i%3==0){
				System.out.println("");
			}
			System.out.print(result.get(i));
			System.out.print("  ");
		}
	}
}
