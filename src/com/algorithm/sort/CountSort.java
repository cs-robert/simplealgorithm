package com.algorithm.sort;

/**
 * 计数排序
 * 
 * @author chao
 *
 */
public class CountSort {

	public static void main(String[] args) {
		int[] num = { 1, 1 };
		sort(num);
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i] + " ");
	}

	/**
	 * 计数排序
	 * 
	 * @param num
	 */
	public static void sort(int[] num) {
		int len = num.length;
		int[] orign = new int[len];
		int max = 0;// 我们只对正整数排序
		for (int i = 0; i < len; i++) {
			orign[i] = num[i];
			if (num[i] > max) {
				max = num[i];
			}
		}
		max = max + 1;
		int[] count = new int[max];
		for (int i = 0; i < max; i++) {
			count[i] = 0;
		}
		for (int i = 0; i < len; i++) {
			count[num[i]]++;
		}
		int t1, t2;
		t1 = count[1];
		count[0] = count[1] = 0;
		for (int i = 2; i < max; i++) {
			t2 = count[i];
			count[i] = t1 + count[i - 1];
			t1 = t2;
		}
		int key, index;
		for (int i = 0; i < len; i++) {
			key = orign[i];
			index = count[key];
			num[index] = orign[i];
			count[key]++;
		}
	}
}
