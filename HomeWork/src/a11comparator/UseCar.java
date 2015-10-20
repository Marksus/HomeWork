package a11comparator;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UseCar {
	public static void main(String[] args) {

		List<Car> cars = new LinkedList<Car>();

		cars.add(Car.register("Hyundai", "Solaris", 107, 10000));
		cars.add(Car.register("Mazda", "3", 105, 15000));
		cars.add(Car.register("Skoda", "Superb", 152, 23000));
		cars.add(Car.register("Subaru", "Impreza", 114, 14000));
		cars.add(Car.register("Skoda", "Rapid", 105, 11000));
		cars.add(Car.register("Mazda", "6", 150, 20000));
		cars.add(Car.register("Subaru", "Forester", 150, 30000));
		cars.add(Car.register("Skoda", "Octavia", 110, 14000));

		Collections.sort(cars);
		System.out.println(cars);
		Collections.sort(cars, Car.CAR_NAME_COMPARATOR);
		System.out.println(cars);
		Collections.sort(cars, Car.CAR_POWER_COMPARATOR);
		System.out.println(cars);

	}
}
