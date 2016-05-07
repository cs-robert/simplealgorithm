package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimeNumber {

	public static void main(String[] args) {
		boolean a[] = new boolean[10000];
		Arrays.fill(a, true);
		int i = 0, j = 0;
		a[1] = false;
		a[2] = true;
		for (i = 2; i < 100; i++) {
			if (a[i]) {
				for (j = i + i; j < 10000; j = j + i)
					a[j] = false;
			}
		}
		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				System.in));
		try {
			j = 10;
			while (j-- > 0) {
				String numString = bReader.readLine();
				System.out.println(a[Integer.valueOf(numString)]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
