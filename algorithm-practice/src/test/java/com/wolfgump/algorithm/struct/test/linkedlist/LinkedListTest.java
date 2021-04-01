package com.wolfgump.algorithm.struct.test.linkedlist;

import java.util.HashMap;
import java.util.Map;

import com.wolfgump.algorithm.AlgorithmApplicationTests;
import com.wolfgump.algorithm.struct.linkedlist.LinkedList;
import com.wolfgump.algorithm.struct.linkedlist.LinkedList.Node;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest extends AlgorithmApplicationTests {

	@Test
	public void testPrintAll() {
		int[] source = { 10, 22, 33, 44, 55 };
		Node head = buildNode(source);
		LinkedList.printAll(head);
	}

	@Test
	public void testReverse() {
		int[] source = { 10, 22, 33, 44, 55 };
		Node head = buildNode(source);
		LinkedList.printAll(head);
		Node reverseNode = LinkedList.reverse(head);
		LinkedList.printAll(reverseNode);
	}

	@Test
	public void testCircleFalse() {
		int[] source = { 10, 22, 33, 44, 55 };
		Node head = buildNode(source);
		LinkedList.printAll(head);
		Boolean result = LinkedList.checkCircle(head);
		Assert.assertFalse(result);
	}
	@Test
	public void testCircleTrue() {
		int[] source = { 10, 22, 33, 44, 55 };
		Node head = buildNode(source);
		head.getNext().getNext().setNext(head);
//		LinkedList.printAll(head);
		Boolean result = LinkedList.checkCircle(head);
		Assert.assertTrue(result);
	}
	@Test
	public void testMerge() {
		int[] source = { 10, 22, 33, 44, 55 };
		int[] source2 = { 11, 20, 35, 42, 56 };
		Node head = buildNode(source);
		Node head2 = buildNode(source2);
		LinkedList.printAll(head);
		LinkedList.printAll(head2);
		Node mergeNode = LinkedList.mergeTwoLists(head,head2);
		LinkedList.printAll(mergeNode);
	}
	@Test
	public void testDelete() {
		int[] source = { 10, 22, 33, 44, 55 };
		Node head = buildNode(source);
		LinkedList.printAll(head);
		Node reverseNode = LinkedList.deleteLastKth(head,2);
		LinkedList.printAll(reverseNode);
	}
	@Test
	public void testMiddle() {
		int[] source = { 10, 22, 33, 44, 55 };
		Node head = buildNode(source);
		LinkedList.printAll(head);
		Node reverseNode = LinkedList.findMiddleNode(head);
		LinkedList.printAll(reverseNode);
	}

	public LinkedList.Node buildNode(int[] source) {
		Map<Integer, Node> map = new HashMap<>(source.length);
		LinkedList.Node head = null;
		if (source == null || source.length <= 0) {
			return head;
		}
		for (int i = 0; i < source.length; i++) {
			if (i == 0) {
				head = new Node(source[i], null);
				map.put(i, head);
			}
			else {
				LinkedList.Node node = new LinkedList.Node(source[i], null);
				map.get(i - 1).setNext(node);
				map.put(i, node);
			}

		}
		return head;
	}
}
