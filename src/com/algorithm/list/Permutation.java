package com.algorithm.list;

/**
 * 简单组合
 * 
 * @author chao
 *
 */
public class Permutation {
	public static void permute(char[] ch, int len, int cur) {
		if (cur == len - 1) {
			for (int i = 0; i < len; i++)
				System.out.print(" " + ch[i]);
			System.out.println();
		} else {
			for (int i = cur; i < len; i++) {
				char temp = ch[i];
				ch[i] = ch[cur];
				ch[cur] = temp;
				permute(ch, len, cur + 1);
				temp = ch[i];
				ch[i] = ch[cur];
				ch[cur] = temp;

			}
		}
	}

	public static void main(String[] args) {
		char[] ch = { 'a', 'b', 'c', 'd' };
		permute(ch, ch.length, 0);
	}
}
