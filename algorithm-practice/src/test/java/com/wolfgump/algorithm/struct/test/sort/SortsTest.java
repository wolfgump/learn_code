package com.wolfgump.algorithm.struct.test.sort;

import java.util.Collections;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.sorts.Sorts;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SortsTest extends AlgorithmApplicationTests {
	@Test
	public void testInsertSort() {
		int[] array = { 2, 7, 3, 5, 6, 2 };
		printArray(array);
		Sorts.insertSort(array);
		printArray(array);

	}

	@Test
	public void testSelectSort() {
		int[] array = { 2, 7, 3, 5, 6, 2 };
		printArray(array);
		Sorts.selectSort(array);
		printArray(array);
	}

	@Test
	public void testBubbleSort() {
		int[] array = { 2, 7, 3, 5, 6, 2 };
		printArray(array);
		Sorts.bubbleSort(array);
		printArray(array);

	}

	@Test
	public void testQuickSort() {
		int[] array = { 2, 7, 3, 5, 6, 2 };
		printArray(array);
		Sorts.quickSort(array);
		printArray(array);

	}

	@Test
	public void testMergeSort() {
		int[] array = { 2, 7, 3, 5, 6, 2 };
		printArray(array);
		Sorts.mergeSort(array);
		printArray(array);

	}

	@Test
	public void testBucketSort() {
		int[] array = { 2, 7, 3, 5, 6, 2 };
		printArray(array);
		Sorts.bucketSort(array, 2);
		printArray(array);

	}
	@Test
	public void testCountSort() {
		int[] array = { 2, 7, 3, 5, 6, 2 };
		printArray(array);
		Sorts.countSort(array);
		printArray(array);

	}

	@Test
	public void testRadixSort() {
		int[] array = { 2, 7, 3, 5, 6, 2 };
		printArray(array);
		Sorts.radixSort(array);
		printArray(array);

	}

	@Test
	public void testKthSmall() {
		int[] array = { 2, 7, 3, 5, 6, 2 };
		printArray(array);
		int result = Sorts.kthSmall(array, 0, array.length - 1, 1);
		System.out.println(result);
		Assert.assertTrue(result == 2);

	}


	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			System.out.print(" ");
		}
		System.out.println(" ");
	}
}
