package com.fh.javatest.rwbinfilebyblocker;

import java.util.ArrayList;
import java.util.List;

public class T1 {
	/**
	 * Test basic type is put into container,
	 * what will change of the type.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList<>();
		int i=100;
		long l = 200l;
		list.add(i);
		list.add(l);
		
		for(Object obj : list){
			System.out.println(obj.getClass().getName()+" "+obj);
			if(obj.equals(i)) System.out.println("same");
		}
		
		byte[] bs= new byte[6];
		System.out.println(bs.length);
	}

}
