package com.wolfgump.algorithm.leetcode.problems;

/**
 * @author ShiTao.Gan
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= D <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 **/
public class LC1011 {

    static int f(int[] weights, int c) {
        int currentWight = 0;
        int days = 0;
        for (int i = 0; i < weights.length; i++) {
            currentWight += weights[i];
            if (currentWight > c) {
                days++;
                currentWight = weights[i];
            }
        }
        if (currentWight > 0) {
            days++;
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        // 注意，right 是开区间，所以额外加一
        int right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) == days) {
                // 搜索左侧边界，则需要收缩右侧边界
                right = mid;
            } else if (f(weights, mid) < days) {
                // 需要让 f(x) 的返回值大一些
                right = mid;
            } else if (f(weights, mid) > days) {
                // 需要让 f(x) 的返回值小一些
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        int days = f(weights, 6);
        System.out.println(days);
    }
}
