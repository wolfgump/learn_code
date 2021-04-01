package com.wolfgump.algorithm.struct.test.stack;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.stack.ArrayStack;
import com.wolfgump.algorithm.struct.stack.LinkStack;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class StackTest extends AlgorithmApplicationTests {

	@Test
	public void testPushPop() {
		ArrayStack<Integer> arrayStack = new ArrayStack<>(10);
		arrayStack.push(12);
		Integer val = arrayStack.pop();
		Assert.assertTrue(val == 12);
	}

	@Test
	public void testPushPopOverSize() {
		ArrayStack<Integer> arrayStack = new ArrayStack<>(10);
		System.out.println(arrayStack.getSize());
		for (int i = 0; i < 20; i++) {
			arrayStack.push(i);
		}
		Integer val = arrayStack.pop();
		System.out.println(arrayStack.getSize());
		Assert.assertTrue(val == 19);
	}

	@Test
	public void testPushPopLink() {
		LinkStack<Integer> arrayStack = new LinkStack<Integer>();
		arrayStack.push(12);
		Integer val = arrayStack.pop();
		Assert.assertTrue(val == 12);
	}
}
