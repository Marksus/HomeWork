package a06createMatrix;

public class CreatingMatrix {
	public static void main(String[] args) {
		int[][] matrix = new int[10][20];
		releasIt(matrix);
	}

	private static void releasIt(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if ((i % 10 == j % 10) || (10 - i % 10 == j % 10)) {
					matrix[i][j] = 1;
					System.out.print(1);
				} else {
					matrix[i][j] = 0;
					System.out.print(0);
				}
			}
			System.out.println();
		}
	}
}
