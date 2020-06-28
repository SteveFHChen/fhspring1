package com.fh.springaop.aop_xml;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class MyAdvice_Aop implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor {

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		System.out.println("This is BeforeAdvice...111");
	}

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		System.out.println("This is AfterAdvice...");
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result=null;
		String stu_name=invocation.getArguments()[0].toString();
		if(stu_name.equals("Lucy")){
			System.out.println(stu_name+" is not new student.");
		}else{
			System.out.println("invocation proceed before.");
			System.out.println(stu_name+" is new student.");
			result=invocation.proceed();
			System.out.println("invocation proceed complete.");
		}
		return result;
	}


}
