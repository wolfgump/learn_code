package com.wolfgump.algorithm.struct.test.sort;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.sorts.HeapSort;
import org.junit.jupiter.api.Test;

public class HeapSortTest extends AlgorithmApplicationTests {
	@Test
	public void testSort() {
		int[] a = { 0, 3, 52, 32, 45, 33, 64, 12 };
		HeapSort.sort(a, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
