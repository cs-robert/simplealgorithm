package com.algorithm.hash;

/**
 * 散列函数
 * 
 * @author chao
 *
 */
public class HashFunction {
	/**
	 * 简单hash
	 * 
	 * @param key
	 * @param tablesize
	 * @return
	 */
	public static int hash1(String key, int tablesize) {
		int hashVal = 0;
		for (int i = 0; i < key.length(); i++) {
			hashVal += key.charAt(i);
		}
		return hashVal % tablesize;
	}

	/**
	 * 较好的散列函数
	 * 
	 * @param key
	 * @param tablesize
	 * @return
	 */
	public static int hash2(String key, int tablesize) {
		int hashVal = 0;
		for (int i = 0; i < key.length(); i++) {
			hashVal = 37 * hashVal + key.charAt(i);
		}
		hashVal = hashVal % tablesize;
		if (hashVal < 0) {
			hashVal += tablesize;
		}
		return hashVal;
	}
}
