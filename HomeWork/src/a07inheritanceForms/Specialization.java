package a07inheritanceForms;

public class Specialization {
	class CarSeller {
		public void sellCar() {
		}
	}

	class LamborginiSeller extends CarSeller {
		public void sellCar() {
			makeClientFeelingGood();
			setPriceOver100_000dollars();
			sellCar();
		}

		private void setPriceOver100_000dollars() {
		}

		private void makeClientFeelingGood() {
		}
	}
}
