package com.wolfgump.algorithm.base.test.queue;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.base.queue.MaxSlidingWindow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: ganshitao
 * @date: 2019/11/23
 */
public class MaxSlidingWindowTest extends AlgorithmApplicationTests {
    @Autowired
    MaxSlidingWindow maxSlidingWindow;

    @Test
    public void testMaxSlidingWindow() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow.maxSlidingWindow(nums, k);
        printIntArray(result);
    }
}
