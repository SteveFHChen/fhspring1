package com.fh.springaop.aop_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
	/**
	 * 为了使用Spring的AOP注解功能，必须导入如下几个包。aspectjrt.jar,aspectjweaver.jar,cglib-nodep.jar.
	 * 自定义注解 + AOP， 实现AOP记录日志，理解日志记录、事务管理、按全控制等功能实现的原理。
	 * 有了自定义注解和AOP编程，就使得编程不再需要像以前那样去理解整个程序流程，从main()开始；
	 * 现在通过AOP可以使得程序可以从任何切面切点增加程序代码。
	 */
	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/fh/springaop/aop_annotation/applicationContext_annotation.xml");
		IStudent stu = (IStudent)ctx.getBean("student");
		stu.addStudent("Tom");
	}
}
