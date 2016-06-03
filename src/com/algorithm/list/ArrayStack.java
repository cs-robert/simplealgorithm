package com.algorithm.list;

/**
 * 栈的数组实现
 * 
 * @author chao
 *
 * @param <T>
 */
public class ArrayStack<T> {
	private Object[] objs = new Object[16];
	private int size = 0;

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		// 将数组中的数据置为null, 方便GC进行回收
		for (int i = 0; i < size; i++) {
			objs[size] = null;
		}
		size = 0;
	}

	public int length() {
		return size;
	}

	public boolean push(T data) {
		// 判断是否需要进行数组扩容
		if (size >= objs.length) {
			resize();
		}
		objs[size++] = data;
		return true;
	}

	/**
	 * 数组扩容
	 */
	private void resize() {
		Object[] temp = new Object[objs.length * 3 / 2 + 1];
		for (int i = 0; i < size; i++) {
			temp[i] = objs[i];
			objs[i] = null;
		}
		objs = temp;
	}

	public T pop() {
		if (size == 0) {
			return null;
		}
		return (T) objs[--size];
	}

}