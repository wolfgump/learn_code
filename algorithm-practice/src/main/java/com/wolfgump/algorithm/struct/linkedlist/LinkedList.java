package com.wolfgump.algorithm.struct.linkedlist;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 */
public class LinkedList {
	/**
	 * 单链表翻转
	 * @param list
	 * @return
	 */
	public static Node reverse(Node list) {
		Node current = list;
		Node pre = null;
		while (current != null) {
			Node next = current.next;
			current.next = pre;
			pre = current;
			current = next;
		}
		return pre;
	}

	/**
	 * 检测环
	 * @param list
	 * @return
	 */
	public static boolean checkCircle(Node list) {
		if (list == null || list.next == null) {
			return false;
		}
		Node slow = list;
		Node fast = list;
		while (slow != null && fast != null & fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 有序链表合并 LeetCode 21
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static Node mergeTwoLists(Node l1, Node l2) {
		Node soldier = new Node(0, null);
		Node p = soldier;
		while (l1 != null && l2 != null) {
			if (l1.data < l2.data) {
				p.next = l1;
				l1 = l1.next;
			}
			else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null) {
			p.next = l1;
		}
		if (l2 != null) {
			p.next = l2;
		}
		return soldier.next;
	}

	// 删除倒数第K个结点
	public static Node deleteLastKth(Node list, int k) {
		Node fast = list;
		int i = 1;
		while (fast != null && i < k) {
			fast = fast.next;
			i++;
		}
		if (fast == null) {
			return list;
		}
		Node slow = list;
		Node pre = null;
		while (fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next;
		}
		if (pre == null) {
			list = list.next;
		}
		else {
			pre.next = pre.next.next;
		}

		return list;
	}

	// 求中间结点
	public static Node findMiddleNode(Node list) {
		Node slow = list;
		Node fast = list;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void printAll(Node list) {
		Node p = list;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}

	public static class Node {
		private int data;

		private Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getNext() {
			return this.next;
		}
	}
}
