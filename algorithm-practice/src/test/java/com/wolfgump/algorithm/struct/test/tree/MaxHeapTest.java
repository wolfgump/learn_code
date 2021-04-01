package com.wolfgump.algorithm.struct.test.tree;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.tree.MaxHeap;
import org.junit.Test;

public class MaxHeapTest extends AlgorithmApplicationTests {
	@Test
	public void testInsert() {
		MaxHeap maxHeap = new MaxHeap(3);
		maxHeap.insert(1);
		maxHeap.insert(2);
		maxHeap.insert(3);
		maxHeap.print();
	}

	@Test
	public void testDelete() {
		MaxHeap maxHeap = new MaxHeap(4);
		maxHeap.insert(1);
		maxHeap.insert(2);
		maxHeap.insert(3);
		maxHeap.insert(4);
		maxHeap.print();
		maxHeap.remove();
		System.out.println("======");
		maxHeap.print();
	}
}
