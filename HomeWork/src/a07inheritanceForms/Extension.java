package a07inheritanceForms;

public class Extension {
	class Robot {
		public void turnLeft() {
		}

		public void turnRight() {
		}

		public void forward() {
		}

		public void back() {
		}
	}

	class LoaderBot extends Robot {
		public void takeBlock() {
		}

		public void putBlock() {
		}
	}
}