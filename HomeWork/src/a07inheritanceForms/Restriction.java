package a07inheritanceForms;

public class Restriction {
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

	class BotOnRails extends Robot {
		@Override
		public void turnLeft() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void turnRight() {
			throw new UnsupportedOperationException();
		}
	}
}
