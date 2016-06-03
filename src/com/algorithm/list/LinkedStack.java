package com.algorithm.list;

import com.algorithm.list.MyLinkedList.Node;

/**
 * 栈的链表实现
 * 
 * @author chao
 *
 * @param <T>
 */
public class LinkedStack<T> {
	/**
	 * 栈顶指针
	 */
	private Node<T> top;
	/**
	 * 栈的长度
	 */
	private int size;

	public LinkedStack() {
		top = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		top = null;
		size = 0;
	}

	public int length() {
		return size;
	}

	public boolean push(T data) {
		Node<T> node = new Node<T>();
		node.ele = data;
		node.pre = top;
		// 改变栈顶指针
		top = node;
		size++;
		return true;
	}

	public Object pop() {
		if (top != null) {
			Node<T> node = top;
			// 改变栈顶指针
			top = top.pre;
			size--;
			return node.ele;
		}
		return null;
	}

}