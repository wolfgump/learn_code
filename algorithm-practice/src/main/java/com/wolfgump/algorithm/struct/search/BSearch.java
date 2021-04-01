package com.wolfgump.algorithm.struct.search;

public class BSearch {
	/**
	 * 二分查找
	 * @param a
	 * @param value
	 * @return
	 */
	public static int bSearch(int[] a, int value) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int middle = low + ((high - low) >> 1);
			if (a[middle] == value) {
				return middle;
			}
			else if (a[middle] > value) {
				high = middle - 1;
			}
			else {
				low = middle + 1;
			}
		}
		return -1;
	}

	/**
	 * 二分查找 如果查找的数字有重复 返回第一个
	 * @param a
	 * @param value
	 * @return
	 */
	public static int bSearchFirst(int[] a, int value) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int middle = low + ((high - low) >> 1);
			if (a[middle] == value) {
				if (middle == 0 || a[middle - 1] != value) {
					return middle;
				}
				else {
					high = middle - 1;
				}
			}
			else if (a[middle] > value) {
				high = middle - 1;
			}
			else {
				low = middle + 1;
			}
		}
		return -1;
	}
	/**
	 * 二分查找 查找第一个大于等于指定值
	 * @param a
	 * @param value
	 * @return
	 */
	public static int bSearchFirstGT(int[] a, int value) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int middle = low + ((high - low) >> 1);
			if (a[middle] >= value) {
				if (middle == 0 || a[middle - 1] < value) {
					return middle;
				}
				else {
					high = middle - 1;
				}
			}
			else {
				low = middle + 1;
			}
		}
		return -1;
	}
	/**
	 * 二分查找 如果查找的数字有重复 返回最后一个
	 * @param a
	 * @param value
	 * @return
	 */
	public static int bSearchLast(int[] a, int value) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int middle = low + ((high - low) >> 1);
			if (a[middle] == value) {
				if (middle == a.length-1 || a[middle + 1] != value) {
					return middle;
				}
				else {
					low = middle + 1;
				}
			}
			else if (a[middle] > value) {
				high = middle - 1;
			}
			else {
				low = middle + 1;
			}
		}
		return -1;
	}
}
