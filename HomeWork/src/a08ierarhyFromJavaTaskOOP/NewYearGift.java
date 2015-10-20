package a08ierarhyFromJavaTaskOOP;

public class NewYearGift {
	Sweets[] sweetsset;

	public static void main(String[] args) {

		NewYearGift gift = new NewYearGift();

		gift.sweetsset = new Sweets[] { new Candy(), new Candy(), new Candy(), new Candy() };

		System.out.println("Gift collected!");
	}
}
