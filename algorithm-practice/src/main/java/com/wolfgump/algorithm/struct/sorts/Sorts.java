package com.wolfgump.algorithm.struct.sorts;

public class Sorts {
	/**
	 * 数组分为已排序好 和 未排序好两部分,未排序好的往已排序末尾插入
	 * @param a
	 */
	public static void insertSort(int[] a) {
		if (a == null || a.length <= 1) {
			return;
		}
		for (int i = 1; i < a.length; i++) {
			int v = a[i];
			int j = i - 1;
			for (; j >= 0; j--) {
				if (a[j] > v) {
					a[j + 1] = a[j];
				}
				else {
					break;
				}
			}
			a[j + 1] = v;
		}
	}

	/**
	 * 每次在未排序数组中选择一个最小的 放到已排序序列的尾部
	 * @param a
	 */
	public static void selectSort(int[] a) {
		if (a == null || a.length <= 1) {
			return;
		}
		for (int i = 0; i < a.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[minIndex]) {
					minIndex = j;
				}
			}
			int temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
	}

	/**
	 * 冒泡排序 每次排一个最大
	 * @param a
	 */
	public static void bubbleSort(int[] a) {
		if (a == null || a.length <= 1) {
			return;
		}
		for (int i = 0; i < a.length; i++) {
			boolean swap = false;
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					swap = true;
				}
			}
			if (!swap) {
				break;
			}
		}
	}

	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	/**
	 * 快速排序
	 * f(n,p,q)=f(n,p,r-1)+f(n,r+1,q)
	 * p>=r 终止
	 * @param a
	 * @param low
	 * @param high
	 */
	private static void quickSort(int[] a, int low, int high) {
		if (a == null || a.length <= 1) {
			return;
		}
		if (low >= high) {
			return;
		}
		int r = partition(a, low, high);
		quickSort(a, low, r - 1);
		quickSort(a, r + 1, high);
	}

	/**
	 * 最简单的做法 申请两个临时数组，小于的pivot的值放到一个数组 大于pivot的放到一个数组；但是这样空间复杂度增大，类似了归并排序
	 * 只在原数组a上通过交换操作完成
	 * 定义两个变量 i,j；j一直往后++，a[j]小于pivot,a[j]和a[i]交换 ；i++； i一直指向大于或等于pivot的位置，遇到比pivot小的值就和i位置的值进行交换
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(int[] a, int low, int high) {
		int pivot = a[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (a[j] < pivot) {
				if (i == j) {
					i++;
				}
				else {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
				}
			}
		}
		int temp = a[i];
		a[i] = a[high];
		a[high] = temp;
		return i;
	}

	/**
	 * 归并排序
	 *  * f(n,p,q)=f(n,p,r-1)+f(n,r+1,q)
	 * 	 * p>=r 终止
	 * @param a
	 */
	public static void mergeSort(int[] a) {
		mergeSort(a, 0, a.length - 1);
	}

	private static void mergeSort(int[] a, int low, int high) {
		if (low >= high) {
			return;
		}
		int middle = low + (high - low) / 2;
		mergeSort(a, low, middle);
		mergeSort(a, middle + 1, high);
		mergeBySentry(a, low, middle, high);
	}

	private static void merge(int[] a, int low, int middle, int high) {
		int[] tempArray = new int[high - low + 1];
		int i = low;
		int j = middle + 1;
		int k = 0;
		while (i <= middle && j <= high) {
			if (a[i] <= a[j]) {
				tempArray[k++] = a[i++];
			}
			else {
				tempArray[k++] = a[j++];
			}
		}
		//判断哪个段里还有剩余的数据
		int start = i;
		int end = middle;
		if (j <= high) {
			start = j;
			end = high;
		}
		while (start <= end) {
			tempArray[k++] = a[start++];
		}
		for (i = 0; i <= high - low; ++i) {
			a[low + i] = tempArray[i];
		}
	}

	/**
	 * 借助哨兵节点，在左边数组和右边数组的最后一位都增加一个最大值，这样能保证两边原有数据都处理完，不用再去判断剩余数据的情况
	 * @param a
	 * @param low
	 * @param middle
	 * @param high
	 */
	private static void mergeBySentry(int[] a, int low, int middle, int high) {
		int[] leftArray = new int[middle - low + 2];
		int[] rightArray = new int[high - middle + 1];
		for (int i = 0; i <= middle - low; i++) {
			leftArray[i] = a[low + i];
		}
		leftArray[middle - low + 1] = Integer.MAX_VALUE;
		for (int i = 0; i < high - middle; i++) {
			rightArray[i] = a[middle + i + 1];
		}
		rightArray[high - middle] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		int k = low;
		while (k <= high) {
			if (leftArray[i] <= rightArray[j]) {
				a[k++] = leftArray[i++];
			}
			else {
				a[k++] = rightArray[j++];
			}
		}
	}


	//TODO 桶排序 计数排序 基数排序

	/**
	 * 桶排序 分桶 桶内快速排序 如何确定桶的数量，桶的大小？
	 * 假定桶的大小是10，首选根据数据的最大值和最小值求出桶的数量 bucket=(max-min)/bucketSize+1
	 * 那么bucketIndex=(value-min)/bucketSize
	 * @param a
	 */
	public static void bucketSort(int[] a, int bucketSize) {
		if (a == null || a.length <= 1) {
			return;
		}
		//扫描一遍数组 得到最大值 最小值 求出
		int max = a[0];
		int min = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
			if (a[i] < min) {
				min = a[i];
			}
		}
		int bucketCount = (max - min) / bucketSize + 1;
		int[][] buckets = new int[bucketCount][bucketSize];
		int[] countInBucket = new int[bucketCount];
		for (int i = 0; i < a.length; i++) {
			int bucketIndex = (a[i] - min) / bucketSize;
			//这里不能直接和bucketSize比较，因为可能已经扩容
			if (countInBucket[bucketIndex] == buckets[bucketIndex].length) {
				ensureCapacity(buckets, bucketIndex);
			}
			buckets[bucketIndex][countInBucket[bucketIndex]++] = a[i];
		}
		int k = 0;
		for (int i = 0; i < bucketCount; i++) {
			if (countInBucket[i] == 0) {
				continue;
			}
			quickSort(buckets[i]);
			for (int j = 0; j < buckets[i].length; j++) {
				if (buckets[i][j] != 0) {
					a[k++] = buckets[i][j];
				}
			}
		}
	}

	/**
	 * 通过一个额外的数组计数，算出每个数字应该在数组中的位置
	 * @param a
	 */
	public static void countSort(int[] a) {
		if (a == null || a.length <= 1) {
			return;
		}
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		//申请计数器
		int[] counter = new int[max + 1];
		//把数据个数放到审批流中
		for (int i = 0; i < a.length; i++) {
			counter[a[i]]++;
		}
		//计数器累加
		for (int i = 1; i < counter.length; i++) {
			counter[i] = counter[i - 1] + counter[i];
		}
		int[] temp = new int[a.length];
		for (int i = a.length - 1; i >= 0; i--) {
			int index = counter[a[i]] - 1;
			temp[index] = a[i];
			counter[a[i]]--;
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = temp[i];
		}

	}

	/**
	 * 基数排序，将待排序的数字按位进行查分 然后再进行计数排序  要求计数排序必须是稳定的排序算法
	 * @param a
	 */
	public static void radixSort(int[] a) {
		if (a == null || a.length <= 1) {
			return;
		}
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}

		for (int exp = 1; max / exp > 0; exp *= 10) {
			countSort(a,exp);
		}
	}

	/**
	 * 计数排序
	 * @param a
	 * @param exp
	 */
	public static void countSort(int[] a, int exp) {
		if (a == null || a.length <= 1) {
			return;
		}
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		//申请计数器
		int[] counter = new int[max + 1];
		//把数据个数放到审批流中
		for (int i = 0; i < a.length; i++) {
			counter[(a[i] / exp) % 10]++;
		}
		//计数器累加
		for (int i = 1; i < counter.length; i++) {
			counter[i] = counter[i - 1] + counter[i];
		}
		int[] temp = new int[a.length];
		for (int i = a.length - 1; i >= 0; i--) {
			int index = counter[(a[i] / exp) % 10] - 1;
			temp[index] = a[i];
			counter[(a[i] / exp) % 10]--;
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = temp[i];
		}

	}

	/**
	 * 求第K小的值得位置
	 * @param a
	 * @param low
	 * @param high
	 * @param k
	 * @return
	 */
	public static int kthSmall(int[] a, int low, int high, int k) {
		if (low > high) {
			return -1;
		}
		int p = partition(a, low, high);
		if ((p + 1) == k) {
			return a[p];
		}
		else if ((p + 1) > k) {
			return kthSmall(a, low, p - 1, k);
		}
		else {
			return kthSmall(a, p + 1, high, k);
		}
	}


	private static void ensureCapacity(int[][] buckets, int bucketIndex) {
		int[] tempArray = buckets[bucketIndex];
		int[] newArray = new int[buckets[bucketIndex].length * 2];
		for (int i = 0; i < buckets[bucketIndex].length; i++) {
			newArray[i] = tempArray[i];
		}
		buckets[bucketIndex] = newArray;
	}

}
