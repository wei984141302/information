package test;

import java.util.Random;
public class ProducerConsumer {

	static WareHouse wareHouse = new WareHouse();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			new Thread(new Produce()).start();
			new Thread(new Consumer1()).start();
		}

	}

	static class Produce implements Runnable {

		@Override
		public void run() {
			while (true) {
				Object X = (new Random()).nextInt(9999);
				try {
					
					wareHouse.putProduce(X);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	static class Consumer1 implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					wareHouse.getProduce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
