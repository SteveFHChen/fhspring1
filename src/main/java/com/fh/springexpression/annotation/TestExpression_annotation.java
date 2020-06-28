package com.fh.springexpression.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestExpression_annotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/fh/springexpression/annotation/applicationContext_annotation1.xml");
		Customer cust = ctx.getBean("customerBean", Customer.class);
		System.out.println(cust);
		System.out.println(cust.toString("Test operator use:"));
	}

}
