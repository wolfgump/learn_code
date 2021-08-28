package com.wolfgump.algorithm.other;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ShiTao.Gan
 * 全排列
 * n 个不重复的数，进行排列组合
 **/
public class FullArray {
    static List<List<Integer>> result = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    public static List<List<Integer>> fullArray(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return result;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    static void backtrack(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();

        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = fullArray(nums);
    }
}
