package cn.ccs.exeorder;

public class Mymain {
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main app run..");
		B b = new B();
//		B b = new B(22);
		b.methodA();

		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 
}
 