package a07inheritanceForms;

public class Combination {
	public interface Flyable {
		public abstract void fly();
	}

	public interface Walkable {
		public abstract void walk();
	}

	class Parrot implements Flyable, Walkable {
		@Override
		public void fly() {
			System.out.println("Flying");
		}

		@Override
		public void walk() {
			System.out.println("Walking");
		}
	}
}
