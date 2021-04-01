package com.wolfgump.algorithm.struct.test.search;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.search.BSearch;
import com.wolfgump.algorithm.struct.sorts.Sorts;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BSearchTest extends AlgorithmApplicationTests {
	@Test
	public void testBSearch() {
		int[] array = { 2, 2, 3, 5, 6, 7 };
		int result = BSearch.bSearch(array, 7);
		Assert.assertTrue(result == 5);
	}
	@Test
	public void testBSearchFirst() {
		int[] array = { 2, 2, 3, 5, 6, 7 };
		int result = BSearch.bSearchFirst(array, 2);
		Assert.assertTrue(result == 0);
	}
	@Test
	public void testBSearchLast() {
		int[] array = { 2, 2, 3, 5, 6, 7 };
		int result = BSearch.bSearchLast(array, 2);
		System.out.println(result);
		Assert.assertTrue(result == 1);
	}
}
