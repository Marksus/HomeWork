package a10myStack;

public class UseStack {

	public static void main(String[] args) {

		MyStack<String> stack = new MyStack<>();

		stack.push("One");
		stack.push("Two");
		stack.push("Three");

		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}

}
