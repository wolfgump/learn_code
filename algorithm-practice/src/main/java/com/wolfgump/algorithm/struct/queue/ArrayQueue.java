package com.wolfgump.algorithm.struct.queue;

public class ArrayQueue<T> implements Queue<T> {
	private Object[] elementData;

	private int head;

	private int tail;

	private int n;

	public ArrayQueue(int size) {
		this.elementData = new Object[size];
		this.head = 0;
		this.tail = 0;
		this.n = size;
	}

	@Override
	public boolean enqueue(T data) {
		if (tail == n) {
			if(head==0){
				return false;
			}
			for(int i=head;i<tail;i++){
				elementData[i-head]=elementData[i];
			}
			tail=tail-head;
		}
		elementData[tail] = data;
		tail++;
		return false;
	}

	@Override
	public T dequeue() {
		if (head == tail) {
			return null;
		}
		T t = (T) elementData[head];
		head++;
		return t;
	}
}
