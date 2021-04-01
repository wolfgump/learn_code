package com.wolfgump.algorithm.struct.stack;

public class ArrayStack<T> implements Stack<T> {
	private Object[] elementData;

	private int n;

	private int count;

	public ArrayStack(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("illegal size");
		}
		this.n = n;
		this.count = 0;
		this.elementData = new Object[n];
	}

	public int getSize() {
		return n;
	}

	public boolean push(T data) {
		if (count == n) {
			this.n = this.n * 2;
			Object[] newElementData = new Object[this.n];
			for (int i = 0; i < elementData.length; i++) {
				newElementData[i] = elementData[i];
			}
			this.elementData = newElementData;
		}
		elementData[count] = data;
		count++;
		return true;
	}
	public T pop() {
		if (count == 0) {
			return null;
		}
		T t = (T) elementData[count - 1];
		count--;
		return t;
	}
}
