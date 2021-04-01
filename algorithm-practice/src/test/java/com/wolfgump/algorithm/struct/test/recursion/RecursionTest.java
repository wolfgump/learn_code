package com.wolfgump.algorithm.struct.test.recursion;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.recursion.Recursion;
import org.junit.Assert;
import org.junit.Test;

public class RecursionTest extends AlgorithmApplicationTests {
	@Test
	public void testStep(){
		int result=Recursion.step(3);
		Assert.assertTrue(result==3);
	}
	@Test
	public void testFibonacci() {
		int n = Recursion.Fibonacci(12);
		System.out.println(n);
		Assert.assertTrue(n == 144);
	}
	@Test
	public void testDynamicFibonacci_TopDown() {
		int n = Recursion.DynamicFibonacci_TopDown(12);
		System.out.println(n);
		Assert.assertTrue(n == 144);
	}
	@Test
	public void testDynamicFibonacci_BottomUp() {
		int n = Recursion.DynamicFibonacci_BottomUp(12);
		System.out.println(n);
		Assert.assertTrue(n == 144);
	}

	@Test
	public void testFactorial() {
		int n = Recursion.factorial(3);
		System.out.println(n);
		Assert.assertTrue(n == 6);
	}

	@Test
	public void testPrintDigitReverse() {
		int value = 123456;
		Recursion.printDigitReverse(value);
	}

	@Test
	public void testHanoi() {
		Recursion.hanoi(4, 'A', 'B', 'C');
	}

	@Test
	public void testEuclid() {
		int result = Recursion.euclid(12, 8);
		System.out.println(result);
		Assert.assertTrue(result == 4);
	}
}
