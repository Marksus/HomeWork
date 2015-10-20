package a03massiveSumm;

public class MassiveSumm {
	public static void main(String[] args) {
		int[][] msv = { { 1, 5, 3, 9, 6 }, { 4, 5, 6 }, { 1, 1, 9, 9, 9, 9, 8 }, { 3, 6, 2, 8 } };
		int summ = 0;

		for (int i = 0; i < msv.length; i++) {
			for (int j = 0; j < msv[i].length; j++) {
				summ += msv[i][j];
			}
		}

		System.out.println("Summ = " + summ);
	}
}
