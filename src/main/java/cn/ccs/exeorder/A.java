package cn.ccs.exeorder;

public class A {
 
	int a1 = 8;
	int a2 = getA2();
	{
		int a3 = 9;
		System.out.println("top of A() a1=" + a1 + " a2=" + a2 + "  a3=" + a3);
	}
 
	public A() {
		this(66);
		System.out.print("A 构造函数\n");
	}
 
	{
		System.out.println("below A()..has start");
	}
 
	public A(int num) {
		System.out.print("A 带参数构造函数: " + num + "\n");
	}
 
	static {
		System.out.println("I`m a static {} from class A..");
	}
 
	int getA2() {
		System.out.println("getA2..");
		return 7;
	}
 
	public void methodA() {
		System.out.println("methodA");
	}
 
}