package com.wolfgump.algorithm.struct.stack;

public class LinkStack<T> implements Stack<T> {

	Node top = null;

	@Override
	public boolean push(T data) {
		Node node = new Node(data, null);
		if (top == null) {
			top = node;
		}
		else {
			node.next = top;
			top = node;
		}
		return true;
	}

	@Override
	public T pop() {
		if (top == null) {
			return null;
		}
		T t = (T) top.data;
		top = top.next;
		return t;
	}

	public void printAll() {
		Node p = top;
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}

	private static class Node<T> {
		private T data;

		private Node next;

		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}
	}
}
