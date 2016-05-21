package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import com.algorithm.bean.Person;

/**
 * description 排序
 * 
 * @author chao
 *
 */
public class JavaSort {

	public static void main(String[] args) {

	}

	/**
	 * 用java Collections sort方法排序
	 */
	public static void collectionSort() {
		ArrayList<Person> personlist = new ArrayList<>();
		Person person = new Person();
		person.setAge(10);
		personlist.add(person);
		person = new Person();
		person.setAge(8);
		personlist.add(person);
		person = new Person();
		person.setAge(9);
		personlist.add(person);
		// 原始序列
		System.out.println(personlist);
		// 按照age从大到小排序
		Collections.sort(personlist);
		System.out.println(personlist);
		// 按照age从小到大排序
		Collections.sort(personlist, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// 按照age从小到大排序
				return o1.getAge() - o2.getAge();
			}
		});
		System.out.println(personlist);
	}

	/**
	 * 简单冒泡排序
	 */
	public static void maopaoTest() {
		int num[] = new int[100];
		String curnum;
		BufferedReader read = new BufferedReader(new InputStreamReader(
				System.in));
		for (int i = 0; i < 10; i++) {
			try {
				curnum = read.readLine();
				num[i] = Integer.valueOf(curnum);
				System.out.print(num[i] + " ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
		int temp;
		for (int i = 1; i < 10; i++)
			for (int j = 0; j < 10 - i; j++) {
				if (num[j] > num[j + 1]) {
					temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
			}
		for (int i = 0; i < 10; i++)
			System.out.print(num[i] + " ");
	}
}
