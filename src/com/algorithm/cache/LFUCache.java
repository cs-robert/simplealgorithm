package com.algorithm.cache;

import java.util.Collections;
import java.util.LinkedHashMap;

/**
 * 
 * @author chao
 * @param <K>
 *
 */
public class LFUCache<K, V> extends BaseCache<K, V> {
	private int maxsize = DEFAULT_SIZE;
	protected LinkedHashMap<K, Entry> lfuhashMap = new LinkedHashMap<>();

	class Entry implements Comparable<Entry> {
		K key;
		V value;
		int hitcount;

		Entry(K key, V value, int hitcount) {
			this.key = key;
			this.value = value;
			this.hitcount = hitcount;
		}

		@Override
		public int compareTo(Entry param) {
			return hitcount - param.hitcount;

		}

		@Override
		public String toString() {
			return value.toString();
		}
	}

	public LFUCache(int size) {
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
		Entry oldobj = lfuhashMap.get(key);
		int oldvalue = 1;
		if (oldobj != null) {
			currentsize = currentsize - getObjSize(oldobj.value);
			lfuhashMap.remove(key);
			oldvalue = oldobj.hitcount + 1;
		}
		currentsize = currentsize + getObjSize(value);
		reset();
		lfuhashMap.put(key, new Entry(key, value, oldvalue));

	}

	@Override
	public V get(K key) {
		Entry current = lfuhashMap.get(key);
		if (current == null) {
			return null;
		}
		current.hitcount++;
		return lfuhashMap.get(key).value;
	}

	protected void reset() {
		while (currentsize > maxsize) {
			LFUCache<K, V>.Entry minhit = Collections.min(lfuhashMap.values());
			lfuhashMap.remove(minhit.key);
			currentsize = currentsize - getObjSize(minhit.value);
		}
	}

	public void printAll() {
		System.out.println("currentSize: " + currentsize);
		System.out.println("info:" + lfuhashMap);
		System.out.println("keyset:" + lfuhashMap.keySet());
		System.out.println();
		// System.out.println("max size" + maxsize);
	}
}
