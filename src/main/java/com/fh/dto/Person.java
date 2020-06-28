package com.fh.dto;

import org.springframework.beans.factory.BeanNameAware;

public class Person implements BeanNameAware {

	private String beanName;
	
	private int id;
	private String name;
	
	public void init(){
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called."+this);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getSimpleName()+" id["+this.id+"], name["+this.name+"]";
	}

	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Check the purpose of the interface Aware in Spring framework:");
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called."+this);
		this.beanName = name;
	}
}
