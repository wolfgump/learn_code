package com.wolfgump.algorithm.struct.test.skiplist;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.skiplist.SkipList;
import org.junit.jupiter.api.Test;

public class SkipListTest extends AlgorithmApplicationTests {
	@Test
	public void testInsert(){
		SkipList list2 = new SkipList();
		list2.insert(1);
		list2.insert(2);
		list2.insert(6);
		list2.insert(7);
		list2.insert(8);
		list2.insert(3);
		list2.insert(4);
		list2.insert(5);
		System.out.println();
		list2.printAll_beautiful();
	}
}
