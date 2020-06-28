package com.fh.springibatis;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fh.dto.Person;
import com.fh.springibatis.service.IPersonService5;

public class TestApp1SpringIbatisByXML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/springjdbcibatis/fhspring_ibatis_xml.xml");
		for(String name: ctx.getBeanDefinitionNames()){
			System.out.println("BEAN:"+name+" Class:"+ctx.getBean(name).getClass().getName());
		}
		
		IPersonService5 personService5 = ctx.getBean("serviceimpl1", IPersonService5.class);
		List<Person> persons = personService5.findPersons(null);
		for(Person p : persons){
			System.out.println(p);
		}
		
		Person p = new Person();
		p.setId(1005);
		p.setName("Lily52");
		personService5.addPerson(p);
		p.setName("Lily53");
		personService5.deletePerson(p);
		
	}

}
