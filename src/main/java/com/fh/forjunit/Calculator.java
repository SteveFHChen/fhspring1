package com.fh.forjunit;

public class Calculator {

	public static int add(int a, int b){
		return a + b;
	}
	
	public static int substract(int a, int b){
		return a - b;
	}
	
	public static int multiple(int a, int b){
		return a * b;
	}
	
	public static int divide(int a, int b){
		if(b==0) throw new RuntimeException("b can not be 0.");
		return a / b;
	}
}
