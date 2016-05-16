package com.algorithm.cache;

/**
 * 
 * @author chao
 *
 */
public class LRUCache<K, V> extends BaseCache<K, V> {
	private int maxsize = DEFAULT_SIZE;

	public LRUCache(int size) {
		if (maxsize <= 0) {
			return;
		}
		this.maxsize = size;
	}

	@Override
	public void put(K key, V value) {
		int valuesize = getObjSize(value);
		if (valuesize > maxsize) {
			System.out.println("error : the object is too large!!!");
			return;
		}
		super.put(key, value);

	}

	protected void reset() {
		while (currentsize > maxsize) {
			super.remove(hashMap.keySet().iterator().next());
		}
	}

	public void printAll() {
		super.printAll();
		System.out.println("keyset:" + hashMap.keySet());
		System.out.println();
		// System.out.println("max size" + maxsize);
	}
}
