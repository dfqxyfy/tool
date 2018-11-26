package cn.ccs.locksync;

class ThreadA {
	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start();
		System.out.println("b is start....");
		synchronized (b)
		{
			try {
				System.out.println("Waiting for b to complete...");
				b.wait();
				System.out.println("Completed.Now back to main thread");
			} catch (Exception e) {
				System.out.println("interupted");
			}
		}

		System.out.println("Total is :" + b.total);
	}
}
 
class ThreadB extends Thread {
	int total;
 
	public void run() {
		synchronized (this) {
			System.out.println("ThreadB is running..");
			for (int i = 0; i < 5; i++) {
				total += i;
				System.out.println("total is " + total);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//notify();
		}
	}
}
