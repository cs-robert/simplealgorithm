package com.algorithm.tree;

import java.util.Arrays;
import java.util.Collections;

/**
 * 二分查找
 * 
 * @author chao
 *
 */
public class BinarySearchTree {
	/**
	 * 非递归二分查找
	 * 
	 * @param num
	 * @param number
	 * @return
	 */
	public static int binarySearch(int num[], int number) {
		if (num == null || num.length == 0) {
			return -1;
		}
		int start, end, mid;
		start = 0;
		end = num.length - 1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (num[mid] == number)
				return mid;
			else if (num[mid] > number) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	/**
	 * 递归查找
	 * 
	 * @param num
	 * @param number
	 * @return
	 */
	public static int RecursivebinarySearch(int num[], int start, int end, int key) {
		int mid = (start + end) / 2;
		if (num == null || num.length == 0 || key < num[start] || key > num[end]) {
			return -1;
		} else if (num[mid] > key) {
			return RecursivebinarySearch(num, start, mid - 1, key);
		} else if (num[mid] < key) {
			return RecursivebinarySearch(num, mid + 1, end, key);
		} else {
			return mid;
		}

	}

	public static void main(String[] args) {
		int num[] = { 3, 5, 7, 9, 10 };
		Arrays.sort(num);
		System.out.println(binarySearch(num, 7));
		System.out.println(binarySearch(num, 8));
		System.out.println(RecursivebinarySearch(num, 0, num.length - 1, 7));
		System.out.println(RecursivebinarySearch(num, 0, num.length - 1, 8));
	}
}
