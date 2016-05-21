package com.algorithm;

/**
 * 并查集算法简单实现
 * 
 * @author chao
 *
 */
public class UnionFind {
	static int p[] = new int[100];

	public static void main(String[] args) {
		p[0] = 1;
		p[2] = 0;

	}

	public static int find(int n) {
		if (p[n] != n) {
			p[n] = find(p[n]);
		}
		return p[n];
	}

	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return;
		} else {
			p[a] = b;
		}
	}
}
