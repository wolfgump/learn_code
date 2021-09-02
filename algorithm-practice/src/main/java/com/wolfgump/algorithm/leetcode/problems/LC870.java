package com.wolfgump.algorithm.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ShiTao.Gan
 * 给你输入两个长度相等的数组 nums1 和 nums2，请你重新组织 nums1 中元素的位置，使得 nums1 的「优势」最大化。
 * 思路：
 * 1.如果是两个排序的数组，那nums1的最大值和num2的最大值比；比的过就用最大值，比不过就用最小值
 * 2.但是nums2的顺序不能动，因为返回结果依赖nums2的顺序
 * 3.可以用一个容器装nums排序好的值并且记录对应值的位置
 **/
public class LC870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int left = 0, right = nums1.length - 1;
        int[] res = new int[nums1.length];
        while (queue.poll() != null) {
            int[] max = queue.peek();
            if (nums1[right] > max[1]) {
                //比的过
                res[max[0]] = nums1[right];
                right--;

            } else {
                //比不过
                res[max[0]] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
