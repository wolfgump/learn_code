package com.wolfgump.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: gan
 * @date: 2020/7/6
 */
public class LC435 {
    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     * <p>
     *  
     * <p>
     * 注意:
     * <p>
     * 可以认为区间的终点总是大于它的起点。
     * <p>
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠
     * 示例 1
     * <p>
     * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
     * <p>
     * 输出: 1
     * <p>
     *  
     * <p>
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * <p>
     *  
     * <p>
     * 示例 2
     * <p>
     * 输入: [ [1,2], [1,2], [1,2] ]
     * <p>
     * 输出: 2
     * <p>
     *  
     * <p>
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * <p>
     *  
     * <p>
     * 示例 3
     * <p>
     * 输入: [ [1,2], [2,3] ]
     * <p>
     * 输出: 0
     * <p>
     *  
     * <p>
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     */
    public static void main(String[] args) {
        int[][] intervals = new int[4][2];
        intervals[0][0] = 1;
        intervals[0][1] = 2;
        intervals[1][0] = 2;
        intervals[1][1] = 3;
        intervals[2][0] = 3;
        intervals[2][1] = 4;
        intervals[3][0] = 1;
        intervals[3][1] = 3;
        int result = merge(intervals);

        System.out.println(result);
    }

    public static int merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            return Integer.compare(i1[1], i2[1]);
        });
        int end = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                end = Math.min(end, intervals[i][1]);
                count++;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}
