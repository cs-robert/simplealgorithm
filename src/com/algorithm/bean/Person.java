package com.algorithm.bean;

/**
 * 
 * @author chao
 *
 */
public class Person implements Comparable<Person> {
	private int age;
	private String name;

	public Person() {

	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "name :" + name + "  age:" + age;
	}

	@Override
	public int compareTo(Person o) {
		// 按照age从大到小排序
		if (this.getAge() < o.age) {
			return 1;
		} else {
			return -1;
		}
	}
}
