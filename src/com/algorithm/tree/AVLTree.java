package com.algorithm.tree;

import java.util.Comparator;

/**
 * AVL树
 * 
 * @author chao
 *
 * @param <T>
 */
public class AVLTree<T> extends BinarySeachTree<T> {

	public AVLTree(T root) {
		super(root);
	}

	public AVLTree(T root, Comparator<T> comparator) {
		super(root, comparator);
	}

	@Override
	protected BinaryTreeNode<T> insert(BinaryTreeNode<T> cur, BinaryTreeNode<T> x) {
		if (cur == null) {
			return x;
		}
		int compareresult = compare(cur, x);
		if (compareresult < 0) {
			cur.right = insert(cur.right, x);
			if (getHeight(cur.right) - getHeight(cur.left) == 2) {
				if (compare(x, cur.right) > 0) {
					cur = roateWithRightChild(cur);
				} else {
					cur = doubleWithRightChild(cur);
				}
			}
		} else if (compareresult > 0) {
			cur.left = insert(cur.left, x);
			if (getHeight(cur.left) - getHeight(cur.right) == 2) {
				if (compare(x, cur.left) < 0) {
					cur = roateWithLeftChild(cur);
				} else {
					cur = doubleWithLeftChild(cur);
				}
			}
		} else {
			cur.hintcount++;
		}
		return cur;
	}

	/**
	 * 左子树单旋转
	 * 
	 * @param node
	 * @return
	 */
	protected BinaryTreeNode<T> roateWithLeftChild(BinaryTreeNode<T> k2) {
		BinaryTreeNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		return k1;

	}

	/**
	 * 右子树单旋转
	 * 
	 * @param node
	 * @return
	 */
	protected BinaryTreeNode<T> roateWithRightChild(BinaryTreeNode<T> k2) {
		BinaryTreeNode<T> k1 = k2.right;
		k2.right = k1.left;
		k1.left = k2;
		return k1;
	}

	/**
	 * 左子树双旋转
	 * 
	 * @param node
	 * @return
	 */
	protected BinaryTreeNode<T> doubleWithLeftChild(BinaryTreeNode<T> k3) {
		k3.left = roateWithRightChild(k3.left);
		return roateWithLeftChild(k3);

	}

	/**
	 * 右子树双旋转
	 * 
	 * @param node
	 * @return
	 */
	protected BinaryTreeNode<T> doubleWithRightChild(BinaryTreeNode<T> k3) {
		k3.right = roateWithLeftChild(k3.right);
		return roateWithRightChild(k3);
	}
}
