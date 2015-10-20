package a13iteratorInAllTypes;

import java.util.Iterator;

public class MyListWithOuterIterator<T> implements Iterable<T> {

	class Node {
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
		return new OuterIterator<T>(this);
	}
}
