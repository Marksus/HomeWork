package a20boundedBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {

	int bound;

	public BlockingQueue(int bound) {
		this.bound = bound;
	}

	private Queue<T> queue = new LinkedList<>();

	public T take() {
		T t;
		synchronized (queue) {
			while (queue.isEmpty()) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			t = queue.poll();
			queue.notify();
		}
		return t;
	}

	public void put(T item) {
		synchronized (queue) {
			while (queue.size() >= bound) {
				try {
					queue.wait();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			queue.offer(item);
			queue.notify();

		}
	}

	public int size() {
		return queue.size();
	}
}