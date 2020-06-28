package com.fh.javatest.jmx;

import javax.management.MBeanRegistration;
import javax.management.MBeanServer;
import javax.management.ObjectName;

public class HelloWorld implements HelloWorldMBean, MBeanRegistration {
	
    private String name;    
    
    public String getName() {    
        return name;    
    }    
   
    public void setName(String name) {    
        this.name = name;    
    }    
   
    public void printHello() {    
        System.out.println("Hello World, " + name);    
    }    
   
    public void printHello(String whoName) {    
        System.out.println("Hello , " + whoName);    
    }

	public ObjectName preRegister(MBeanServer server, ObjectName name)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+" preRegister() is called.");
		return name;
	}

	public void postRegister(Boolean registrationDone) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+" postRegister() is called.");
	}

	public void preDeregister() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName()+" preDeregister() is called.");
	}

	public void postDeregister() {
		// TODO Auto-generated method stub
		
	}    

}