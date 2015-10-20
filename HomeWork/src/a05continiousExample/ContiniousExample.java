package a05continiousExample;

import java.util.Random;

public class ContiniousExample {
	public static void main(String[] args) {
		int[][] matrix;
		matrix = generate(50, 50);
		calc(matrix);

	}

	private static int[][] generate(int i, int j) {
		int[][] s = new int[i][j];

		for (int x = 0; x < i; x++) {
			for (int y = 0; y < j; y++) {
				s[x][y] = (new Random()).nextInt(8);
			}
		}
		return s;
	}

	private static void calc(int[][] matrix) {
		int sum = 0;

		GETIT: for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
				if (sum >= 100) {
					sum = 0;
					System.out.println("In line " + (i + 1) + " we got it on step " + (j + 1));
					continue GETIT;
				}
			}
			sum = 0;
		}
	}

}
