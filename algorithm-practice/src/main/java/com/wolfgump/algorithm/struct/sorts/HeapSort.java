package com.wolfgump.algorithm.struct.sorts;

public class HeapSort {

	public static void sort(int[] a, int count) {
		buildHeap(a, count);
		int k = count;
		while (k > 1) {
			int tmp = a[k];
			a[k] = a[1];
			a[1] = tmp;
			k--;
			heapify(a, k, 1);
		}
	}

	public static void buildHeap(int[] a, int count) {
		for (int i = count / 2; i > 0; i--) {
			heapify(a, count, i);
		}
	}

	public static void heapify(int[] a, int count, int i) {
		while (true) {
			int maxPos = i;
			if (i * 2 <= count && a[i * 2] > a[maxPos]) {
				maxPos = i * 2;
			}
			if (i * 2 + 1 <= count && a[i * 2 + 1] > a[maxPos]) {
				maxPos = i * 2 + 1;
			}
			if (maxPos == i) {
				break;
			}
			int temp = a[maxPos];
			a[maxPos] = a[i];
			a[i] = temp;
			i = maxPos;
		}
	}
}
