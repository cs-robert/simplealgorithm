package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 素数打表
 * 
 * @author chao
 *
 */
public class PrimeNumber {

	static boolean num[] = new boolean[10000];
	// 初始化素数表
	static {
		Arrays.fill(num, true);
		int i = 0, j = 0;
		num[0] = false;
		num[1] = false;
		num[2] = true;
		for (i = 2; i < 100; i++) {
			if (num[i]) {
				for (j = i + i; j < 10000; j = j + i)
					num[j] = false;
			}
		}
	}

	public static void main(String[] args) {

		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String numString = bReader.readLine();
			System.out.println(numString
					+ (num[Integer.valueOf(numString)] ? " is a primenumber" : " is not a primenumber"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
