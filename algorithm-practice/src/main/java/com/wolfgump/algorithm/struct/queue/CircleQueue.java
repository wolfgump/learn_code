package com.wolfgump.algorithm.struct.queue;

public class CircleQueue<T> implements Queue<T> {
	private Object[] elementData;

	private int head;

	private int tail;

	private int n;

	public CircleQueue(int size) {
		this.elementData = new Object[size];
		this.head = 0;
		this.tail = 0;
		this.n = size;
	}

	@Override
	public boolean enqueue(T data) {
		if ((tail + 1) % n == head) {
			return false;
		}
		elementData[tail] = data;
		tail = (tail + 1) % n;
		return true;
	}

	@Override
	public T dequeue() {
		if (head == tail) {
			return null;
		}
		T t = (T) elementData[head];
		head = (head + 1) % n;
		return t;
	}
}
