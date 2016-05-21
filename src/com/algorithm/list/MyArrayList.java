package com.algorithm.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private int theSize;
	private E[] theItems;

	public MyArrayList() {
		clear();
	}

	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize) {
			return;
		}
		E[] oldEs = theItems;
		theItems = (E[]) new Object[newCapacity];
		for (int i = 0; i < theSize; i++) {
			theItems[i] = oldEs[i];
		}

	}

	public int size() {
		return theSize;
	}

	public void trimToSize() {
		ensureCapacity(size());
	}

	public boolean isEmpty() {
		return theSize == 0;
	}

	public E get(int index) {
		if (index < 0 || index > theSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[index];

	}

	public E set(int index, E newval) {
		if (index < 0 || index >= theSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		E oldvallue = theItems[index];
		theItems[index] = newval;
		return oldvallue;
	}

	@Override
	public Iterator<E> iterator() {
		return new ArraylistIterator();
	}

	public boolean add(E value) {
		add(size(), value);
		return true;
	}

	public void add(int index, E value) {
		if (theItems.length == theSize) {
			ensureCapacity(theSize * 2 + 1);
		}
		for (int i = theSize; i > index; i--) {
			theItems[i] = theItems[i - 1];
		}
		theItems[index] = value;
		theSize++;
	}

	public E remove(int index) {
		E oldvalue = theItems[index];
		for (int i = index; i < theSize; i++) {
			theItems[i] = theItems[i + 1];
		}
		theSize--;
		return oldvalue;
	}

	class ArraylistIterator<E> implements Iterator<E> {
		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < theSize;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return (E) theItems[current++];
		}

		@Override
		public void remove() {
			MyArrayList.this.remove(--current);
		}

	}
}
