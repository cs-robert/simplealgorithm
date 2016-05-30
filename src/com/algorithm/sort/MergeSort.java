package com.algorithm.sort;

/**
 * 归并排序
 * 
 * @author chao
 *
 */
public class MergeSort {
	/**
	 * 归并排序
	 * 
	 * @param num
	 * @param start
	 * @param end
	 */
	public static void sort(int num[], int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		sort(num, start, mid);
		sort(num, mid + 1, end);
		merge(num, start, mid, end);

	}

	/**
	 * num[start]到num[mid]是有序的，num[mid+1]到num[end]是有序的，
	 * 重新合并数组，使数组num[start]到num[end]有序
	 * 
	 * @param num
	 * @param start
	 * @param mid
	 * @param end
	 */
	public static void merge(int[] num, int start, int mid, int end) {
		int[] num1 = new int[mid - start + 1];
		int[] num2 = new int[end - mid];
		int i, j, k;
		for (i = start; i <= end; i++) {
			if (i - start < num1.length) {
				num1[i - start] = num[i];
			} else {
				num2[i - start - num1.length] = num[i];
			}
		}
		i = j = k = 0;
		while (i < num1.length && j < num2.length) {
			if (num1[i] <= num2[j]) {
				num[start + k++] = num1[i++];
			} else {
				num[start + k++] = num2[j++];
			}
		}

		while (i < num1.length) {
			num[start + k++] = num1[i++];
		}
		while (j < num2.length) {
			num[start + k++] = num2[j++];
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 5, 3, 2 };
		sort(num, 0, num.length - 1);
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i] + " ");
	}
}
