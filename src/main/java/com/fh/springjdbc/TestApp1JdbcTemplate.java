package com.fh.springjdbc;

import java.util.List;

import javax.sql.DataSource;

import oracle.jdbc.driver.OracleDriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.fh.dto.Person;
import com.fh.springjdbc.service.IPersonService2;

@Configuration
@ComponentScan
public class TestApp1JdbcTemplate {

	@Autowired
	private DataSource ds;
	/**
	 * Please take care the order of @Bean, @Autowired, Constructor, @PostConstruct, init method
	 */
	
	@Bean
	DataSource newDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(OracleDriver.class.getName());
		ds.setUrl("jdbc:oracle:thin:@192.168.2.11:1522:prod");
		ds.setUsername("mydev1");
		ds.setPassword("oracle1");
//		this.ds = ds;
		return ds;
	}
	
	@Bean
	JdbcTemplate newJdbcTemplate(){
		/*DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(OracleDriver.class.getName());
		ds.setUrl("jdbc:oracle:thin:@192.168.2.11:1522:prod");
		ds.setUsername("mydev1");
		ds.setPassword("oracle1");*/
		
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(ds);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ds, false);
		return jdbcTemplate;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(TestApp1JdbcTemplate.class);
		for(String name: context.getBeanDefinitionNames()){
			System.out.println("BEAN:"+name);
		}
		
		IPersonService2 personService = context.getBean(IPersonService2.class);
		
		Person p1 = new Person();
		p1.setId(1005);
		p1.setName("Lily5");
		
		personService.addPerson(p1);
//		personService.deletePerson(p1);
		
		List<Person> persons = personService.findPersons(null);
		for(Person p : persons){
			System.out.println(p);
		}
	}

}
