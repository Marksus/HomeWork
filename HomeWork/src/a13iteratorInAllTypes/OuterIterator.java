package a13iteratorInAllTypes;

import java.util.Iterator;

public class OuterIterator<T> implements Iterator<T> {

	MyListWithOuterIterator.Node current;

	public OuterIterator(MyListWithOuterIterator mlwoi) {
		current = mlwoi.first;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		T data = (T) current.data;
		current = current.next;
		return data;
	}

}
