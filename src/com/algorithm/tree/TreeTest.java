package com.algorithm.tree;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * 树的测试代码
 * 
 * @author chao
 *
 */
public class TreeTest {

	public static void main(String[] args) {
		AVLTest();
		BinarySearchTreeTest();

	}

	@Test
	public void BinarySearchTest() {
		int num[] = { 3, 5, 7, 9, 10 };
		Arrays.sort(num);
		Assert.assertEquals(2, BinarySearch.binarySearch(num, 7));
		Assert.assertEquals(-1, BinarySearch.binarySearch(num, 8));
		Assert.assertEquals(2, BinarySearch.RecursivebinarySearch(num, 7));
		Assert.assertEquals(-1, BinarySearch.RecursivebinarySearch(num, 8));
	}

	/**
	 * AVL树测试
	 */
	public static void AVLTest() {
		AVLTree<Integer> avlTree = new AVLTree<Integer>(2);
		avlTree.insert(1);
		avlTree.insert(2);
		avlTree.insert(3);
		avlTree.insert(4);
		avlTree.inOrderTraversal();

	}

	/**
	 * 二叉查找树测试
	 */
	public static void BinarySearchTreeTest() {

		BinarySeachTree<Integer> binarySeachTree = new BinarySeachTree<>(6);
		binarySeachTree.insert(1);
		binarySeachTree.insert(8);
		binarySeachTree.insert(8);
		binarySeachTree.insert(2);
		binarySeachTree.insert(4);
		binarySeachTree.inOrderTraversal();
		System.out.println();
		System.out.println(binarySeachTree.findMax());
		System.out.println(binarySeachTree.findMin());
		System.out.println(binarySeachTree.contains(2));
		System.out.println(binarySeachTree.contains(6));
		binarySeachTree.remove(8);
		binarySeachTree.inOrderTraversal(binarySeachTree.getRoot());
		System.out.println();
		binarySeachTree.remove(3);
		binarySeachTree.inOrderTraversal(binarySeachTree.getRoot());
		System.out.println();
		binarySeachTree.remove(1);
		binarySeachTree.inOrderTraversal(binarySeachTree.getRoot());
		System.out.println();
		binarySeachTree.lazyRemove(2);
		binarySeachTree.inOrderTraversal(binarySeachTree.getRoot());
		System.out.println();
		binarySeachTree.insert(2);
		binarySeachTree.inOrderTraversal(binarySeachTree.getRoot());
		System.out.println();
	}
}
