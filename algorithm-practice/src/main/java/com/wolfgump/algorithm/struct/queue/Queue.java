package com.wolfgump.algorithm.struct.queue;

public interface Queue<T> {
	boolean enqueue(T data);

	T dequeue();
}
