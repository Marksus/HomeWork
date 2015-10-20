package a02sortMassive;

public class SortMassive {
	int[] massive = new int[100];

	public static void main(String[] args) {
		SortMassive m = new SortMassive();
		fill(m.massive);

		sort(m.massive);

		m.print();
	}

	public static void fill(int[] massive) {
		for (int i = 0; i < massive.length; i++) {
			massive[i] = (new java.util.Random()).nextInt(1000000);
		}
	}

	public static void sort(int[] s) {
		boolean sortEnd = false;
		while (!sortEnd) {
			sortEnd = true;
			for (int i = 1; i < s.length; i++) {
				if (s[i - 1] > s[i]) {
					s[i - 1] += s[i];
					s[i] = s[i - 1] - s[i];
					s[i - 1] = s[i - 1] - s[i];// replacing s[i-1] and s[i]

					sortEnd = false;
				}
			}
		}
	}

	public void print() {
		System.out.print("[" + massive[0]);
		for (int i = 1; i < massive.length; i++) {
			System.out.print(" ," + massive[i]);
		}
		System.out.println("]");
	}

}
