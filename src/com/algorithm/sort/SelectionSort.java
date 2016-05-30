package com.algorithm.sort;

/**
 * 选择排序算法
 * 
 * @author chao
 *
 */
public class SelectionSort {
	/**
	 * 选择排序算法简单实现
	 * 
	 * @param num
	 */
	public static void sort(int num[]) {
		int min, index, temp;
		int len = num.length;
		for (int i = 0; i < len; i++) {
			min = num[i];
			index = i;
			for (int j = i + 1; j < len; j++) {
				if (num[j] < min) {
					min = num[j];
					index = j;
				}
			}
			if (index != i) {
				temp = num[i];
				num[i] = num[index];
				num[index] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] num = { 1, 5, 3, 2 };
		sort(num);
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i] + " ");
	}

}
