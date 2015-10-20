package a07inheritanceForms;

public class Specification {
	abstract class Robot {
		abstract void move();
	}

	class RobotOnWheels extends Robot {
		@Override
		void move() {
			System.out.println("Rotating wheels");
		}
	}
}
