package com.wolfgump.algorithm.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: gan
 * @date: 2020/7/6
 */
public class LC056 {
    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     * <p>
     * 示例 1
     * <p>
     * 输入: [[1,3], [2,6], [8,10], [15,18]]
     * <p>
     * 输出: [[1,6], [8,10], [15,18]] 
     * <p>
     * 解释: 区间 [1,3] 和 [2,6] 重叠，将它们合并为 [1,6]。
     * <p>
     * 示例 2
     * <p>
     * 输入: [[1,4], [4,5]]
     * <p>
     * 输出: [[1,5]]
     * <p>
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */
    public static void main(String[] args) {
        int[][] intervals = new int[4][2];
        intervals[0][0] = 1;
        intervals[0][1] = 3;
        intervals[1][0] = 2;
        intervals[1][1] = 6;
        intervals[2][0] = 8;
        intervals[2][1] = 10;
        intervals[3][0] = 15;
        intervals[3][1] = 18;
        int[][] result = merge(intervals);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            return Integer.compare(i1[0], i2[0]);
        });
        int[] previous = null;
        List<int[]> result = new ArrayList<>();
        for (int[] current : intervals) {
            if (previous == null || current[0] > previous[1]) {
                result.add(current);
            } else {
                previous[1] = Math.max(previous[1], current[1]);
            }
            previous =current ;
        }
        return result.toArray(new int[result.size()][]);
    }
}
