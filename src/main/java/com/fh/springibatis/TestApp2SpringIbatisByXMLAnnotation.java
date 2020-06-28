package com.fh.springibatis;

import java.util.List;

import javax.sql.DataSource;

import oracle.jdbc.driver.OracleDriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;

import com.fh.dto.Person;
import com.fh.springibatis.service.IPersonService4;

public class TestApp2SpringIbatisByXMLAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/springjdbcibatis/fhspring_ibatis_xmlannotation.xml");
		for(String name: ctx.getBeanDefinitionNames()){
			System.out.println("BEAN:"+name);
		}
		
		IPersonService4 personService4 = ctx.getBean(IPersonService4.class);
		List<Person> persons = personService4.findPersons(null);
		for(Person p : persons){
			System.out.println(p);
		}
		
		Person p = new Person();
		p.setId(1005);
		p.setName("Lily52");
		personService4.addPerson(p);
		p.setName("Lily53");
		personService4.deletePerson(p);
		
	}

}
