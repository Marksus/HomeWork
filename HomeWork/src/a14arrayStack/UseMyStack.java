package a14arrayStack;

import java.util.Iterator;

public class UseMyStack {

	public static void main(String[] args) {
		MyStack<String> myStack = new MyStack<String>() {
			{
				push("one");
				push("two");
				push("three");
			}
		};

		Iterator<String> it = myStack.iterator();
		while (it.hasNext())
			System.out.println(it.next());

		System.out.println();

		System.out.println(myStack.top());
		System.out.println("After top() stack size is " + myStack.size());
		System.out.println(myStack.pop());
		System.out.println("After pop() stack size is " + myStack.size());

		System.out.println();

		for (String string : myStack) {
			System.out.println(string);
		}

	}

}
