package a12dogsMoods;

public class BadMood implements Dog.BrainState {
	Dog dog;

	public BadMood(Dog dog) {
		this.dog = dog;
	}

	@Override
	public void feed() {
		dog.eat();
		dog.brainState = new GoodMood(dog);
	}

	@Override
	public void stroke() {
		dog.bite();
	}

}
