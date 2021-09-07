package com.wolfgump.algorithm.leetcode.problems;

import java.util.Map;
import java.util.Random;

/**
 * @author ShiTao.Gan
 * 给定一个包含 [0，n) 中不重复整数的黑名单 blacklist ，写一个函数从 [0, n) 中返回一个不在 blacklist 中的随机整数。
 * <p>
 * 对它进行优化使其尽量少调用系统方法 Math.random() 。
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 1000000000
 * 0 <= blacklist.length < min(100000, N)
 * [0, n)不包含 n ，详细参见interval notation。
 * 示例 1：
 * <p>
 * 输入：
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * 输出：[null,0,0,0]
 * 示例 2：
 * <p>
 * 输入：
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * 输出：[null,1,1,1]
 * 示例 3：
 * <p>
 * 输入：
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * 输出：[null,0,0,2]
 * 示例 4：
 * <p>
 * 输入：
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * 输出：[null,1,3,1]
 **/
public class LC710 {
    int sz;
    //key:黑名单数字 val:
    Map<Integer, Integer> map;
    Random random = new Random();

    public LC710(int n, int[] blacklist) {
        sz = n - blacklist.length;
        for (int b : blacklist) {
            map.put(b, 888);
        }
        int last = n - 1;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(i)) {
                if (i >= sz) {
                    continue;
                }
                int b = map.get(i);
                while (map.containsKey(last)) {
                    last--;
                }
                map.put(b, last);
            }
        }
    }

    public int pick() {
        int r = random.nextInt() % sz;
        if (map.containsKey(r)) {
            return map.get(r);
        }
        return r;
    }

}
