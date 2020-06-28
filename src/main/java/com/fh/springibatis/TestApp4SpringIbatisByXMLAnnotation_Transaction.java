package com.fh.springibatis;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fh.dto.Person;
import com.fh.springibatis.service.IPersonService6Transaction;

public class TestApp4SpringIbatisByXMLAnnotation_Transaction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/springjdbcibatis/fhspring_ibatis_xmlannotation_transaction.xml");
		for(String name: ctx.getBeanDefinitionNames()){
			System.out.println("BEAN:"+name);
		}
		
		IPersonService6Transaction personService6 = ctx.getBean(IPersonService6Transaction.class);
		List<Person> persons = personService6.findPersons(null);
		for(Person p : persons){
			System.out.println(p);
		}
		
		try{
			Person p = new Person();
			p.setId(1005);
			p.setName("Lily52");
			personService6.testTransaction(p);
			/*personService6.addPerson(p);
			p.setName("Lily53");
			personService6.deletePerson(p);*/
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
