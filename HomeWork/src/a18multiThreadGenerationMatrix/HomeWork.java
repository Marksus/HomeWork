package a18multiThreadGenerationMatrix;

import java.util.Random;

public class HomeWork {

	public static void main(String[] args) {

		System.out.println("start");
		double[][] matrix = generate();

		System.out.println("generated");

		long start = System.nanoTime();
		process(matrix);
		long stop = System.nanoTime();

		System.out.println("Elapsed = " + (stop - start));

	}

	private static void process(double[][] matrix) {

		Thread[] threads = new Thread[matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			final double[] row = matrix[i];
			threads[i] = new Thread() {
				@Override
				public void run() {
					processRow(row);
				};
			};
			threads[i].start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void processRow(double[] ds) {
		for (int i = 0; i < ds.length; i++) {
			Math.pow(ds[i], ds[i]);
		}
	}

	private static double[][] generate() {

		Random random = new Random();

		double[][] matrix = new double[10][10_000_000];
		Thread[] threads = new Thread[matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			final int row = i;
			threads[i] = new Thread() {
				@Override
				public void run() {
					for (int j = 0; j < matrix[row].length; j++) {
						matrix[row][j] = random.nextDouble();
					}
				}
			};
			threads[i].start();

		}
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return matrix;
	}

}