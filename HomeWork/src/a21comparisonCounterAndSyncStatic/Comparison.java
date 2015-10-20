package a21comparisonCounterAndSyncStatic;

public class Comparison {

	public static void main(String[] args) {

		Counter counter = new Counter();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Counter started");
				long startTime = System.nanoTime();
				while (counter.get() < 100_000_000) {
					counter.inc();
				}
				System.out.println("Counter ended at " + (System.nanoTime() - startTime));
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("SyncStatic started");
				long startTime = System.nanoTime();
				while (SyncStatic.getCount() < 100_000_000) {
					SyncStatic.inc();
				}
				System.out.println("SyncStatic ended at " + (System.nanoTime() - startTime));
			}
		});

		t1.start();
		t2.start();

	}

}
