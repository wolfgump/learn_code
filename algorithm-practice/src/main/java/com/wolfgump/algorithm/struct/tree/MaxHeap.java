package com.wolfgump.algorithm.struct.tree;

public class MaxHeap {
	//堆数据 从位置为1开始存数据
	private int[] data;

	//堆大小
	private int size;

	//堆中元素的个数
	private int count;

	public MaxHeap(int capacity) {
		data = new int[capacity + 1];
		size = capacity;
		count = 0;
	}

	public void insert(int value) {
		//堆满了
		if (count >= size) {
			return;
		}
		++count;
		data[count] = value;
		int i = count;
		while (i / 2 > 0 && data[i] > data[i / 2]) {
			int temp = data[i / 2];
			data[i / 2] = data[i];
			data[i] = temp;
			i = i / 2;
		}
	}

	/**
	 * 为了防止移除后的数组不再是合法的堆
	 * 需要把堆顶和数组最后一位互换，然后再进行堆化
	 */
	public void remove() {
		if (count <= 0) {
			return;
		}
		data[1] = data[count];
		--count;
		heapify(data, count, 1);
	}

	public void heapify(int[] array, int n, int i) {
		while (true) {
			int maxPos = i;
			if (i * 2 <= n && array[i * 2] > array[maxPos]) {
				maxPos = i * 2;
			}
			if (i * 2 <= n && array[i * 2 + 1] > array[maxPos]) {
				maxPos = i * 2 + 1;
			}
			if (i == maxPos) {
				break;
			}
			int temp = array[i];
			array[i] = array[maxPos];
			array[maxPos] = temp;
			i = maxPos;
		}
	}

	public void print() {
		for (int i = 0; i < count + 1; i++) {
			System.out.println(data[i]);
		}
	}
}
