package com.fh.springaop;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.Enhancer;

import com.fh.springaop.aop_xml.IStudent;
import com.fh.springaop.aop_xml.StudentImpl;
import com.fh.springaop.aop_xml.MyAdvice2_CoreAop;

public class TestStudent_JdkCglibProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IStudent stu = new StudentImpl();
		MyAdvice2_CoreAop adv = new MyAdvice2_CoreAop();
		
		System.out.println("Test - Using spring-core cglib proxy to implement AOP");
		/*Enhancer enhancer = new Enhancer();  
        //Set target
        enhancer.setSuperclass(StudentImpl.class);
        //Set callback
        enhancer.setCallback(adv);
        //This statement creates a proxy.
        StudentImpl proxy = (StudentImpl) enhancer.create();
        proxy.addStudent("Lucy2");*/
        
        System.out.println("----------------------");
        
        System.out.println("Test - Using spring-aop cglib proxy to implement AOP");
		//通过代理工厂完成目标对象和通知对象的组装
        
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(stu);
		pf.addAdvice(adv);
		
		IStudent proxy2 = (IStudent)pf.getProxy();
		proxy2.addStudent("Zhang3");
		
		System.out.println("----------------------");
		
		System.out.println("Test - Using spring-aop jdk proxy to implement AOP");
	}

}
