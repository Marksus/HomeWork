package a20boundedBlockingQueue;

import java.util.Date;
import java.util.Random;

public class UseBlockingQueue {

	static Random random = new Random();

	static class Producer implements Runnable {

		private BlockingQueue<String> queue;

		public Producer(BlockingQueue queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				Utils.pause(2000 + random.nextInt(2000));
				queue.put(new Date().toString());
				System.out.println("produced, total: " + queue.size());
			}
		}
	}

	static class Consumer implements Runnable {

		private BlockingQueue<String> queue;

		public Consumer(BlockingQueue queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				Utils.pause(3000 + random.nextInt(3000));
				String item = queue.take();
				System.err.println(item + " consumed, total: " + queue.size());
			}
		}
	}

	public static void main(String[] args) {
		BlockingQueue<String> queue = new BlockingQueue<>(5);
		new Thread(new Consumer(queue)).start();
		new Thread(new Producer(queue)).start();
	}
}
