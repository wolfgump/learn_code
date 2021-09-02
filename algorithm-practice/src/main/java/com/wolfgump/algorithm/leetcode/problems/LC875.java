package com.wolfgump.algorithm.leetcode.problems;

/**
 * @author ShiTao.Gan
 * 珂珂爱吃香蕉
 * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例2：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例3：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 * <p>
 * <p>
 * 分析：
 * x:代表吃香蕉的速度
 * f(x): 代表吃完全部香蕉用的时间
 * 求解 x的值 使得f(x)=h; 并且x的值越小越好
 **/
public class LC875 {

    /**
     * @param piles 香蕉堆
     * @param x     吃香蕉的速度
     * @return 吃香蕉的用时
     */
    int f(int[] piles, int x) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / x;
            if (piles[i] % x > 0) {
                hours++;
            }
        }
        return hours;
    }

    //知道了上面的公式，求解x的值，使得返回的结果是h
    //最简单的方法时拿x的所有值去试
    //高效的方法时二分查找法；可以用二分查找的原因是：1.x和f(x)存在单调递减的关系，2.题目的求解结果是 f(x)=h
    int minSpeed(int[] piles, int h) {
        int left = 0;
        int right = 1000000000 + 1;
        int speed = left + (right - left) / 2;
        //左闭右开区间
        while (left < right) {
            if (f(piles, speed) == h) {
                right = speed;
            } else if (f(piles, speed) > h) {
                right = speed;
            } else if (f(piles, speed) < h) {
                left = speed + 1;
            }
        }
        return left;
    }


}
