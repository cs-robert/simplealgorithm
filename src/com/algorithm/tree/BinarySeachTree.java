package com.algorithm.tree;

import java.util.Comparator;

/**
 * 左子树小于右子树的二叉查找树
 * 
 * @author chao
 *
 * @param <T>
 */
public class BinarySeachTree<T> extends BinaryTree<T> {
	private Comparator<T> comparator;

	public BinarySeachTree(BinarySeachTree.BinaryTreeNode<T> root) {
		this(root, null);
	}

	public BinarySeachTree(BinarySeachTree.BinaryTreeNode<T> root, Comparator<T> comparator) {
		super(root);
		this.comparator = comparator;
	}

	private int compare(BinarySeachTree.BinaryTreeNode<T> a, BinarySeachTree.BinaryTreeNode<T> b) {
		if (comparator != null) {
			return comparator.compare(a.element, b.element);
		} else if (a.element instanceof Comparable && b.element instanceof Comparable) {
			return ((Comparable) a.element).compareTo(b.element);
		} else {
			throw new RuntimeException("can't compare " + a.element.getClass());
		}

	}

	/**
	 * 判断是否包含x
	 * 
	 * @param x
	 * @return
	 */
	public boolean contains(BinaryTreeNode<T> x) {
		return contains(root, x);
	}

	/**
	 * 以某个节点为根节点判断是否包含x
	 * 
	 * @param cur
	 * @param x
	 * @return
	 */
	public boolean contains(BinaryTreeNode<T> cur, BinaryTreeNode<T> x) {
		if (x == null || cur == null) {
			return false;
		}
		int compareresult = compare(cur, x);
		if (compareresult == 0) {
			return true;
		} else if (compareresult < 0) {
			return contains(cur.right, x);
		} else {
			return contains(cur.left, x);
		}
	}

	/**
	 * 从根节点插入一个新数据
	 * 
	 * @param x
	 * @return
	 */
	public BinaryTreeNode<T> insert(BinaryTreeNode<T> x) {
		return insert(root, x);
	}

	/**
	 * 从某一个节点插入新数据
	 * 
	 * @param cur
	 * @param x
	 * @return
	 */
	protected BinaryTreeNode<T> insert(BinaryTreeNode<T> cur, BinaryTreeNode<T> x) {
		if (cur == null) {
			return x;
		}
		int compareresult = compare(cur, x);
		if (compareresult < 0) {
			cur.right = insert(cur.right, x);
		} else if (compareresult > 0) {
			cur.left = insert(cur.left, x);
		}
		return cur;
	}

	/**
	 * 查找最小节点
	 * 
	 * @return
	 */
	public BinaryTreeNode<T> findMin() {
		return findMin(root);
	}

	/**
	 * 以node为根节点的最小节点
	 * 
	 * @param node
	 * @return
	 */
	public BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
		if (node == null) {
			return null;
		} else if (node.left == null) {
			return node;
		}
		return findMin(node.left);
	}

	/**
	 * 查找最大节点
	 * 
	 * @return
	 */
	public BinaryTreeNode<T> findMax() {
		return findMin(root);
	}

	/**
	 * 以node为根节点的最大节点
	 * 
	 * @param node
	 * @return
	 */
	public BinaryTreeNode<T> findMax(BinaryTreeNode<T> node) {
		if (node == null) {
			return null;
		} else if (node.right == null) {
			return node;
		}
		return findMin(node.right);
	}

	/**
	 * 删除节点x
	 * 
	 * @param x
	 * @return
	 */
	public BinaryTreeNode<T> remove(BinaryTreeNode<T> x) {
		return remove(root, x);
	}

	/**
	 * 删除子树中的节点x
	 * 
	 * @param cur
	 * @param x
	 * @return
	 */
	public BinaryTreeNode<T> remove(BinaryTreeNode<T> cur, BinaryTreeNode<T> x) {
		if (cur == null || x == null) {
			return cur;
		}
		int compareresult = compare(cur, x);
		if (compareresult > 0) {
			cur.left = remove(cur.left, x);
		} else if (compareresult < 0) {
			cur.right = remove(cur.right, x);
		} else if (cur.left != null && cur.right != null) {
			cur.right = remove(cur.right, findMin(cur.right));

		} else {
			cur = (cur.left == null) ? cur.right : cur.left;
		}

		return cur;
	}
}
