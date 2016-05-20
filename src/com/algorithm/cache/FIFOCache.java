package com.algorithm.cache;

/**
 * 
 * @author chao
 * @param <T>
 *
 */
public class FIFOCache<K, V> extends BaseCache<K, V> {
	private int maxsize = DEFAULT_SIZE;

	public FIFOCache(int size) {
		if (maxsize <= 0) {
			return;
		}
		this.maxsize = size;
	}

	public void put(K key, V value) {
		int valuesize = getObjSize(value);
		if (valuesize > maxsize) {
			System.out.println("error : the object is too large!!!");
			return;
		}
		V oldobj = hashMap.get(key);
		if (oldobj != null) {
			currentsize = currentsize - getObjSize(oldobj);
		}
		currentsize = currentsize + getObjSize(value);
		reset();
		hashMap.put(key, value);

	}

	protected void reset() {
		while (currentsize > maxsize) {
			super.remove(hashMap.keySet().iterator().next());

		}
	}

	public void printAll() {
		super.printAll();
		System.out.println("keyset: " + hashMap.keySet());
		System.out.println();
		// System.out.println("max size: " + maxsize);
	}
}
