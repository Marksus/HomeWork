package a11comparator;

import java.util.Comparator;

public class Car implements Comparable<Car> {

	static class CarNameComparator implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			int x = o1.carName.brand.compareTo(o2.carName.brand);
			if (0 == x)
				return o1.carName.model.compareTo(o2.carName.model);
			else
				return x;
		}
	}

	static class CarPowerComparator implements Comparator<Car> {
		@Override
		public int compare(Car o1, Car o2) {
			if (o1.power < o2.power)
				return -1;
			else if (o1.power > o2.power)
				return 1;
			else
				return 0;
		}
	}

	public static final Comparator<Car> CAR_NAME_COMPARATOR = new CarNameComparator();
	public static final Comparator<Car> CAR_POWER_COMPARATOR = new CarPowerComparator();

	private Car() {
	};

	CarName carName;
	int power;
	int price;

	private static class CarName {
		String brand;
		String model;
	}

	public static Car register(String brand, String model, int power, int price) {
		Car car = new Car();
		car.power = power;
		car.price = price;
		car.carName = new CarName();
		car.carName.brand = brand;
		car.carName.model = model;
		return car;
	}

	@Override
	public int compareTo(Car o) {
		return this.price - o.price;
	}

	@Override
	public String toString() {
		return carName.brand + " " + carName.model + ": power - " + power + ", price - " + price;
	}
}
