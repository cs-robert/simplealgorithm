package com.algorithm.hash;

import java.util.LinkedList;

import com.algorithm.math.PrimeNumber;

/**
 * 分离链接法解冲突
 * 
 * @author chao
 *
 * @param <T>
 */
public class SeparateChainHashTable<T> {
	private static final int DEFAULT_SIZE = 100;
	protected LinkedList[] lists;

	public SeparateChainHashTable() {
		this(DEFAULT_SIZE);
	}

	public SeparateChainHashTable(int size) {
		lists = new LinkedList[PrimeNumber.nextPrime(size)];
		for (int i = 0; i < lists.length; i++) {
			lists[i] = new LinkedList<T>();
		}
	}

	public boolean contains(T x) {
		return lists[hashCode(x)].contains(x);
	}

	public void insert(T x) {
		LinkedList<T> linkedList = lists[hashCode(x)];
		if (!linkedList.contains(x)) {
			linkedList.add(x);
		}
	}

	public void remove(T x) {
		LinkedList<T> linkedList = lists[hashCode(x)];
		if (linkedList.contains(x)) {
			linkedList.remove(x);
		}
	}

	/**
	 * 计算hash值
	 * 
	 * @param x
	 * @return
	 */
	private int hashCode(T x) {
		int hashVal = x.hashCode();
		hashVal = hashVal % lists.length;
		if (hashVal > 0) {
			hashVal += lists.length;
		}
		return hashVal;
	}
}
