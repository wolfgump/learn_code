package com.wolfgump.algorithm.base.test.stack;


import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.base.stack.DailyTemperatures;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: ganshitao
 * @date: 2019/11/15
 */
public class DailyTemperaturesTest extends AlgorithmApplicationTests {
    @Autowired
    DailyTemperatures dailyTemperatures;

    @Test
    public void test() {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures.dailyTemperatures(temperatures);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }
    }
}
