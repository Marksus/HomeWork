package a07inheritanceForms;

public class Construction {

	class Calculator {
		int result = 0;

		public void addition(int x, int y) {
			result = x + y;
		}

		public void sabtraction(int x, int y) {
			result = x - y;
		}

		public void multiplication(int x, int y) {
			result = x * y;
		}

		public void division(int x, int y) {
			result = x / y;
		}

		public void showResult() {
			System.out.println("Result = " + result);
		}
	}

	class Counter extends Calculator { // Счетчик, подсчитывает нажатия
		public void reset() {
			result = 0;
		}

		public void push() {
			addition(result, 1);
		}

		public void getCount() {
			System.out.println("Pushed " + result + " times");
		}
	}

}
