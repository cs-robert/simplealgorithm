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

	public BinarySeachTree(T root) {
		this(root, null);
	}

	public BinarySeachTree(T root, Comparator<T> comparator) {
		super(root);
		this.comparator = comparator;
	}

	protected int compare(BinarySeachTree.BinaryTreeNode<T> a, BinarySeachTree.BinaryTreeNode<T> b) {
		if (comparator != null) {
			return comparator.compare(a.element, b.element);
		} else if (a.element instanceof Comparable && b.element instanceof Comparable) {
			return ((Comparable) a.element).compareTo(b.element);
		} else {
			throw new RuntimeException("can't compare " + a.element.getClass());
		}
	}

	protected int compare(T a, T b) {
		if (comparator != null) {
			return comparator.compare(a, b);
		} else if (a instanceof Comparable && b instanceof Comparable) {
			return ((Comparable) a).compareTo(b);
		} else {
			throw new RuntimeException("can't compare " + a.getClass() + " " + b.getClass());
		}
	}

	/**
	 * 判断是否包含x
	 * 
	 * @param x
	 * @return
	 */
	public boolean contains(T x) {
		return contains(root, new BinaryTreeNode<T>(x));
	}

	/**
	 * 以某个节点为根节点判断是否包含x
	 * 
	 * @param cur
	 * @param x
	 * @return
	 */
	protected boolean contains(BinaryTreeNode<T> cur, BinaryTreeNode<T> x) {
		if (x == null || cur == null || cur.hintcount < 0) {
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
	 * 查找节点
	 * 
	 * @param cur
	 * @param x
	 * @return
	 */
	protected BinaryTreeNode<T> findNode(BinaryTreeNode<T> cur, T x) {
		if (x == null || cur == null || cur.hintcount < 0) {
			return null;
		}
		int compareresult = compare(cur.element, x);
		if (compareresult == 0) {
			return cur;
		} else if (compareresult < 0) {
			return findNode(cur.right, x);
		} else {
			return findNode(cur.left, x);
		}
	}

	/**
	 * 从根节点插入一个新数据
	 * 
	 * @param x
	 * @return
	 */
	public void insert(T x) {
		if (x == null) {
			return;
		}
		insert(root, new BinaryTreeNode<T>(x));
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
		} else {
			cur.hintcount++;
		}
		return cur;
	}

	/**
	 * 查找最小节点
	 * 
	 * @return
	 */
	public T findMin() {
		return findMin(root).element;
	}

	/**
	 * 以node为根节点的最小节点
	 * 
	 * @param node
	 * @return
	 */
	protected BinaryTreeNode<T> findMin(BinaryTreeNode<T> node) {
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
	public T findMax() {
		return findMax(root).element;
	}

	/**
	 * 以node为根节点的最大节点
	 * 
	 * @param node
	 * @return
	 */
	protected BinaryTreeNode<T> findMax(BinaryTreeNode<T> node) {
		if (node == null) {
			return null;
		} else if (node.right == null) {
			return node;
		}
		return findMax(node.right);
	}

	/**
	 * 删除节点x
	 * 
	 * @param x
	 * @return
	 */
	public void remove(T x) {
		BinaryTreeNode<T> node = findNode(root, x);
		if (node == null) {
			return;
		} else if (node.hintcount <= 0) {
			remove(root, new BinaryTreeNode<T>(x));
		} else {
			lazyRemove(node);
		}
	}

	public void lazyRemove(T x) {
		BinaryTreeNode<T> node = findNode(root, x);
		if (node != null) {
			node.hintcount--;
		}
	}

	protected void lazyRemove(BinaryTreeNode<T> x) {
		x.hintcount--;
	}

	/**
	 * 删除子树中的节点x
	 * 
	 * @param cur
	 * @param x
	 * @return
	 */
	protected BinaryTreeNode<T> remove(BinaryTreeNode<T> cur, BinaryTreeNode<T> x) {
		if (cur == null || x == null) {
			return cur;
		}
		int compareresult = compare(cur, x);
		if (compareresult > 0) {
			cur.left = remove(cur.left, x);
		} else if (compareresult < 0) {
			cur.right = remove(cur.right, x);
		} else if (cur.left != null && cur.right != null) {
			BinaryTreeNode<T> minnode = findMin(cur.right);
			cur.right = remove(cur.right, minnode);
			cur.element = minnode.element;
			minnode = null;
		} else {
			cur = (cur.left == null) ? cur.right : cur.left;
		}

		return cur;
	}
}
