package com.fh.springcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fh.config.AppConfig;
import com.fh.config.DBConfig;
import com.fh.dto.Person;

public class TestApp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:springcontext/TestApp1.xml");

		AppConfig appconfig = ctx.getBean(AppConfig.class);
		System.out.println("AppConfig DB driver: "+appconfig.getDbDriver());
		
		for(String s : ctx.getBeanDefinitionNames()){
			System.out.println("BEAN:"+s);
		}
		
		/*Person p1 = (Person)ctx.getBean("person1");
		System.out.println(p1);
		Person p2 = (Person)ctx.getBean("person2");
		System.out.println(p2);
		System.out.println( "P1 == P2 is "+(p1==p2 ? "true":"false"));
		System.out.println("BeanDefinitionCount: "+ctx.getBeanDefinitionCount());
		*/
		AbstractApplicationContext aac = (AbstractApplicationContext)ctx;
		
		//For test the spring context task schedule
		try {
			Thread.sleep(190*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aac.close();
	}

}
