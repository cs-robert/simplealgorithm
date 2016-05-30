package com.algorithm.sort;

/**
 * 快速排序
 * 
 * @author chao
 *
 */
public class QuickSort {
	/**
	 * 快速排序
	 * 
	 * @param num
	 * @param start
	 * @param end
	 */
	public static void sort(int[] num, int left, int right) {
		if (left < right) {
			int dp = partition(num, left, right);
			sort(num, left, dp - 1);
			sort(num, dp + 1, right);
		}
	}

	/**
	 * 数据分组，
	 * 
	 * @param num
	 * @param left
	 * @param right
	 */
	public static int partition(int[] num, int left, int right) {
		int pivot = num[left];
		while (left < right) {
			while (left < right && num[right] >= pivot)
				right--;
			if (left < right)
				num[left++] = num[right];
			while (left < right && num[left] <= pivot)
				left++;
			if (left < right)
				num[right--] = num[left];
		}
		num[left] = pivot;
		return left;
	}

	public static void main(String[] args) {
		int[] num = { 1, 5, 3, 2 };
		sort(num, 0, num.length - 1);
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i] + " ");

	}

}
