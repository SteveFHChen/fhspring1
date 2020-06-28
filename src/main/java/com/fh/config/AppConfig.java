package com.fh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.fh.config2.JMXConfig;
import com.fh.config2.SFTPConfig;
import com.fh.dto.Person;

//@Configuration
//@ComponentScan("com.fh.service;"/*com.fh.postprocessor*/)
//@PropertySource("classpath:springcontext/testapp1.properties")
//@Import({JMXConfig.class, SFTPConfig.class})
public class AppConfig {

	/**
	 * use @Value to set value, no need setter.
	 */
	@Value("${jdbc.driver}")
	private String dbDriver;
	
	@Value("${jdbc.url}")
	private String dbUrl;
	
	@Value("${jdbc.username}")
	private String dbUserName;
	
	@Value("${jdbc.password}")
	private String dbPassword;
	
	public AppConfig(){
		System.out.println(this.getClass().getName()+" is constructing.");
		System.out.println("DB info:"+this.dbDriver);
	}
	
	/*@Autowired
	public void initConfiguration1(@Qualifier("person1")Person p1, @Qualifier("newTom")Person p2){
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called.");
		
		System.out.println("Parameter p1 is ["+p1+"] p2 is ["+p2+"]");
	}*/
	
	/*@Autowired
	public void initConfiguration1(){
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called.");
	}
	
	@Bean(name="beanJack", initMethod="init")
	public Person newJack(){
		String callerName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(this.getClass().getName()+"-"+callerName+" is called to create Jack.");
		
		Person p = new Person();
		p.setId(1003);
		p.setName("Jack");
		return p;
	}*/
	
	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}
	
	public void sayHello(){
		System.out.println("Hello world. - Test Spring Schedular.");
	}
	
}
