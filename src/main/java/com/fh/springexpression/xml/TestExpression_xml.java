package com.fh.springexpression.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestExpression_xml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/fh/springexpression/xml/applicationContext_expression1.xml");
		Customer cust = ctx.getBean("customerBean", Customer.class);
		System.out.println(cust);
		
		/*com.fh.springexpression.annotation.Customer cust2 = ctx.getBean("customerBean2", com.fh.springexpression.annotation.Customer.class);
		System.out.println(cust2.toString("Test operator use:"));*/
	}

}
