package a21comparisonCounterAndSyncStatic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	private int count;

	private Lock lock = new ReentrantLock();

	public void inc() {

		lock.lock(); // lock
		try {
			count++; // do work
		} finally {
			lock.unlock(); // unlock
		}
	}

	public int get() {

		lock.lock();
		try {
			return count;
		} finally {
			lock.unlock();
		}
	}

}
