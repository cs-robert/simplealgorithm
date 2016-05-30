package com.algorithm.sort;

/**
 * 插入排序
 * 
 * @author chao
 *
 */
public class InsertionSort {
	/**
	 * 简单插入排序
	 * 
	 * @param num
	 */
	public static void sort(int num[]) {
		int temp;
		int len = num.length;
		for (int i = 1; i < len; i++) {
			if (num[i - 1] > num[i]) {
				temp = num[i];
				int j = i;
				while (j > 0 && num[j - 1] > temp) {
					num[j] = num[j - 1];
					j--;
				}
				num[j] = temp;
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
