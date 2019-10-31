package com.tyss;
class TestA{
	public static int a=10;
	public static void show() {
		System.out.println("this is show method of super class..");
	}
}
class TestB extends TestA{
    TestB() {
		
	}
}
public class Test2 {
	public static void main(String[] args) {
		TestB testB=new TestB();
		System.out.println(TestB.a);
        TestB.show();
	}
}
