package a14arrayStack;

import java.util.Arrays;
import java.util.Iterator;

public class MyStack<T> implements Iterable<T> {

	T[] data = (T[]) new Object[4];
	private int next;

	public void push(T obj) {
		if (next < data.length) {
			data[next++] = obj;
		} else {
			data = Arrays.copyOf(data, size() + 2);
			data[next++] = obj;
		}
	}

	public T pop() {
		if (next > 0) {
			T obj = data[next - 1];
			data[--next] = null;
			return obj;
		}
		return null;
	}

	public T top() {
		if (next > 0) {
			return data[next - 1];
		}
		return null;
	}

	public int size() {
		return next;
	}

	public boolean isEmpty() {
		return 0 == next;
	}

	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int current = next - 1;

			@Override
			public boolean hasNext() {
				if (current >= 0)
					return true;
				return false;
			}

			@Override
			public T next() {
				return data[current--];
			}
		};
	}

}
