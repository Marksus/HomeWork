package a12dogsMoods;

public class Dog {

	interface BrainState {
		void feed();

		void stroke();
	}

	BrainState brainState = new BadMood(this);

	public void feed() {
		System.out.println("--> feed dog");
		brainState.feed();
	}

	public void stroke() {
		System.out.println("--> stroke dog");
		brainState.stroke();
	}

	// private body methods

	void bite() {
		System.out.println("bites");
	}

	void bark() {
		System.out.println("barks");
	}

	void eat() {
		System.out.println("eats");
	}

	void wag() {
		System.out.println("wags");
	}

}
