package a13iteratorInAllTypes;

import java.util.Iterator;

public class MyListWithLocalIterator<T> implements Iterable<T> {

	private class Node {
		T data;
		Node next;
	}

	Node first;
	Node current;

	public void add(T data) {
		Node node = new Node();
		node.data = data;
		node.next = first;
		first = node;
	}

	@Override
	public String toString() {

		String s = "[";

		Node temp = first;

		while (temp != null) {
			s += temp.data;
			s += ", ";
			temp = temp.next;
		}

		return s + "]";
	}

	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {
			Node current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public T next() {
				T data = current.data;
				current = current.next;
				return data;
			}
		};
		return iterator;
	}
}
