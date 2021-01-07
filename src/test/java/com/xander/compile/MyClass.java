package com.xander.compile;

public class MyClass{
	public int a = 20;
	public int foo(){
		int b = a + 10;
		return b;
	}
	
	public static void main(String args[]){
		MyClass my = new MyClass();
		System.out.println("b = " + my.foo());
		System.out.println(System.getProperty("java.home"));
	}
}