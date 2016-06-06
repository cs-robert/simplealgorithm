package com.algorithm.tree;

/**
 * 二叉树
 * 
 * @author chao
 *
 * @param <T>
 */
public class BinaryTree<T> {
	private BinaryTreeNode<T> root;

	public static class BinaryTreeNode<T> {
		public T element;
		public BinaryTreeNode<T> left;
		public BinaryTreeNode<T> right;
	}

	public BinaryTree(BinaryTreeNode<T> root) {
		this.root = root;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	/**
	 * 中序遍历LDR
	 */
	public void inOrderTraversal(BinaryTreeNode<T> node) {
		if (node == null) {
			return;
		} else {
			inOrderTraversal(node.left);
			System.out.println(node.element);
			inOrderTraversal(node.right);
		}
	}

	/**
	 * 先序遍历DLR
	 */
	public void firstOrderTraversal(BinaryTreeNode<T> node) {
		if (node == null) {
			return;
		} else {
			System.out.println(node.element);
			firstOrderTraversal(node.left);
			firstOrderTraversal(node.right);
		}
	}

	/**
	 * 后序遍历LRD
	 */
	public void lastOrderTraversal(BinaryTreeNode<T> node) {
		if (node == null) {
			return;
		} else {
			lastOrderTraversal(node.left);
			lastOrderTraversal(node.right);
			System.out.println(node.element);
		}
	}

}
