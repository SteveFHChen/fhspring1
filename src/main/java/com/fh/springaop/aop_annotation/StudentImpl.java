package com.fh.springaop.aop_annotation;

import org.springframework.stereotype.Component;

@Component("student")
public class StudentImpl implements IStudent {

	/**
	 * 自定义注解 + AOP， 实现AOP记录日志，理解日志记录、事务管理、按全控制等功能实现的原理。
	 */
	@FHLogAnnotation(moduleName="Student M1", logMessage="call addStudent()...")
	public void addStudent(String name) {
		System.out.println("Welcome "+name+" coming...");
	}

}
