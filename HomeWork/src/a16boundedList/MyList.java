package a16boundedList;

import java.util.Iterator;

public class MyList<T> implements Iterable<T> {

	final int MAX_SIZE;
	int size;

	public MyList(int size) {
		if (size < 0) {
			throw new IllegalArgumentException();
		}
		MAX_SIZE = size;
	}

	private class Node {
		T data;
		Node next;
	}

	Node first;
	Node current;

	public void add(T data) throws ListOverFlowException {
		if (size < MAX_SIZE)
			throw new ListOverFlowException("Overflow: max size = " + MAX_SIZE);
		Node node = new Node();
		node.data = data;
		node.next = first;
		first = node;
		size++;
	}

	public T get(int index) throws ListUnderFlowException, OutOfBoundsListException {
		if (0 == size)
			throw new ListUnderFlowException("Underflow");
		if (index >= size)
			throw new OutOfBoundsListException("Out of bounds of list: size = " + size);
		int current = 0;
		Node currentNode = first;
		while (current < index) {
			currentNode = currentNode.next;
			current++;
		}
		return currentNode.data;
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
		return new Iterator<T>() {
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
	}
}
