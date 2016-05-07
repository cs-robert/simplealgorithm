package com.algorithm.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {
	private class Node<T> {
		public Node() {

		}

		public Node(T ele, Node next, Node pre) {
			this.ele = ele;
			this.next = next;
			this.pre = pre;
		}

		T ele;
		Node next;
		Node pre;
	}

	private Node<E> head;
	private Node<E> tail;
	private int size;
	private int modcount = 0;

	public MyLinkedList() {
		clear();
	}

	public void clear() {
		head = new Node<E>(null, null, null);
		tail = new Node<E>(null, head, null);
		head.next = tail;
		size = 0;
		modcount++;

	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<E> {
		private Node<E> current = head.next;
		private boolean okToremove = false;
		private int expectedModcount = modcount;

		@Override
		public boolean hasNext() {
			return current != tail;
		}

		@Override
		public E next() {
			if (modcount != expectedModcount) {
				throw new ConcurrentModificationException();
			} else if (!hasNext()) {
				throw new NoSuchElementException();
			}
			current = current.next;
			okToremove = true;
			return (E) current.pre.ele;
		}

		@Override
		public void remove() {
			if (!okToremove) {
				throw new IllegalStateException();
			} else if (modcount != expectedModcount) {
				throw new ConcurrentModificationException();
			}
			MyLinkedList.this.remove(current.pre);
			okToremove = false;
			expectedModcount++;
		}
	}

	public boolean isempty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> p = null;
		if (index < size / 2) {
			p = head.next;
			for (int i = 0; i < index; i++)
				p = p.next;
		} else {
			p = tail;
			for (int i = size; i > index; i--)
				p = p.pre;
		}
		return p;
	}

	public E get(int index) {
		return (E) getNode(index).ele;
	}

	private E remove(Node node) {
		node.next.pre = node.pre;
		node.pre.next = node.next;
		size--;
		modcount++;
		return (E) node.ele;
	}

	public E remove(int index) {
		return remove(getNode(index));
	}

	public void add(int index, E ele) {
		addBefore(getNode(index), ele);
	}

	private void addBefore(Node node, E ele) {
		Node newnode = new Node<E>(ele, node.pre, node);
		node.pre.next = newnode;
		node.pre = newnode;
		size++;
		modcount++;
	}

	public void add(E ele) {
		add(size, ele);
	}
}