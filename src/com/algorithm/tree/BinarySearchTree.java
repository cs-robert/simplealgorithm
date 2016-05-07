package com.algorithm.tree;

public class BinarySearchTree {
	public static int binarySearch(int num[], int number) {
		int start, end, mid;
		start = 0;
		end = num.length;
		while (start < end) {
			mid = (start + end) / 2;
			if (num[mid] == number)
				return mid;
			else if (num[mid] > number) {
				end = mid;
			} else {
				start = end;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

	}
}
