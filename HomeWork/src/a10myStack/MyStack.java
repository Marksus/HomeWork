package a10myStack;

public class MyStack<T> {

	Node<T> first;

	public void push(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		node.next = first;
		first = node;
	}

	public T pop() {
		if (first != null) {
			T obj = peek();
			first = first.next;
			return obj;
		} else {
			System.out.println("Empty stack!");
			return null;
		}
	}

	public T peek() {
		if (first != null) {
			return first.data;
		} else {
			System.out.println("Empty stack!");
			return null;
		}
	}

}