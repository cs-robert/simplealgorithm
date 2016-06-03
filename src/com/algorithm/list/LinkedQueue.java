package com.algorithm.list;

import com.algorithm.list.MyLinkedList.Node;

/**
 * 队列的链表实现
 * 
 * @author chao
 *
 * @param <T>
 */
public class LinkedQueue<T> {
	// 跟踪队列中的元素个数
	private int count;
	// 指向首元素末元素的引用
	private Node<T> front, rear;

	public LinkedQueue() {
		count = 0;
		front = rear = null;
	}

	/**
	 * 实现dequeue操作时，确保至少存在一个可返回的元素，如果没有，就要抛出异常
	 * 
	 * @throws Exception
	 * 
	 * 
	 * */
	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("empty queue");
		}

		T result = front.ele;
		front = front.next;
		count--;
		// 如果此时队列为空，则要将rear引用设置为null,front也为null，但由于front设置为链表的next引用，已经有处理
		if (isEmpty()) {
			rear = null;
		}
		return result;
	}

	/**
	 * enqueue操作要求将新元素放到链表的末端
	 * 一般情况下，将当前某元素的next引用设置为指向这个新元素，并重新把rear引用设置为指向这个新添加的末元素，但是，如果队列
	 * 目前为空，则front引用也要设置为指向这个新元素
	 * */
	public void enqueue(T element) {
		Node<T> node = new Node<T>(element);

		if (isEmpty()) {
			front = node;
		} else {
			rear.next = node;
		}
		rear = node;
		count++;
	}

	public T first() {
		T result = front.ele;
		return result;
	}

	public boolean isEmpty() {
		return count == 0 ? true : false;
	}

	public int size() {
		return count;
	}

}