package com.algorithm.sort;

/**
 * 冒泡排序算法
 * 
 * @author chao
 *
 */
public class Bubblesort {
	/**
	 * 简单冒泡排序
	 */
	public static void sort(int[] num) {
		int temp;
		int len = num.length;
		for (int i = 1; i < len; i++)
			for (int j = 0; j < len - i; j++) {
				if (num[j] > num[j + 1]) {
					temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
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
