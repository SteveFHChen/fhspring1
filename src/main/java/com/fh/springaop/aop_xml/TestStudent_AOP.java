package com.fh.springaop.aop_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent_AOP {
	/**
	 * 以配制的方式利用动态代理来实现AOP编程
	 */
	public static void main(String args[]){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/fh/springaop/aop_xml/applicationContext_aopxml.xml");
		IStudent stu = (IStudent)ctx.getBean("student");
		stu.addStudent("Tom");
	}
	/**
	 * 注意理解AOP编程中的一些概念：
	 * PointCut, Advice, Advisor, Aspect, Joinpoint
	 * 注意区别Advisor和Aspect：
	 * Advisor一次只能将一个advice和一个pointcut关联，而
	 * 注意这些概念在AOP Annotation编程中的使用。
	 * 
	 * 请问：使用<Advisor/>去关联pointcut和advice的话，那advice是在执行方法的什么时间被执行？
	 * 
	 * 参考具有<advice/>配制的实例：http://crud0906.iteye.com/blog/1143030
	 */
}
