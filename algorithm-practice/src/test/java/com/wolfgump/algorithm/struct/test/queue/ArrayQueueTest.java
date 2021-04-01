package com.wolfgump.algorithm.struct.test.queue;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.queue.ArrayQueue;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ArrayQueueTest extends AlgorithmApplicationTests {
	@Test
	public void testEnqueueDequeue() {
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(10);
		arrayQueue.enqueue(12);
		Integer val = arrayQueue.dequeue();
		Assert.assertTrue(val.equals(12));
	}

	@Test
	public void testEnqueueDequeueOverSize() {
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(10);
		for (int i = 0; i < 20; i++) {
			boolean result = arrayQueue.enqueue(i);
			if (!result) {
				System.out.println("out of size");
				break;
			}
		}
		Integer val = arrayQueue.dequeue();
		Assert.assertTrue(val.equals(0));
	}
}
