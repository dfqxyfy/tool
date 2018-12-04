package cn.ccs.exeorder;

public class B extends A {
 
	int b1 = 0;
	int b2 = getB2();
	{
		int b3 = 5;
		System.out.println("top of B() b1=" + b1 + " b2=" + b2 + " b3=" + b3);
 
	}
 
	public B() {
		this(33);
		// super(44);//添加super语句，会导致实例化时直接执行父类带参数的构造函数
		System.out.print("B 构造函数\n");
	}
 
	public B(int num) {
		// 添加super语句，会导致实例化时直接执行父类带参数的构造函数
		// 前提是带参数的构造函数B会被运行（new实例化或this）
		// super(77);
 
		System.out.print("B 带参数构造函数:" + num + "\n");
	}
 
	{
		System.out.println("below B()..has start");
	}
	static {
		System.out.println("I`m a static {} from class B..");
	}
 
	int getB2() {
		System.out.println("getB2..");
		return 33;
 
	}
 
	@Override
	public void methodA() {
		System.out.println("methoaA int class B");
		super.methodA();
 
	}
 
}