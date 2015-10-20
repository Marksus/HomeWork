package a19fivePhilosophers;

import java.util.ArrayList;
import java.util.List;

public class Dinner {

	static class Stick {
		int number;

		public Stick(int number) {
			this.number = number;
		}
	}

	static class Philosopher implements Runnable {
		int number;
		Stick stickLeft;
		Stick stickRight;

		public Philosopher(int number, Stick stickLeft, Stick stickRight) {
			this.number = number;
			this.stickLeft = stickLeft;
			this.stickRight = stickRight;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			synchronized (Thread.currentThread()) {
				Thread.currentThread().notify();
			}

			System.out.println(number + " say : 'Im sit'!");

			while (true) {
				synchronized (Thread.currentThread()) {
					try {
						Thread.currentThread().wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				eating();

				synchronized (Thread.currentThread()) {
					Thread.currentThread().notify();
				}

				thinking();
			}
		}

		private void thinking() {
			System.out.println(this.number + " start thinking");
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.number + "end thinking");
		}

		private void eating() {
			synchronized (stickLeft) {
				takeIt(stickLeft);
				synchronized (stickRight) {
					takeIt(stickRight);
					System.err.println(this.number + "start eat");
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.err.println(this.number + "end eat");
				}
			}
		}

		private void takeIt(Stick stick) {
			System.out.println(this.number + " take stick number " + stick.number);
		}

	}

	public static void main(String[] args) {
		List<Stick> sticks = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			sticks.add(new Stick(i));
		}

		List<Thread> thinkers = new ArrayList<>();

		thinkers.add(new Thread(new Philosopher(1, sticks.get(0), sticks.get(1))));
		thinkers.add(new Thread(new Philosopher(2, sticks.get(1), sticks.get(2))));
		thinkers.add(new Thread(new Philosopher(3, sticks.get(2), sticks.get(3))));
		thinkers.add(new Thread(new Philosopher(4, sticks.get(3), sticks.get(4))));
		thinkers.add(new Thread(new Philosopher(5, sticks.get(4), sticks.get(0))));

		System.out.println("Let the dinner begin!!!");

		for (int i = 0; i < thinkers.size(); i++) {
			thinkers.get(i).start();
			System.out.println(i + "started");
			try {
				synchronized (thinkers.get(i)) {
					thinkers.get(i).wait();
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("start");

		while (true) {
			synchronized (thinkers.get(0)) {
				thinkers.get(0).notify();
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			synchronized (thinkers.get(2)) {
				thinkers.get(2).notify();
			}
			try {
				synchronized (thinkers.get(0)) {
					thinkers.get(0).wait();
				}
				synchronized (thinkers.get(2)) {
					thinkers.get(2).wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (thinkers.get(1)) {
				thinkers.get(1).notify();
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			synchronized (thinkers.get(3)) {
				thinkers.get(3).notify();
			}
			try {
				synchronized (thinkers.get(1)) {
					thinkers.get(1).wait();
				}
				synchronized (thinkers.get(3)) {
					thinkers.get(3).wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (thinkers.get(4)) {
				thinkers.get(4).notify();
			}
			try {
				synchronized (thinkers.get(4)) {
					thinkers.get(4).wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
