package com.wolfgump.algorithm.base.stack;

import org.springframework.stereotype.Component;

import java.util.Stack;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 * <p>
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 * 解题思路：
 * 利用栈，压入数据和数据在数据中的序号；
 *
 * @author ganshitao
 */
@Component
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            int stackValue = T[stack.peek()];

            while (T[i] > stackValue) {
                int resultIndex = stack.pop();
                result[resultIndex] = i - resultIndex;
                if(stack.isEmpty()){
                    break;
                }
                stackValue = T[stack.peek()];
            }

            stack.push(i);

        }
        return result;
    }
}
