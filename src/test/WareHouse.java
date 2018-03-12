package test;

import java.util.concurrent.Semaphore;

public class WareHouse {
	int num = 10;
	Semaphore mutex = new Semaphore(1);
	Semaphore site = new Semaphore(num); 
	Semaphore produce = new Semaphore(0);
	Object[] items = new Object[num];
	int putSite = 0, getSite = 0, count = 0;

	public Object getProduce() throws InterruptedException {
		produce.acquire();
		mutex.acquire();
		Object x = items[getSite];
		System.out.println("从仓库获得产品：	"+x);
		if (++getSite == items.length)
			getSite = 0;
		mutex.release();
		site.release();

		return x;
	}

	public void putProduce(Object X) throws InterruptedException {

		site.acquire();
		mutex.acquire();
		items[putSite++] = X;
		System.out.println("放入产品到仓库："+X);
		if (putSite == items.length)
			putSite = 0;
		mutex.release();
		produce.release();

	}
}

