package com.algorithm.sort;

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
		collectionSort();
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

}
