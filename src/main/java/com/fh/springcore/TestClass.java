package com.fh.springcore;

import java.lang.annotation.Annotation;

import com.fh.service.impl.PersonService;

public class TestClass {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class clazz = PersonService.class;
		System.out.println(clazz);
		
		Class[] intefaces = clazz.getInterfaces();
		System.out.println(intefaces);
		
		Class parent = clazz.getSuperclass();
		System.out.println(parent);
		
		Annotation[] anns = clazz.getAnnotations();
		System.out.println(anns);
		
		Annotation[] danns = clazz.getDeclaredAnnotations();
		System.out.println(danns);
	}

}
