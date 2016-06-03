package com.algorithm.list;

/**
 * 循环数组实现队列
 * 
 * @author chao
 *
 * @param <T>
 */
public class CircularArrayQueue<T> {
	// 数组的默认容量大小
	private final int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private T[] queue;

	public CircularArrayQueue() {
		front = rear = count = 0;
		queue = (T[]) new Object[DEFAULT_CAPACITY];
	}

	public CircularArrayQueue(int initialCapacity) {
		front = rear = count = 0;
		queue = (T[]) new Object[initialCapacity];
	}

	/**
	 * 一个元素出列后，front的值要递减，进行足够的dequeue操作后，front的值将到达数组的最后一个索引处，当最大索引处的元素被
	 * 删除后，front的值必须设置为0而不是递减，在enqueue操作中用于设置rear值的计算，也可以用来设置dequeue操作的front值
	 * */
	public T dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("empty queue");
		}
		T result = queue[front];
		queue[rear] = null;
		front = (front + 1) % queue.length;
		count--;
		return result;
	}

	/**
	 * enqueue操作：通常，一个元素入列后，rear的值要递增，但当enqueue操作填充了数组的最后一个单元时，
	 * rear必须设为0，表面下一个元素应该存储在索引0处，下面给出计算rear值的公式：
	 *  rear = （rear + 1） %queue.length;
	 * */
	public void enqueue(T element) {
		// 首先查看容量，必要时进行扩容
		if (size() == queue.length) {
			expandCapacity();
		}
		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		count++;
	}

	public T first() {
		if (isEmpty()) {
			throw new RuntimeException("empty queue");
		}
		return queue[front];
	}

	public boolean isEmpty() {
		return count == 0 ? true : false;
	}

	public int size() {
		return count;
	}

	/**
	 * 当数组中的所有单元都已填充，就需要进行扩容
	 * */
	private void expandCapacity() {
		// 增加为原容量的2倍
		T[] larger = (T[]) new Object[queue.length * 2];
		// 新数组中从索引0处开始按队列的正确顺序进行填充元素
		for (int scan = 0; scan < count; scan++) {
			larger[scan] = queue[front];
			front = (front + 1) % queue.length;
		}
		// 重新定位front,rear,queue
		front = 0;
		rear = count;
		queue = larger;
	}
}