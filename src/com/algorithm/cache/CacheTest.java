package com.algorithm.cache;

import org.junit.Test;

/**
 * 我们暂且把put相同的key也当成一种命中
 * 
 * @author chao
 *
 */
public class CacheTest {

	public static void main(String[] args) {

	}

	@Test
	public void test() {
		FIFOCache<String, String> fifoCache = new FIFOCache<String, String>(10);
		fifoCache.put("1", "aaa");
		fifoCache.printAll();
		fifoCache.put("2", "bbb");
		fifoCache.printAll();
		fifoCache.put("1", "bdd");
		fifoCache.printAll();
		fifoCache.put("1", "dddddddddd");
		fifoCache.printAll();
		fifoCache.put("3", "e");
		fifoCache.printAll();

		System.out.println("===============");
		LRUCache<String, String> lruCache = new LRUCache<>(10);
		lruCache.put("1", "aaaaaa");
		lruCache.printAll();
		lruCache.put("1", "b");
		lruCache.printAll();
		lruCache.put("2", "c");
		lruCache.printAll();
		lruCache.put("3", "dd");
		lruCache.printAll();
		lruCache.put("1", "ee");
		lruCache.printAll();
		lruCache.put("9", "dddddd");
		lruCache.printAll();

		System.out.println("===============");
		LFUCache<String, String> lfucache = new LFUCache<>(10);
		lfucache.put("1", "aaaaaa");
		lfucache.printAll();
		lfucache.put("1", "b");
		lfucache.printAll();
		lfucache.put("2", "c");
		lfucache.printAll();
		lfucache.put("3", "e");
		lfucache.printAll();
		lfucache.put("9", "dddddddd");
		lfucache.printAll();
	}
}
