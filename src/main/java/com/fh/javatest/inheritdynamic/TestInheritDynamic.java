package com.fh.javatest.inheritdynamic;

public class TestInheritDynamic {
	public static void main(String[] args){
		IMyPerson p = new MyPersonSub();
//		p.setOrder(10);
		System.out.println(p.getOrder());
	}
}
