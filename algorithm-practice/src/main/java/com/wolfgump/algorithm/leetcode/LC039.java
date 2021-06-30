package com.wolfgump.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *  Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class LC039 {
	//最简单的办法，暴力法
	public static List<List<Integer>> combinationSumForce(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(results,candidates,new ArrayList<>(),target,0);
		return results;
	}
	public static void backtrack(List<List<Integer>> results,int[] candidates,List<Integer> tempList,int remains,int start){
		if(remains<0){
			return;
		}
		if(remains==0){
			results.add(new ArrayList<>(tempList));
		}
		for(int i=start;i<candidates.length;i++){
			tempList.add(candidates[i]);
			//start 仍然等于i是因为可以重复
			backtrack(results,candidates,tempList,remains-candidates[i],i);
			tempList.remove(tempList.size()-1);
		}
	}

	public static void main(String[] args) {
		int[] candidates={2,3,7};
		List<List<Integer>> res=combinationSumForce(candidates,7);
		for(int i=0;i<res.size();i++){
			List<Integer> childResult=res.get(i);
			for(int j=0;j<childResult.size();j++){
				System.out.print(childResult.get(j));
				System.out.print("  ");
			}
			System.out.println("");

		}
	}
}
