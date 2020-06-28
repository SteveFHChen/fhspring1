package com.fh.springaop.aop_xml;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class MyAdvice2_CoreAop implements MethodInterceptor,
		org.aopalliance.intercept.MethodInterceptor {


	//This is from aopalliance
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		Object result=null;
		String stu_name=invocation.getArguments()[0].toString();
		if(stu_name.equals("Lucy")){
			System.out.println(stu_name+" is not new student.");
		}else{
			System.out.println("[aopalliance] invocation proceed before.");
			System.out.println(stu_name+" is new student.");
			result=invocation.proceed();
			System.out.println("[aopalliance] invocation proceed complete.");
		}
		return result;
	}

	//This is from Spring AOP - spring core - cglib
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		Object result=null;
		
		String stu_name=args[0].toString();
		if(stu_name.equals("Lucy")){
			System.out.println(stu_name+" is not new student.");
		}else{
			System.out.println("[spring core - cglib] invocation proceed before.");
			System.out.println(stu_name+" is new student.");
			
//			Object result = method.invoke(obj, args);
//			proxy.invoke(obj, args);
			result = proxy.invokeSuper(obj, args);
			
			System.out.println("[spring core - cglib] invocation proceed complete.");
		}
		return result;
	}  

}
