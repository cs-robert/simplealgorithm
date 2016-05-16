package com.algorithm.cache;

import java.sql.ResultSet;
import java.util.LinkedHashMap;

/**
 * 
 * @author chao
 * @param <V>
 * @param <K>
 *
 */
public class BaseCache<K, V> implements ICache<K, V> {
	protected int currentsize = 0;
	protected LinkedHashMap<K, V> hashMap = new LinkedHashMap<>();

	@Override
	public void put(K key, V value) {
		V oldobj = hashMap.get(key);
		if (oldobj != null) {
			currentsize = currentsize - getObjSize(oldobj);
			hashMap.remove(key);
		}
		currentsize = currentsize + getObjSize(value);
		reset();
		hashMap.put(key, value);

	}

	@Override
	public V get(K key) {
		return hashMap.get(key);
	}

	@Override
	public V remove(K key) {
		V valueObject = hashMap.remove(key);
		currentsize = currentsize - getObjSize(valueObject);
		return valueObject;
	}

	protected void reset() {

	}

	public int getObjSize(V obj) {
		if (obj == null) {
			return 0;
		} else if (obj instanceof String) {
			return ((String) obj).getBytes().length;
		}
		return 1;
	}

	public void printAll() {
		System.out.println("currentSize: " + currentsize);
		System.out.println("info:" + hashMap);
	}

}
