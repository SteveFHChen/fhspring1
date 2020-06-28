package com.fh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.fh.annotation.Hello;
import com.fh.dto.Person;
import com.fh.service.IPersonService;

@Component
@Hello("Lucy")
public class PersonService implements IPersonService {

	public PersonService(){
		System.out.println(this.getClass().getName()+" is constructing.");
	}
	
	@Autowired
	public void initPersonService(){
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called.");
	}
	
	@Bean
	public Person newTom(){
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called to create Tom.");
		
		Person p = new Person();
		p.setId(1002);
		p.setName("Tom");
		return p;
	}
	
	@Hello("Lily")
	public void say(String msg) {
		// TODO Auto-generated method stub
		System.out.println("say "+msg);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}

}
