package com.algorithm.cache;

/**
 * 
 * @author chao
 * @param <K>
 * @param <V>
 *
 */
public interface ICache<K, V> {
	public static final int DEFAULT_SIZE = 10;

	public void put(K key, V value);

	public V get(K key);

	public V remove(K key);
}
