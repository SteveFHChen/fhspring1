package com.fh.springbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fh.dto.Person;

public class TestApp3UserDefineSpringXmlElement {

	/**
	 * User define element in spring xml configure file
	 * 1. Handler
	 * 2. Element parser
	 * 3. META-INF/spring.handlers and spring.schemas
	 * 4. If need, create META-INF/sprint-test.xsd to verify, also add xsd into Eclipse Preferencers -> XML Catalog
	 * 6. Use element in Spring xml configure file
	 * 7. Run application to test
	 * 
	 * The root Element can be any things, it's not important;
	 * Such as <beans>.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:springbeans/userDefineSpringXmlElement.xml");
		for(String s : ctx.getBeanDefinitionNames()){
			System.out.println("BEAN:"+s);
		}
		
		Person p1 = (Person)ctx.getBean("person1");
		System.out.println(p1);
		
		AbstractApplicationContext aac = (AbstractApplicationContext)ctx;
		aac.close();
	}

}
