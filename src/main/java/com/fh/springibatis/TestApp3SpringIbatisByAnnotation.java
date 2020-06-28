package com.fh.springibatis;

import java.util.List;

import javax.sql.DataSource;

import oracle.jdbc.driver.OracleDriver;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;

import com.fh.dto.Person;
import com.fh.springibatis.service.IPersonService4;
import com.ibatis.sqlmap.client.SqlMapClient;

//@Configuration
//@ComponentScan
//@ComponentScan(excludeFilters={@Filter(value=TestApp1JdbcTemplate.class)})
public class TestApp3SpringIbatisByAnnotation {

	/**
	 * Please take care the order of @Bean, @Autowired, Constructor, @PostConstruct, init method
	 */
	
	@Autowired
	private DataSource ds;
	@Autowired
	private SqlMapClient sqlMapClient;
	
	@Bean
	public DataSource newDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(OracleDriver.class.getName());
		ds.setUrl("jdbc:oracle:thin:@192.168.2.11:1522:prod");
		ds.setUsername("mydev1");
		ds.setPassword("oracle1");
//		this.ds = ds;
		return ds;
	}
	
	@Bean
	public SqlMapClientFactoryBean newSqlMapClient(){
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(ds);
		
		SqlMapClientFactoryBean fb = new SqlMapClientFactoryBean();
		fb.setConfigLocation(new ClassPathResource("/springjdbcibatis/ibatis/fhtest1-config.xml"));
		fb.setDataSource(ds);
		return fb;
	}
	/**
	 * Please take care, the return bean implements FactoryBean and InitializingBean
	 * So Spring Ioc will call afterPropertiesSet() automatically, and create and inject SqlMapClient into Spring container.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(TestApp3SpringIbatisByAnnotation.class);
		for(String name: ctx.getBeanDefinitionNames()){
			System.out.println("BEAN:"+name+" Class:"+ctx.getBean(name).getClass().getName());
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
