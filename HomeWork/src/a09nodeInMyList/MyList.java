package a09nodeInMyList;

public class MyList<T> {

	Node<T> first;

	public void add(T data) {
		Node<T> node = new Node<T>();
		node.data = data;
		if (null != first) {
			Node<T> temp = first;
			while (true) {
				if (null != temp.next) {
					temp = temp.next;
				} else {
					temp.next = node;
					break;
				}
			}
		} else
			first = node;
	}

	@Override
	public String toString() {

		String s = "[";

		Node<T> temp = first;

		while (temp != null) {
			s += temp.data;
			s += ", ";
			temp = temp.next;
		}

		return s + "]";
	}

}
